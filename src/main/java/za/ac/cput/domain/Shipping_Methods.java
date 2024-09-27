package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;

/**
 * ShippingMethods.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Getter
@Entity
public class Shipping_Methods implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double cost;
    private String delivery_time;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Shipping_Methods() {
    }

    public Shipping_Methods(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.cost = builder.cost;
        this.delivery_time = builder.delivery_time;
    }



    @Override
    public String toString() {
        return "Shipping_Methods{" +
                "Shipping Method ID: " + id +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", COST: " + cost +
                ", DELIVERY TIME: '" + delivery_time + '\'' +
                '}';
    }

    public static class Builder {
        private long id;
        private String name;
        private String description;
        private double cost;
        private String delivery_time;
        private Address address;

        public Builder setId(long id) {
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

        public Builder setDelivery_time(String delivery_time) {
            this.delivery_time = delivery_time;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(Shipping_Methods shipping_methods) {
            this.id = shipping_methods.getId();
            this.name = shipping_methods.getName();
            this.description = shipping_methods.getDescription();
            this.cost = shipping_methods.getCost();
            this.delivery_time = shipping_methods.getDelivery_time();
            return this;
        }

        public Shipping_Methods build() {
            return new Shipping_Methods(this);
        }
    }
}

