package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * WishlistItem.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 20-Sep-24
 */

@Entity
@Getter
@Table(name = "wish_list_items")
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products products;


    private LocalDateTime dateAdded;

    @ManyToOne
    @JoinColumn(name = "wishlist_id")
    private Wishlist wishlist;

    public WishlistItem() {
    }

    public WishlistItem(Builder builder) {
        this.id = builder.id;
        this.products = builder.products;
        this.dateAdded = builder.dateAdded;
        this.wishlist = builder.wishlist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WishlistItem that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(products, that.products) && Objects.equals(dateAdded, that.dateAdded) && Objects.equals(wishlist, that.wishlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products, dateAdded, wishlist);
    }

    @Override
    public String toString() {
        return "\n WishlistItem{" +
                "id=" + id +
                ", product=" + products.getName() +
                ", dateAdded=" + dateAdded +
                ", wishlist=" + wishlist.getId() +
                "}\n";
    }

    public static class Builder {
        private Long id;
        private Products products;
        private LocalDateTime dateAdded;
        private Wishlist wishlist;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setProducts(Products products) {
            this.products = products;
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
            this.id = wishlistItem.id;
            this.products = wishlistItem.products;
            this.dateAdded = wishlistItem.dateAdded;
            this.wishlist = wishlistItem.wishlist;
            return this;
        }

        public WishlistItem build() {
            return new WishlistItem(this);
        }
    }
}
