package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItems;
import za.ac.cput.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {

    @Test
    void buildCartItem() {

        Cart cart = new Cart();
        Product product = new Product();

        CartItems cartItem = CartItemFactory.buildCartItem(12L, cart, product, 123);

        assertNotNull(cartItem);
        assertEquals(12L, cartItem.getId());
        assertEquals(13L, cartItem.getId());
        assertEquals(14L, cartItem.getId());
        assertEquals(123L, cartItem.getQuantity());
    }
}