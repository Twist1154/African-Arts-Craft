package za.ac.cput.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

/**
 * Category.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Getter
@Entity
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category() {
    }

    public Category(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category that = (Category) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "Category ID: " + id +
                ", NAME: '" + name + '\'' +
                '}';
    }

    public static class Builder {
        private Long id;
        private String name;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Category category) {
            this.id = category.getId();
            this.name = category.getName();
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
