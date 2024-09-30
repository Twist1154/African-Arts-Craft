package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Entity
public class OrderItem implements Serializable { // Changed class name to singular

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(Builder builder) {
        this.id = builder.id;
        this.order = builder.order;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.price = builder.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem that = (OrderItem) o;
        return quantity == that.quantity && Double.compare(price, that.price) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(order, that.order) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, product, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "Order Item ID: " + id +
                ", ORDER ID: " + (order != null ? order.getId() : "N/A") + // Null check for safety
                ", PRODUCT ID: " + (product != null ? product.getName() : "N/A") + // Null check for safety
                ", QUANTITY: " + quantity +
                ", PRICE: " + price +
                '}';
    }

    public static class Builder {
        private Long id;
        private Orders order;
        private Product product;
        private int quantity;
        private double price;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setOrder(Orders order) {
            this.order = order;
            return this;
        }

        public Builder setProduct(Product product) {
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

        public Builder copy(OrderItem orderItems) {
            this.id = orderItems.getId();
            this.order = orderItems.getOrder();
            this.product = orderItems.getProduct();
            this.quantity = orderItems.getQuantity();
            this.price = orderItems.getPrice();
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }
}
