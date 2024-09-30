package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * Product.java
 *
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 23-Jul-24
 */
@Getter
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;

    // Specify the mappedBy attribute to indicate SubCategory is the owner of the relationship
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubCategory> subCategories;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private String imagePath;

    public Product() {
    }

    public Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.subCategories = builder.subCategories;
        this.imagePath = builder.imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(description, product.description) &&
                Objects.equals(subCategories, product.subCategories) &&
                Objects.equals(createdAt, product.createdAt) &&
                Objects.equals(updatedAt, product.updatedAt) &&
                Objects.equals(imagePath, product.imagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, subCategories, createdAt, updatedAt, imagePath);
    }

    @Override
    public String toString() {
        return "Product{" +
                "Product ID: " + id +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", PRICE: " + price +
                ", SUB CATEGORIES: " + (subCategories != null ? subCategories : "[]") +
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
        private List<SubCategory> subCategories;
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

        public Builder setSubCategories(List<SubCategory> subCategories) {
            this.subCategories = subCategories;
            return this;
        }

        public Builder setImagePath(String imagePath) {
            this.imagePath = imagePath;
            return this;
        }

        public Builder copy(Product product) {
            this.id = product.getId();
            this.name = product.getName();
            this.description = product.getDescription();
            this.price = product.getPrice();
            this.subCategories = product.getSubCategories();
            this.imagePath = product.getImagePath();
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
