package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * CartFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class CartFactory {
    public static Cart buildCart(long id, User user, LocalDate created_at, LocalDate updated_at) {

        if (Helper.isNullOrEmpty(id) ||
                Helper.isNullOrEmpty(user) ||
                Helper.isNullOrEmpty(String.valueOf(created_at)) ||
                Helper.isNullOrEmpty(String.valueOf(updated_at))
        ) return null;

        return new Cart.Builder()
                .setId(id)
                .setUser(user)
                .setCreated_at(created_at)
                .setUpdated_at(updated_at)
                .build();
    }
}
