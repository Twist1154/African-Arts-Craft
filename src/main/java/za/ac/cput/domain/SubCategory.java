package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

/**
 * SubCategory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Sep-24
 */
@Getter
@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Categories category;
    private String name;
    private String description;

    public SubCategory() {
    }

    public SubCategory(Builder builder) {
        this.id = builder.id;
        this.category = builder.category;
        this.name = builder.name;
        this.description = builder.description;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "Sub Category ID: " + id +
                ", CATEGORY ID: " + category.getId() +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private Categories category;
        private String name;
        private String description;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCategory(Categories category) {
            this.category = category;
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

        public Builder copy(SubCategory sub_category) {
            this.id = sub_category.id;
            this.category = sub_category.category;
            this.name = sub_category.name;
            this.description = sub_category.description;
            return this;
        }

        public SubCategory build() {
            return new SubCategory(this);
        }
    }
}
