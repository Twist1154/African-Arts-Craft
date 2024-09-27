package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * CartController.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */
@Getter
@Entity
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDate created_at;
    private LocalDate updated_at;

    public Cart() {
    }

    public Cart(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && Objects.equals(user, cart.user) && Objects.equals(created_at, cart.created_at) && Objects.equals(updated_at, cart.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "ID: " + id +
                ", USER : " + user +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                '}';
    }

    public static class Builder {
        private long id;
        private User user;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setCreated_at(LocalDate created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder setUpdated_at(LocalDate updated_at) {
            this.updated_at = updated_at;
            return this;
        }

        public Builder copy(Cart cart) {
            this.id = cart.getId();
            this.user = cart.getUser();
            this.created_at = cart.getCreated_at();
            this.updated_at = cart.getUpdated_at();
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}