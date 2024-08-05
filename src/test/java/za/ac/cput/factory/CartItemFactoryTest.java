package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart_Items;

import static org.junit.jupiter.api.Assertions.*;

class CartItemFactoryTest {

    @Test
    void buildCartItem() {

        Cart_Items cartItem = CartItemFactory.buildCartItem(1, 100, 200, 5);

        assertNotNull(cartItem);
        assertEquals(1, cartItem.getCart_item_id());
        assertEquals(100, cartItem.getCart_id());
        assertEquals(200, cartItem.getProduct_id());
        assertEquals(5, cartItem.getQuantity());
    }
}