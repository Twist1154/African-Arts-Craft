package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

/**
 * CartItems.java
 * <p>
 * Represents items in a shopping cart.
 * <p>
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 23-Jul-24
 */
@Getter
@Entity
public class CartItems implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    public CartItems() {
    }

    public CartItems(Builder builder) {
        this.id = builder.id;
        this.cart = builder.cart;
        this.product = builder.product;
        this.quantity = builder.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItems cartItems = (CartItems) o;
        return quantity == cartItems.quantity &&
                Objects.equals(id, cartItems.id) &&
                Objects.equals(cart, cartItems.cart) &&
                Objects.equals(product, cartItems.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cart, product, quantity);
    }

    @Override
    public String toString() {
        return "CartItems{" +
                "ID: " + id +
                ", Cart ID: " + (cart != null ? cart.getId() : "N/A") +
                ", Product ID: " + (product != null ? product.getName() : "N/A") +
                ", Quantity: " + quantity +
                '}';
    }

    public static class Builder {
        private Long id;
        private Cart cart;
        private Product product;
        private int quantity;

        public Builder setId(Long id) { // Use Long instead of long for consistency
            this.id = id;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setProduct(Product product) { // Renamed from `products` to `product` to match main class field
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(CartItems cartItems) {
            this.id = cartItems.getId();
            this.cart = cartItems.getCart();
            this.product = cartItems.getProduct();
            this.quantity = cartItems.getQuantity();
            return this;
        }

        public CartItems build() {
            return new CartItems(this);
        }
    }
}
