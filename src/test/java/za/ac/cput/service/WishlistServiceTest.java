package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.CategoryFactory;
import za.ac.cput.factory.SubCategoryFactory;
import za.ac.cput.repository.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class WishlistServiceTest {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private WishlistService wishlistService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoriesRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    private Wishlist wishlist;
    private Product product;
    private List<SubCategory> subCategories;
    private Category category;
    private User user;
    private List<WishlistItem> wishlistItems;
    @Autowired
    private SubCategoryService subCategoryService;

    @BeforeEach
    void setup() {
        // Set up Category and create to get generated ID
        category = CategoryFactory.buildCategory(
                null,
                "Sneakers"
        );
        category = categoryRepository.save(category); // Save the Category first

        // Create and create SubCategory objects
        SubCategory subCategory1 = SubCategoryFactory.createSubCategory(
                null, // Let the ID be generated
                category,
                product
        );
        SubCategory subCategory2 = SubCategoryFactory.createSubCategory(
                null, // Let the ID be generated
                category,
                product
        );

        // Save each SubCategory to generate the ID
        subCategory1 = subCategoryRepository.save(subCategory1);
        subCategory2 = subCategoryRepository.save(subCategory2);

        subCategories = List.of(subCategory1, subCategory2);

        // Create and create Product object (you need to initialize required fields)
        product = new Product();
        product = productRepository.save(product);

        // Set up User and create to get generated ID
        user = new User(); // Initialize with appropriate fields if needed
        user = userRepository.save(user);

        // Set up Wishlist and WishlistItems
        wishlist = new Wishlist.Builder()
                .setUser(user)
                .setCreatedAt(LocalDateTime.now())
                .build();
        wishlist = wishlistRepository.save(wishlist); // Save Wishlist first to get ID

        // Set up WishlistItems and reference the saved Product and Wishlist
        WishlistItem item1 = new WishlistItem.Builder()
                .setProduct(product)
                .setDateAdded(LocalDateTime.now())
                .setWishlist(wishlist)
                .build();
        WishlistItem item2 = new WishlistItem.Builder()
                .setProduct(product)
                .setDateAdded(LocalDateTime.now())
                .setWishlist(wishlist)
                .build();

        wishlistItems = List.of(item1, item2);

        wishlist = new Wishlist.Builder()
                .copy(wishlist)
                .setWishlistItems(wishlistItems)
                .build();

        wishlistRepository.save(wishlist); // Save again to persist WishlistItems
    }

    @AfterEach
    void tearDown() {
       /* wishlistRepository.deleteAll();
        userRepository.deleteAll(); // Clean up User repository
        productRepository.deleteAll(); // Clean up Product repository
        subCategoryRepository.deleteAll(); // Clean up SubCategory repository
        categoryRepository.deleteAll(); // Clean up Category repository*/
    }

    @Test
    @Order(1)
    void testCreateWishlist() {
        // Create a new Wishlist using the builder
        Wishlist newWishlist = new Wishlist.Builder()
                .setId(1L)
                .setUser(user)
                .setWishlistItems(wishlistItems) // Use existing WishlistItems
                .setCreatedAt(LocalDateTime.now())
                .build();
        Wishlist createdWishlist = wishlistService.create(newWishlist);

        // Assert that the created Wishlist is not null
        assertNotNull(createdWishlist);
        System.out.println("Created Wishlist: " + createdWishlist);
        assertEquals(newWishlist.getUser().getId(), createdWishlist.getUser().getId());
        assertEquals(newWishlist.getWishlistItems().size(), createdWishlist.getWishlistItems().size());
    }

    @Test
    @Order(2)
    void testReadWishlist() {
        Wishlist readWishlist = wishlistService.read(wishlist.getId());

        System.out.println("Read Wishlist: " + readWishlist);
        assertNotNull(readWishlist);
        assertEquals(wishlist.getUser().getId(), readWishlist.getUser().getId());
    }

    @Test
    @Order(3)
    void testUpdateWishlist() {
        wishlist = new Wishlist.Builder()
                .copy(wishlist)
                .setDeletedAt(LocalDateTime.now())
                .build()
        ; // Update wishlist to set deletedAt
        Wishlist updatedWishlist = wishlistService.update(wishlist);

        // Print the updated wishlist to the terminal
        System.out.println("Updated: " + updatedWishlist);
        System.out.println("--------------------------------------------------------------------");

        assertNotNull(updatedWishlist);
        assertEquals(wishlist.getUser().getId(), updatedWishlist.getUser().getId());
    }

    @Test
    @Order(4)
    void testDeleteWishlist() {
        // Delete the Wishlist using the service
        wishlistService.delete(wishlist.getId());
        Optional<Wishlist> deletedWishlist = wishlistRepository.findById(wishlist.getId());
        assertTrue(deletedWishlist.isEmpty());
    }

    @Test
    @Order(5)
    void testFindAllWishlists() {
        // Find all Wishlists using the service
        List<Wishlist> allWishlists = wishlistService.findAll();

        // Print all wishlists to the terminal
        System.out.println("All Wish Lists: " + allWishlists);
        System.out.println("--------------------------------------------------------------------");

        // Assert that the list of Wishlists is not null
        assertNotNull(allWishlists);
        assertFalse(allWishlists.isEmpty());
    }
}
