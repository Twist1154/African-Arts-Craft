package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Customer.java
 *
 * @author Sibabalwe
 * @date 07 August 22024
 */
@Getter
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate createdAt;
    private LocalDate updatedAt;


    public Customer() {
    }

    public Customer(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
        this.phoneNumber = builder.phoneNumber;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(email, customer.email) && Objects.equals(password, customer.password) && Objects.equals(phoneNumber, customer.phoneNumber) && Objects.equals(createdAt, customer.createdAt) && Objects.equals(updatedAt, customer.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, password, phoneNumber, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer ID =" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phoneNumber;
        private LocalDate createdAt;
        private LocalDate updatedAt;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setCreatedAt(LocalDate createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDate updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder copy(Customer customer) {
            this.id = customer.id;
            this.firstName = customer.firstName;
            this.lastName = customer.lastName;
            this.email = customer.email;
            this.password = customer.password;
            this.phoneNumber = customer.phoneNumber;
            this.createdAt = customer.createdAt;
            this.updatedAt = customer.updatedAt;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }
}
