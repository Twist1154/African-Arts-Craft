package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.domain.Products;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {

    @Test
    void buildCartItem() {

        Cart cart = new Cart();
        Products product = new Products();

        Cart_Items cartItem = CartItemFactory.buildCartItem(012L, cart, product, 123);

        assertNotNull(cartItem);
        assertEquals(012, cartItem.getId());
        assertEquals(013, cartItem.getId());
        assertEquals(014, cartItem.getId());
        assertEquals(123, cartItem.getQuantity());
    }
}