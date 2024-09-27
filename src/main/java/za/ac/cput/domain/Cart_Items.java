package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

/**
 * Cart_Items.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Getter
@Entity
public class Cart_Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Products product;

    private int quantity;

    public Cart_Items() {
    }

    public Cart_Items(Builder builder) {
        this.id = builder.id;
        this.cart = builder.cart;
        this.product = builder.products;
        this.quantity = builder.quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart_Items cartItems = (Cart_Items) o;
        return id == cartItems.id && quantity == cartItems.quantity && Objects.equals(cart, cartItems.cart) && Objects.equals(product, cartItems.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cart, product, quantity);
    }

    @Override
    public String toString() {
        return "Cart_Items{" +
                "ID: " + id +
                ", CART : " + cart +
                ", PRODUCT : " + product +
                ", QUANTITY: " + quantity +
                '}';
    }

    public static class Builder {
        private long id;
        private Cart cart;
        private Products products;
        private int quantity;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setProducts(Products products) {
            this.products = products;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder copy(Cart_Items cart_items) {
            this.id = cart_items.getId();
            this.cart = cart_items.getCart();
            this.products = cart_items.getProduct();
            this.quantity = cart_items.getQuantity();
            return this;
        }

        public Cart_Items build() {
            return new Cart_Items(this);
        }
    }
}