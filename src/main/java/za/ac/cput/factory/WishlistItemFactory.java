package za.ac.cput.factory;

import za.ac.cput.domain.Products;
import za.ac.cput.domain.Wishlist;
import za.ac.cput.domain.Wishlist_Items;
import za.ac.cput.util.Helper;

/**
 * WishlistItemFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */
public class WishlistItemFactory {
    public static Wishlist_Items buildWishlistItem(Long wishlist_item_id, Wishlist wishlist, Products product) {
        // Check if any of the IDs are null
        if (Helper.isNullOrEmpty(wishlist) || Helper.isNullOrEmpty(product)) {
            return null;
        }

        return new Wishlist_Items.Builder()
                .setWishlistItemId(wishlist_item_id)
                .setWishlist(wishlist)  // Use the variable directly
                .setProduct(product)    // Ensure method names match those in Wishlist_Items
                .build();
    }
}
