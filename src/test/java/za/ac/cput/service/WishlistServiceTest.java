package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
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

    private Wishlist wishlist;
    private Product product;
    private User user;
    private Product item1;  // Declared here as an instance variable

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @BeforeEach
    void setup() {
        user = userService.read(1L);
        assertNotNull(user, "User should not be null in setup");

        // Fetch Products from service for testing
        item1 = productService.read(1L);  // Remove 'public static'

        // Ensure products are retrieved correctly
        assertNotNull(item1, "Item1 should not be null");

        // Initialize the wishlist
        wishlist = new Wishlist.Builder()
                .setId(null) // Set ID to null for Hibernate to auto-generate
                .setUser(user)
                .setProduct(item1)  // Use item1 here
                .setCreatedAt(LocalDateTime.now())
                .build();

        wishlistRepository.save(wishlist); // Save to persist the wishlist

        // Print the initial wishlist for debugging
        System.out.println("Setup - Saved Wishlist: " + wishlist);
    }

    @Test
    @Order(1)
    void testCreateWishlist() {
        // Create a new Wishlist
        Wishlist newWishlist = new Wishlist.Builder()
                .setId(null)
                .setUser(user)
                .setProduct(item1)  // Use item1 here
                .setCreatedAt(LocalDateTime.now())
                .build();
        Wishlist createdWishlist = wishlistService.create(newWishlist);

        // Assert that the created Wishlist is not null
        assertNotNull(createdWishlist, "Created Wishlist should not be null");

        // Print created wishlist details
        System.out.println("Created Wishlist: " + createdWishlist);

        assertEquals(newWishlist.getUser().getId(), createdWishlist.getUser().getId());
        assertEquals(newWishlist.getProduct().getId(), createdWishlist.getProduct().getId());
    }

    @Test
    @Order(2)
    void testReadWishlist() {
        Wishlist readWishlist = wishlistService.read(wishlist.getId());

        assertNotNull(readWishlist, "Read Wishlist should not be null");

        // Print the read wishlist details
        System.out.println("Read Wishlist: " + readWishlist);

        assertEquals(wishlist.getUser().getId(), readWishlist.getUser().getId());
    }

    @Test
    @Order(3)
    void testUpdateWishlist() {
        wishlist = new Wishlist.Builder()
                .copy(wishlist)
                .build(); // Update wishlist with deletedAt timestamp
        Wishlist updatedWishlist = wishlistService.update(wishlist);

        // Print the updated wishlist details
        System.out.println("Updated Wishlist: " + updatedWishlist);

        // Assert that the wishlist is updated
        assertNotNull(updatedWishlist, "Updated Wishlist should not be null");
        assertEquals(wishlist.getUser().getId(), updatedWishlist.getUser().getId());
    }

    @Test
    @Order(4)
    void testDeleteWishlist() {
        wishlistService.delete(wishlist.getId());
        Optional<Wishlist> deletedWishlist = wishlistRepository.findById(wishlist.getId());

        // Print a message indicating the deletion result
        System.out.println("Deleted Wishlist: " + (deletedWishlist.isEmpty() ? "Success" : "Failed"));

        // Assert that the wishlist was deleted
        assertTrue(deletedWishlist.isEmpty(), "Wishlist should be deleted");
    }

    @Test
    @Order(5)
    void testFindAllWishlists() {
        List<Wishlist> allWishlists = wishlistService.findAll();

        // Print all wishlists
        System.out.println("All Wishlists: " + allWishlists);

        // Assert that the list of Wishlists is not null
        assertNotNull(allWishlists, "List of wishlists should not be null");
        assertFalse(allWishlists.isEmpty(), "Wishlist list should not be empty");
    }
}
