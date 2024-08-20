package za.ac.cput.domain;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Order_Items.java
 *
 * @author Rethabile Ntsekhe
 * @author Sibabalwe Ngandana
 * Student Num: 220455430
 * Student Num: 220193894
 * @date 23-Jul-24
 */

@Entity
public class Order_Items implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_item_id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId", nullable = false)
    private Products product;

    private int quantity;
    private double price;

    // No-argument constructor
    public Order_Items() {
    }

    // Builder-based constructor
    public Order_Items(Builder builder) {
        this.order_item_id = builder.order_item_id;
        this.order = builder.order;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    // Getters
    public long getOrder_item_id() {
        return order_item_id;
    }

    public Orders getOrder() {
        return order;
    }

    public Products getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order_Items{" +
                "Order Item ID: " + order_item_id +
                ", ORDER ID: " + order.getOrder_id() +
                ", PRODUCT ID: " + product.getProductId() +
                ", QUANTITY: " + quantity +
                ", PRICE: " + price +
                '}';
    }

    public static class Builder {
        private long order_item_id;
        private Orders order;
        private Products product;
        private int quantity;
        private double price;

        public Builder setOrder_item_id(long order_item_id) {
            this.order_item_id = order_item_id;
            return this;
        }

        public Builder setOrder(Orders order) {
            this.order = order;
            return this;
        }

        public Builder setProduct(Products product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder copy(Order_Items order_items) {
            this.order_item_id = order_items.getOrder_item_id();
            this.order = order_items.getOrder();
            this.product = order_items.getProduct();
            this.quantity = order_items.getQuantity();
            this.price = order_items.getPrice();
            return this;
        }

        public Order_Items build() {
            return new Order_Items(this);
        }
    }
}

