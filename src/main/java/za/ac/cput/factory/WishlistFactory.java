package za.ac.cput.factory;

import za.ac.cput.domain.Users;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.util.List;

/**
 * WishlistFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */
public class WishlistFactory {
    public static Wishlist buildWishlist(Long wishlist_id, Users user, LocalDate created_at) {
        if (Helper.isNullOrEmpty(user.toString()) ||
                Helper.isNullOrEmpty(user.toString())
        ) return null;

        return new Wishlist.Builder()
                .setWishlist_id(wishlist_id)
                .setUser(user)
                .setCreated_at(created_at)
                .build();
    }
}
