package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Address.java
 *
 * Represents a physical address linked to a user.
 *
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 23-Jul-24
 */

@Getter
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String province;
    private String postalCode;
    private String country;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    // No-argument constructor for JPA and Hibernate
    public Address() {
    }

    public Address(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.addressLine1 = builder.addressLine1;
        this.addressLine2 = builder.addressLine2;
        this.city = builder.city;
        this.province = builder.province;
        this.postalCode = builder.postalCode;
        this.country = builder.country;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(user, address.user) &&
                Objects.equals(addressLine1, address.addressLine1) &&
                Objects.equals(addressLine2, address.addressLine2) &&
                Objects.equals(city, address.city) &&
                Objects.equals(province, address.province) &&
                Objects.equals(postalCode, address.postalCode) &&
                Objects.equals(country, address.country) &&
                Objects.equals(createdAt, address.createdAt) &&
                Objects.equals(updatedAt, address.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, addressLine1, addressLine2, city, province, postalCode, country, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Address{" +
                "Address ID: " + id +
                ", USER ID: " + (user != null ? user.getId() : "N/A") + // Display only user ID for clarity
                ", ADDRESS LINE 1: '" + addressLine1 + '\'' +
                ", ADDRESS LINE 2: '" + addressLine2 + '\'' +
                ", CITY: '" + city + '\'' +
                ", PROVINCE: '" + province + '\'' +
                ", POSTAL CODE: '" + postalCode + '\'' +
                ", COUNTRY: '" + country + '\'' +
                ", CREATED AT: " + createdAt +
                ", UPDATED AT: " + updatedAt +
                '}';
    }

    public static class Builder {
        private Long id;
        private User user;
        private String addressLine1;
        private String addressLine2;
        private String city;
        private String province;
        private String postalCode;
        private String country;
        private LocalDate createdAt;
        private LocalDate updatedAt;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
            return this;
        }

        public Builder setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
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

        public Builder copy(Address address) {
            this.id = address.getId();
            this.user = address.getUser();
            this.addressLine1 = address.getAddressLine1();
            this.addressLine2 = address.getAddressLine2();
            this.city = address.getCity();
            this.province = address.getProvince();
            this.postalCode = address.getPostalCode();
            this.country = address.getCountry();
            this.createdAt = address.getCreatedAt();
            this.updatedAt = address.getUpdatedAt();
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}
