package za.ac.cput.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Products.java
 *
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 23-Jul-24
 */

@Entity
public class Products implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    @OneToMany
    @JoinColumn(name = "subcategory_id", nullable = false)
    private List<SubCategory> subCategories;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String imagePath;

    public Products() {
    }

    public Products(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.stockQuantity = builder.stockQuantity;
        this.subCategories = builder.subCategories;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.imagePath = builder.imagePath;
    }

    public Long getId() {
        return id;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Double.compare(products.price, price) == 0 && stockQuantity == products.stockQuantity && Objects.equals(id, products.id) && Objects.equals(name, products.name) && Objects.equals(description, products.description) && Objects.equals(subCategories, products.subCategories) && Objects.equals(createdAt, products.createdAt) && Objects.equals(updatedAt, products.updatedAt) && Objects.equals(imagePath, products.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, stockQuantity, subCategories, createdAt, updatedAt, imagePath);
    }

    @Override
    public String toString() {
        return "Products{" +
                "Product ID: " + id +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", PRICE: " + price +
                ", STOCK QUANTITY: " + stockQuantity +
                ", SUB CATEGORIES: " + subCategories +
                ", CREATED AT: " + createdAt +
                ", UPDATED AT: " + updatedAt +
                ", IMAGE PATH: '" + imagePath + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String name;
        private String description;
        private double price;
        private int stockQuantity;
        private List<SubCategory> subCategories;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String imagePath;

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

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setStockQuantity(int stockQuantity) {
            this.stockQuantity = stockQuantity;
            return this;
        }

        public Builder setSubCategories(List<SubCategory> subCategories) {
            this.subCategories = subCategories;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Builder copy(Products products) {
            this.id = products.getId();
            this.name = products.getName();
            this.description = products.getDescription();
            this.price = products.getPrice();
            this.stockQuantity = products.getStockQuantity();
            this.subCategories = products.getSubCategories();
            this.createdAt = products.getCreatedAt();
            this.updatedAt = products.getUpdatedAt();
            this.imagePath = products.getImagePath();
            return this;
        }

        public Products build() {
            return new Products(this);
        }
    }
}