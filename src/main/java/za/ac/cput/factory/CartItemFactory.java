package za.ac.cput.factory;

import za.ac.cput.domain.Cart_Items;
import za.ac.cput.util.Helper;

/**
 * CartItemFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class CartItemFactory {
    public static Cart_Items buildCartItem(long cart_item_id, long cart_id, long product_id,
                                           int quantity) {
        if (Helper.isNullOrEmpty(quantity)
        ) return null;

        return new Cart_Items.Builder()
                .setCart_item_id(cart_item_id)
                .setCart_id(cart_id)
                .setProduct_id(product_id)
                .setQuantity(quantity)
                .build();
    }
}
