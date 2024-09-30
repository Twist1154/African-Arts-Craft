package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

/**
 * ShippingMethods.java
 * <p>
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 23-Jul-24
 */
@Getter
@Entity
public class ShippingMethods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double cost;
    private String deliveryTime;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public ShippingMethods() {
    }

    public ShippingMethods(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.cost = builder.cost;
        this.deliveryTime = builder.deliveryTime;
        this.address = builder.address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingMethods that = (ShippingMethods) o;
        return Double.compare(that.cost, cost) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(description, that.description) &&
                Objects.equals(deliveryTime, that.deliveryTime) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, cost, deliveryTime, address);
    }

    @Override
    public String toString() {
        return "ShippingMethods{" +
                "Shipping Method ID: " + id +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", COST: " + cost +
                ", DELIVERY TIME: '" + deliveryTime + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private double cost;
        private String deliveryTime;
        private Address address;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setCost(double cost) {
            this.cost = cost;
            return this;
        }

        public Builder setDeliveryTime(String deliveryTime) {
            this.deliveryTime = deliveryTime;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(ShippingMethods shippingMethods) {
            this.id = shippingMethods.getId();
            this.name = shippingMethods.getName();
            this.description = shippingMethods.getDescription();
            this.cost = shippingMethods.getCost();
            this.deliveryTime = shippingMethods.getDeliveryTime();
            this.address = shippingMethods.getAddress();
            return this;
        }

        public ShippingMethods build() {
            return new ShippingMethods(this);
        }
    }
}
