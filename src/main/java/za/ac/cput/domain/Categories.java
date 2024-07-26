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
    private long category_id;
    private String name;
    private String description;
    private Long parent_id;

    public Categories() {
    }

    public Categories(Builder builder) {
        this.category_id = builder.category_id;
        this.name = builder.name;
        this.description = builder.description;
        this.parent_id = builder.parent_id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getParent_id() {
        return parent_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categories that)) return false;

        if (getCategory_id() != that.getCategory_id()) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        return getParent_id() != null ? getParent_id().equals(that.getParent_id()) : that.getParent_id() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getCategory_id() ^ (getCategory_id() >>> 32));
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + (getParent_id() != null ? getParent_id().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "Category ID: " + category_id +
                ", NAME: '" + name + '\'' +
                ", DESCRIPTION: '" + description + '\'' +
                ", PARENT ID: " + parent_id +
                '}';
    }

    public static class Builder {
        private long category_id;
        private String name;
        private String description;
        private Long parent_id;

        public Builder setCategory_id(long category_id) {
            this.category_id = category_id;
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

        public Builder setParent_id(Long parent_id) {
            this.parent_id = parent_id;
            return this;
        }

        public Builder copy(Categories categories) {
            this.category_id = categories.getCategory_id();
            this.name = categories.getName();
            this.description = categories.getDescription();
            this.parent_id = categories.getParent_id();
            return this;
        }

        public Categories build() {
            return new Categories(this);
        }
    }
}

