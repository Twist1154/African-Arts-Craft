package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * CartFactory.java
 *
 * @author Masithembe Ndzotyana
 * Student Num: 219145091
 * 23 Aug 2024
 */

public class CartFactory {
    public static Cart buildCart(long cart_id, long userId, LocalDate created_at, LocalDate updated_at) {

        if (Helper.isNullOrEmpty(cart_id) ||
                Helper.isNullOrEmpty(userId) ||
                Helper.isNullOrEmpty(String.valueOf(created_at)) ||
                Helper.isNullOrEmpty(String.valueOf(updated_at))
        ) return null;

        return new Cart.Builder()
                .setCart_id(cart_id)
                .setUser_id(userId)
                .setCreated_at(created_at)
                .setUpdated_at(updated_at)
                .build();
    }
}
