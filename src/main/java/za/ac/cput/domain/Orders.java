package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * Orders.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order_Items> orderItems;

    private double total_amount;
    private LocalDate order_date;
    private String status;
    private String shipping_address;
    private String billing_address;
    private String payment_method;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Orders() {
    }

    // Builder-based constructor
    public Orders(Builder builder) {
        this.orderId = builder.orderId;
        this.user = builder.user;
        this.total_amount = builder.total_amount;
        this.order_date = builder.order_date;
        this.status = builder.status;
        this.shipping_address = builder.shipping_address;
        this.billing_address = builder.billing_address;
        this.payment_method = builder.payment_method;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }

    // Getters
    public Long getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public List<Order_Items> getOrderItems() {
        return orderItems;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public String getStatus() {
        return status;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "Order ID: " + orderId +
                ", USER: " + user.getId() +
                ", TOTAL AMOUNT: " + total_amount +
                ", ORDER DATE: " + order_date +
                ", STATUS: '" + status + '\'' +
                ", SHIPPING ADDRESS: '" + shipping_address + '\'' +
                ", BILLING ADDRESS: '" + billing_address + '\'' +
                ", PAYMENT METHOD: '" + payment_method + '\'' +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                '}';
    }

    public static class Builder {
        private Long orderId;
        private User user;
        private double total_amount;
        private LocalDate order_date;
        private String status;
        private String shipping_address;
        private String billing_address;
        private String payment_method;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setOrderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setTotal_amount(double total_amount) {
            this.total_amount = total_amount;
            return this;
        }

        public Builder setOrder_date(LocalDate order_date) {
            this.order_date = order_date;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setShipping_address(String shipping_address) {
            this.shipping_address = shipping_address;
            return this;
        }

        public Builder setBilling_address(String billing_address) {
            this.billing_address = billing_address;
            return this;
        }

        public Builder setPayment_method(String payment_method) {
            this.payment_method = payment_method;
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

        public Builder copy(Orders orders) {
            this.orderId = orders.getOrderId();
            this.user = orders.getUser();
            this.total_amount = orders.getTotal_amount();
            this.order_date = orders.getOrder_date();
            this.status = orders.getStatus();
            this.shipping_address = orders.getShipping_address();
            this.billing_address = orders.getBilling_address();
            this.payment_method = orders.getPayment_method();
            this.created_at = orders.getCreated_at();
            this.updated_at = orders.getUpdated_at();
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }
    }
}
