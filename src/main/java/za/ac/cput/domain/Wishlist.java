package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Wishlists.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */


@Entity
public class Wishlist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlist_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private Users user;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Wishlist_Items> wishlistItems;

    private LocalDate created_at;

    // No-argument constructor
    public Wishlist() {
    }

    // Builder-based constructor
    public Wishlist(Builder builder) {
        this.wishlist_id = builder.wishlist_id;
        this.user = builder.user;
        this.created_at = builder.created_at;
    }

    // Getters
    public Long getWishlist_id() {
        return wishlist_id;
    }

    public Users getUser() {
        return user;
    }

    public List<Wishlist_Items> getWishlistItems() {
        return wishlistItems;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wishlist wishlist)) return false;
        return Objects.equals(wishlist_id, wishlist.wishlist_id) && Objects.equals(user, wishlist.user) && Objects.equals(wishlistItems, wishlist.wishlistItems) && Objects.equals(created_at, wishlist.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wishlist_id, user, wishlistItems, created_at);
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "Wishlist ID: " + wishlist_id +
                ", USER: " + user.getUser_id() +
                ", CREATED AT: " + created_at +
                '}';
    }

    public static class Builder {
        private Long wishlist_id;
        private Users user;
        private LocalDate created_at;

        public Builder setWishlist_id(Long wishlist_id) {
            this.wishlist_id = wishlist_id;
            return this;
        }

        public Builder setUser(Users user) {
            this.user = user;
            return this;
        }

        public Builder setCreated_at(LocalDate created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder copy(Wishlist wishlist) {
            this.wishlist_id = wishlist.getWishlist_id();
            this.user = wishlist.getUser();
            this.created_at = wishlist.getCreated_at();
            return this;
        }

        public Wishlist build() {
            return new Wishlist(this);
        }
    }
}
