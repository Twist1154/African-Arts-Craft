package za.ac.cput.domain;

import java.io.Serializable;

import jakarta.persistence.*;
/**
 * Categories.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Entity
public class Categories implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String name;
    private String description;

    public Categories() {
    }

    public Categories(Builder builder) {
        this.categoryId = builder.categoryId;
        this.name = builder.name;
        this.description = builder.description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Categories{" +
                "Category ID: " + categoryId +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                '}';
    }

    public static class Builder {
        private Long categoryId;
        private String name;
        private String description;

        public Builder setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
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

        public Builder copy(Categories categories) {
            this.categoryId = categories.getCategoryId();
            this.name = categories.getName();
            this.description = categories.getDescription();
            return this;
        }

        public Categories build() {
            return new Categories(this);
        }
    }
}

