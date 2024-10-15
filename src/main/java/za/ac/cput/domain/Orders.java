package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Entity
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private double totalAmount;
    private String status;

    @ManyToOne
    private Address address;

    @OneToOne
    private Payments payment;
    @CreationTimestamp
    private LocalDate createdAt;
    @UpdateTimestamp
    private LocalDate updatedAt;

    public Orders() {
    }


    public Orders(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.totalAmount = builder.totalAmount;
        this.status = builder.status;
        this.address = builder.address;
        this.payment = builder.payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Double.compare(totalAmount, orders.totalAmount) == 0 &&
                Objects.equals(id, orders.id) &&
                Objects.equals(user, orders.user) &&
                Objects.equals(status, orders.status) &&
                Objects.equals(address, orders.address) &&
                Objects.equals(payment, orders.payment) &&
                Objects.equals(createdAt, orders.createdAt) &&
                Objects.equals(updatedAt, orders.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, totalAmount, status, address, payment, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "Order ID: " + id +
                ", USER: " + (user != null ? user.getId() : "null") +
                ", TOTAL AMOUNT: " + totalAmount +
                ", STATUS: '" + status + '\'' +
                ", SHIPPING ADDRESS: " + address +
                ", PAYMENT METHOD: " + payment +
                ", CREATED AT: " + createdAt +
                ", UPDATED AT: " + updatedAt +
                '}';
    }

    public static class Builder {
        private Long id;
        private User user;
        private double totalAmount;
        private String status;
        private Address address;
        private Payments payment;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setPayment(Payments payment) {
            this.payment = payment;
            return this;
        }

        public Builder copy(Orders orders) {
            this.id = orders.getId();
            this.user = orders.getUser();
            this.totalAmount = orders.getTotalAmount();
            this.status = orders.getStatus();
            this.address = orders.getAddress();
            this.payment = orders.getPayment();
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }
    }
}
