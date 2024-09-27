package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Cart_Items;
import za.ac.cput.domain.Products;
import za.ac.cput.util.Helper;

/**
 * CartItemFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class CartItemFactory {
    public static Cart_Items buildCartItem(long id, Cart cart, Products products,
                                           int quantity) {
        if (Helper.isNullOrEmpty(id) ||
                Helper.isNullOrEmpty(cart) ||
                Helper.isNullOrEmpty(products) ||
                Helper.isNullOrEmpty(quantity)
        ) return null;

        return new Cart_Items.Builder()
                .setId(id)
                .setCart(cart)
                .setProducts(products)
                .setQuantity(quantity)
                .build();
    }
}
