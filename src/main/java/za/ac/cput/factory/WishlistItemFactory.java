package za.ac.cput.factory;


import za.ac.cput.domain.Products;
import za.ac.cput.domain.WishlistItem;
import za.ac.cput.domain.Wishlist;

import java.time.LocalDateTime;

/**
 * Factory class for creating instances of {@link WishlistItem}.
 * Provides static methods to create {@link WishlistItem} objects from various inputs.
 *
 * Author: Rethabile Ntsekhe
 * Date: 20-Sep-24
 */
public class WishlistItemFactory {

    /**
     * Creates a {@link WishlistItem} instance with the necessary parameters.
     *
     * @param products  the {@link Products} associated with this wishlist item
     * @param wishlist  the {@link Wishlist} this item belongs to
     * @param dateAdded the date when the item was added to the wishlist
     * @return a new {@link WishlistItem} object with properties set from the input parameters
     */
    public static WishlistItem createWishlistItem(Products products, Wishlist wishlist, LocalDateTime dateAdded) {
        if (products == null) {
            throw new IllegalArgumentException("Product cannot be null in WishlistItemFactory");
        }

        if (wishlist == null) {
            throw new IllegalArgumentException("Wishlist cannot be null in WishlistItemFactory");
        }

        // Set default value if dateAdded is null
        if (dateAdded == null) {
            dateAdded = LocalDateTime.now();
        }

        return new WishlistItem.Builder()
                .setProducts(products)
                .setWishlist(wishlist)
                .setDateAdded(dateAdded)
                .build();
    }
}
