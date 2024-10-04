package za.ac.cput.domain;

/**
 * Payments.java
 *
 * @author Sibusiso Kubalo
 * Student Num: 218316038
 */

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Entity
public class Payments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    private double paymentAmount;
    private String paymentMethod;
    private String paymentStatus;
    private LocalDate paymentDate;

    public Payments() {
    }

    public Payments(Builder builder) {
        this.id = builder.id;
        this.order = builder.order;
        this.paymentAmount = builder.paymentAmount;
        this.paymentMethod = builder.paymentMethod;
        this.paymentStatus = builder.paymentStatus;
        this.paymentDate = builder.paymentDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments = (Payments) o;
        return id == payments.id &&
                Double.compare(paymentAmount, payments.paymentAmount) == 0 &&
                Objects.equals(order, payments.order) &&
                Objects.equals(paymentDate, payments.paymentDate) &&
                Objects.equals(paymentMethod, payments.paymentMethod) &&
                Objects.equals(paymentStatus, payments.paymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, paymentDate, paymentAmount, paymentMethod, paymentStatus);
    }

    @Override
    public String toString() {
        return "Payments{" +
                "Payment ID: " + id +
                ", ORDER : " + (order != null ? order.getId() : "N/A") +
                ", PAYMENT DATE: " + paymentDate +
                ", PAYMENT AMOUNT: " + paymentAmount +
                ", PAYMENT METHOD: '" + paymentMethod + '\'' +
                ", PAYMENT STATUS: '" + paymentStatus + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private Orders order;
        private double paymentAmount;
        private String paymentMethod;
        private String paymentStatus;
        private LocalDate paymentDate;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setOrders(Orders order) {
            this.order = order;
            return this;
        }

        public Builder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public Builder setPaymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setPaymentStatus(String paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder copy(Payments payments) {
            this.id = payments.getId();
            this.order = payments.getOrder();
            this.paymentDate = payments.getPaymentDate();
            this.paymentAmount = payments.getPaymentAmount();
            this.paymentMethod = payments.getPaymentMethod();
            this.paymentStatus = payments.getPaymentStatus();
            return this;
        }

        public Payments build() {
            return new Payments(this);
        }
    }
}