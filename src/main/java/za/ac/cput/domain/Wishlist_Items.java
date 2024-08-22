package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Wishlist_Items.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Wishlist_Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistItemId;

    @ManyToOne
    @JoinColumn(name = "wishlist_id", referencedColumnName = "wishlist_id", nullable = false)
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    private Products product;

    // No-argument constructor
    public Wishlist_Items() {
    }

    // Builder-based constructor
    public Wishlist_Items(Builder builder) {
        this.wishlistItemId = builder.wishlistItemId;
        this.wishlist = builder.wishlist;
        this.product = builder.product;
    }

    // Getters
    public Long getWishlistItemId() {
        return wishlistItemId;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public Products getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "Wishlist_Items{" +
                "Wishlist Item ID: " + wishlistItemId +
                ", WISHLIST ID: " + wishlist.getWishlist_id() +
                ", PRODUCT ID: " + product.getProductId() +
                '}';
    }

    public static class Builder {
        private Long wishlistItemId;
        private Wishlist wishlist;
        private Products product;

        public Builder setWishlistItemId(Long wishlistItemId) {
            this.wishlistItemId = wishlistItemId;
            return this;
        }

        public Builder setWishlist(Wishlist wishlist) {
            this.wishlist = wishlist;
            return this;
        }

        public Builder setProduct(Products product) {
            this.product = product;
            return this;
        }

        public Builder copy(Wishlist_Items wishlistItems) {
            this.wishlistItemId = wishlistItems.getWishlistItemId();
            this.wishlist = wishlistItems.getWishlist();
            this.product = wishlistItems.getProduct();
            return this;
        }

        public Wishlist_Items build() {
            return new Wishlist_Items(this);
        }
    }
}

