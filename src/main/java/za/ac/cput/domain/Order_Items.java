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
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    private int quantity;
    private double price;

    // No-argument constructor
    public Order_Items() {
    }

    // Builder-based constructor
    public Order_Items(Builder builder) {
        this.orderItemId = builder.orderItemId;
        this.order = builder.order;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    // Getters
    public Long getOrderItemId() {
        return orderItemId;
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
                "Order Item ID: " + orderItemId +
                ", ORDER ID: " + order.getOrderId() +
                ", PRODUCT ID: " + product.getId() +
                ", QUANTITY: " + quantity +
                ", PRICE: " + price +
                '}';
    }

    public static class Builder {
        private Long orderItemId;
        private Orders order;
        private Products product;
        private int quantity;
        private double price;

        public Builder setOrderItemId(Long orderItemId) {
            this.orderItemId = orderItemId;
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

        public Builder copy(Order_Items orderItems) {
            this.orderItemId = orderItems.getOrderItemId();
            this.order = orderItems.getOrder();
            this.product = orderItems.getProduct();
            this.quantity = orderItems.getQuantity();
            this.price = orderItems.getPrice();
            return this;
        }

        public Order_Items build() {
            return new Order_Items(this);
        }
    }
}
