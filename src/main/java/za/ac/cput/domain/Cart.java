package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Cart.java
 *
 * Represents a shopping cart associated with a user.
 *
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 23-Jul-24
 */
@Getter
@Entity
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double total;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<CartItems> cartItems;

    public Cart() {
    }

    private Cart(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.total = builder.total;
    }

    @Override
    public String toString() {
        return "\n Cart{" +
                "id=" + id +
                ", user=" + (user != null ? user.getFirstName() : "null") +
                ", total=" + total +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(user, cart.user) &&
                Objects.equals(total, cart.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, total);
    }

    public static class Builder {
        private Long id;
        private User user;
        private Double total;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setTotal(Double total) {
            this.total = total;
            return this;
        }

        public Builder copy(Cart cart) {
            this.id = cart.getId();
            this.user = cart.getUser();
            this.total = cart.getTotal();
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}
