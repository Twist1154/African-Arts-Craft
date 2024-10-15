package za.ac.cput.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Product;
import za.ac.cput.domain.Wishlist;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WishlistFactoryTest {

    private User user;
    private Product product;
    private Wishlist wishlist;

    @BeforeEach
    void setup() {
        // Create a sample Product object
        product = new Product();

        // Set up a sample User object
        user = new User.Builder()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("johndoe@example.com")
                .setPassword("password123")
                .build();

        // Create a Wishlist object using the factory method
        wishlist = WishlistFactory.createWishlist(
                1L,
                user,
                product,  // Single product
                LocalDateTime.now()
        );
    }

    @Test
    void testCreateWishlist() {
        // Create a Wishlist object using the factory method
        wishlist = WishlistFactory.createWishlist(
                1L,
                user,
                product,  // Single product
                LocalDateTime.now()
        );

        // Verify that the Wishlist object is not null
        assertNotNull(wishlist);

        // Print the created Wishlist object to the terminal
        System.out.println("Created Wishlist: " + wishlist);
    }

    @Test
    void testCreateWishlist_WithNullUser_ThrowsIllegalArgumentException() {
        // Try to create a Wishlist object with null user
        assertThrows(IllegalArgumentException.class,
                () -> WishlistFactory.createWishlist(
                        1L,
                        null,
                        product,  // Single product
                        LocalDateTime.now()
                )
        );

        // Print a message to the terminal indicating that an exception was thrown
        System.out.println("Expected IllegalArgumentException thrown when creating Wishlist with null user");
    }

    @Test
    void testCreateWishlist_WithNullProduct_ThrowsIllegalArgumentException() {
        // Try to create a Wishlist object with null product
        assertThrows(IllegalArgumentException.class,
                () -> WishlistFactory.createWishlist(
                        1L,
                        user,
                        null,  // Null product
                        LocalDateTime.now()
                )
        );

        System.out.println("Expected IllegalArgumentException thrown when creating Wishlist with null product");
    }
}
