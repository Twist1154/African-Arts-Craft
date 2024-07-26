package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Products.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Products implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long product_id;
    private String name;
    private String description;
    private double price;
    private int stock_quantity;
    private long category_id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String imagePath;

    public Products() {
    }

    public Products(Builder builder) {
        this.product_id = builder.product_id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stock_quantity = builder.stock_quantity;
        this.category_id = builder.category_id;
        this.created_at = builder.created_at;
        this.updated_at = builder.updated_at;
        this.imagePath = builder.imagePath;
    }

    public long getProduct_id() {
        return product_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock_quantity() {
        return stock_quantity;
    }

    public long getCategory_id() {
        return category_id;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Products products)) return false;

        if (getProduct_id() != products.getProduct_id()) return false;
        if (Double.compare(getPrice(), products.getPrice()) != 0) return false;
        if (getStock_quantity() != products.getStock_quantity()) return false;
        if (getCategory_id() != products.getCategory_id()) return false;
        if (getName() != null ? !getName().equals(products.getName()) : products.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(products.getDescription()) : products.getDescription() != null)
            return false;
        if (getCreated_at() != null ? !getCreated_at().equals(products.getCreated_at()) : products.getCreated_at() != null)
            return false;
        if (getUpdated_at() != null ? !getUpdated_at().equals(products.getUpdated_at()) : products.getUpdated_at() != null)
            return false;
        return getImagePath() != null ? getImagePath().equals(products.getImagePath()) : products.getImagePath() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (getProduct_id() ^ (getProduct_id() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        temp = Double.doubleToLongBits(getPrice());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getStock_quantity();
        result = 31 * result + (int) (getCategory_id() ^ (getCategory_id() >>> 32));
        result = 31 * result + (getCreated_at() != null ? getCreated_at().hashCode() : 0);
        result = 31 * result + (getUpdated_at() != null ? getUpdated_at().hashCode() : 0);
        result = 31 * result + (getImagePath() != null ? getImagePath().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Products{" +
                "Product ID: " + product_id +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", PRICE: " + price +
                ", STOCK QUANTITY: " + stock_quantity +
                ", CATEGORY ID: " + category_id +
                ", CREATED AT: " + created_at +
                ", UPDATED AT: " + updated_at +
                ", IMAGE PATH: '" + imagePath + '\'' +
                '}';
    }

    public static class Builder {
        private long product_id;
        private String name;
        private String description;
        private double price;
        private int stock_quantity;
        private long category_id;
        private LocalDate created_at;
        private LocalDate updated_at;
        private String imagePath;

        public Builder setProduct_id(long product_id) {
            this.product_id = product_id;
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

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStock_quantity(int stock_quantity) {
            this.stock_quantity = stock_quantity;
            return this;
        }

        public Builder setCategory_id(long category_id) {
            this.category_id = category_id;
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

        public Builder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Builder copy(Products products) {
            this.product_id = products.getProduct_id();
            this.name = products.getName();
            this.description = products.getDescription();
            this.price = products.getPrice();
            this.stock_quantity = products.getStock_quantity();
            this.category_id = products.getCategory_id();
            this.created_at = products.getCreated_at();
            this.updated_at = products.getUpdated_at();
            this.imagePath = products.getImagePath();
            return this;
        }

        public Products build() {
            return new Products(this);
        }
    }
}
