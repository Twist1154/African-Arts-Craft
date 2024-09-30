package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Represents an item within a wishlist.
 * Each WishlistItem is associated with a single product and belongs to a Wishlist.
 *
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 20-Sep-24
 */
@Entity
@Getter
@Table(name = "wish_list_items")
public class WishlistItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;  // Single product in the wishlist item

    private LocalDateTime dateAdded;

    @ManyToOne(fetch = FetchType.LAZY)  // Use lazy fetching to defer loading until needed
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    // Default constructor made private to enforce Builder usage
    public WishlistItem() {
    }

    public WishlistItem(Builder builder) {
        this.id = builder.id;
        this.product = builder.product;
        this.dateAdded = builder.dateAdded;
        this.wishlist = builder.wishlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishlistItem that)) return false;
        return Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(dateAdded, that.dateAdded) &&
                Objects.equals(wishlist, that.wishlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, dateAdded, wishlist);
    }

    @Override
    public String toString() {
        return "\n WishlistItem{" +
                "id=" + id +
                ", product=" + (product != null ? product.getName() : "N/A") +
                ", dateAdded=" + dateAdded +
                ", wishlist=" + (wishlist != null ? wishlist.getId() : "N/A") +
                "}\n";
    }

    /**
     * Builder pattern class for WishlistItem.
     * Facilitates easy construction and immutability of WishlistItem objects.
     */
    public static class Builder {
        private Long id;
        private Product product;
        private LocalDateTime dateAdded;
        private Wishlist wishlist;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setDateAdded(LocalDateTime dateAdded) {
            this.dateAdded = dateAdded;
            return this;
        }

        public Builder setWishlist(Wishlist wishlist) {
            this.wishlist = wishlist;
            return this;
        }

        public Builder copy(WishlistItem wishlistItem) {
            this.id = wishlistItem.getId();
            this.product = wishlistItem.getProduct();
            this.dateAdded = wishlistItem.getDateAdded();
            this.wishlist = wishlistItem.getWishlist();
            return this;
        }

        public WishlistItem build() {
            return new WishlistItem(this);
        }
    }
}
