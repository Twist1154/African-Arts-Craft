package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

/**
 * SubCategory.java
 *
 * Author: Rethabile Ntsekhe
 * Student Num: 220455430
 * Date: 26-Sep-24
 */
@Getter
@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnore
    private Category category;

    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public SubCategory() {
    }

    public SubCategory(Builder builder) {
        this.id = builder.id;
        this.category = builder.category;
        this.name = builder.name;
        this.product = builder.product;  // Set product field in constructor
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "Sub Category ID: " + id +
                ", CATEGORY ID: " + (category != null ? category.getId() : "null") +
                ", NAME: '" + name + '\'' +
                ", PRODUCT ID: " + (product != null ? product.getId() : "null") +
                '}';
    }

    public static class Builder {
        private Long id;
        private Category category;
        private String name;
        private Product product;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;  // Builder method for setting product
            return this;
        }

        public Builder copy(SubCategory sub_category) {
            this.id = sub_category.id;
            this.category = sub_category.category;
            this.name = sub_category.name;
            this.product = sub_category.product;  // Copy product field
            return this;
        }

        public SubCategory build() {
            return new SubCategory(this);
        }
    }
}
