package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Address.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Getter
@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String address_line1;
    private String address_line2;
    private String city;
    private String province;
    private String postal_code;
    private String country;
    private LocalDate created_at;
    private LocalDate updated_at;

    public Address() {
    }

    public Address(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.address_line1 = builder.address_line1;
        this.address_line2 = builder.address_line2;
        this.city = builder.city;
        this.province = builder.province;
        this.postal_code = builder.postal_code;
        this.country = builder.country;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id && Objects.equals(user, address.user) && Objects.equals(address_line1, address.address_line1) && Objects.equals(address_line2, address.address_line2) && Objects.equals(city, address.city) && Objects.equals(province, address.province) && Objects.equals(postal_code, address.postal_code) && Objects.equals(country, address.country) && Objects.equals(created_at, address.created_at) && Objects.equals(updated_at, address.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, address_line1, address_line2, city, province, postal_code, country, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "Address{" +
                "Address ID: " + id +
                ", USER ID: " + user +
                ", ADDRESS LINE1: '" + address_line1 + '\'' +
                ", ADDRESS LINE2: '" + address_line2 + '\'' +
                ", CITY: '" + city + '\'' +
                ", PROVINCE: '" + province + '\'' +
                ", POSTAL CODE: '" + postal_code + '\'' +
                ", COUNTRY: '" + country + '\'' +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                '}';
    }

    public static class Builder {
        private long id;
        private User user;
        private String address_line1;
        private String address_line2;
        private String city;
        private String province;
        private String postal_code;
        private String country;
        private LocalDate created_at;
        private LocalDate updated_at;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setAddress_line1(String address_line1) {
            this.address_line1 = address_line1;
            return this;
        }

        public Builder setAddress_line2(String address_line2) {
            this.address_line2 = address_line2;
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

        public Builder setPostal_code(String postal_code) {
            this.postal_code = postal_code;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
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

        public Builder copy(Address address) {
            this.id = address.getId();
            this.user = address.getUser();
            this.address_line1 = address.getAddress_line1();
            this.address_line2 = address.getAddress_line2();
            this.city = address.getCity();
            this.province = address.getProvince();
            this.postal_code = address.getPostal_code();
            this.country = address.getCountry();
            this.created_at = address.getCreated_at();
            this.updated_at = address.getUpdated_at();
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}

