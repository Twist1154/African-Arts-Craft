package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartItems;
import za.ac.cput.domain.Product;
import za.ac.cput.util.Helper;

/**
 * CartItemFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class CartItemFactory {
    public static CartItems buildCartItem(Long id,
                                          Cart cart,
                                          Product product,
                                          int quantity) {
        if (Helper.isNullOrEmpty(id) ||
                Helper.isNullOrEmpty(cart) ||
                Helper.isNullOrEmpty(product) ||
                Helper.isNullOrEmpty(quantity)
        ) return null;

        return new CartItems.Builder()
                .setId(id)
                .setCart(cart)
                .setProduct(product)
                .setQuantity(quantity)
                .build();
    }
}
