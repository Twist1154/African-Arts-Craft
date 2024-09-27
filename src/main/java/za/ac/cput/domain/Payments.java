package za.ac.cput.domain;

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
    private long id;
    @OneToOne
    private Orders order;
    private LocalDate payment_date;
    private double payment_amount;
    private String payment_method;
    private String payment_status;

    public Payments() {
    }

    public Payments(Builder builder) {
        this.id = builder.id;
        this.order = builder.order;
        this.payment_date = builder.payment_date;
        this.payment_amount = builder.payment_amount;
        this.payment_method = builder.payment_method;
        this.payment_status = builder.payment_status;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments = (Payments) o;
        return id == payments.id && Double.compare(payment_amount, payments.payment_amount) == 0 && Objects.equals(order, payments.order) && Objects.equals(payment_date, payments.payment_date) && Objects.equals(payment_method, payments.payment_method) && Objects.equals(payment_status, payments.payment_status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, payment_date, payment_amount, payment_method, payment_status);
    }

    @Override
    public String toString() {
        return "Payments{" +
                "Payment ID: " + id +
                ", ORDER : " + order +
                ", PAYMENT DATE: " + payment_date +
                ", PAYMENT AMOUNT: " + payment_amount +
                ", PAYMENT METHOD: '" + payment_method + '\'' +
                ", PAYMENT STATUS: '" + payment_status + '\'' +
                '}';
    }

    public static class Builder {
        private long id;
        private Orders order;
        private LocalDate payment_date;
        private double payment_amount;
        private String payment_method;
        private String payment_status;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setOrders(Orders order) {
            this.order = order;
            return this;
        }

        public Builder setPayment_date(LocalDate payment_date) {
            this.payment_date = payment_date;
            return this;
        }

        public Builder setPayment_amount(double payment_amount) {
            this.payment_amount = payment_amount;
            return this;
        }

        public Builder setPayment_method(String payment_method) {
            this.payment_method = payment_method;
            return this;
        }

        public Builder setPayment_status(String payment_status) {
            this.payment_status = payment_status;
            return this;
        }

        public Builder copy(Payments payments) {
            this.id = payments.getId();
            this.order = payments.getOrder();
            this.payment_date = payments.getPayment_date();
            this.payment_amount = payments.getPayment_amount();
            this.payment_method = payments.getPayment_method();
            this.payment_status = payments.getPayment_status();
            return this;
        }

        public Payments build() {
            return new Payments(this);
        }
    }
}