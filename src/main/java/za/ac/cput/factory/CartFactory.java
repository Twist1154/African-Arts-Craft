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
    public static Cart buildCart(Long id,
                                 User user,
                                 Double total
    ) {

        if (Helper.isNullOrEmpty(id) ||
                Helper.isNullOrEmpty(user)
        ) return null;

        return new Cart.Builder()
                .setId(id)
                .setUser(user)
                .setTotal(total)
                .build();
    }
}
