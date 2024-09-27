package za.ac.cput.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Reviews.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 23-Jul-24
 */

@Getter
@Entity
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int rating;
    private String comment;
    private LocalDate created_at;

    public Review() {
    }

    public Review(Builder builder) {
        this.id = builder.id;
        this.product = builder.product;
        this.user = builder.user;
        this.rating = builder.rating;
        this.comment = builder.comment;
        this.created_at = builder.created_at;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && rating == review.rating && Objects.equals(product, review.product) && Objects.equals(user, review.user) && Objects.equals(comment, review.comment) && Objects.equals(created_at, review.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, user, rating, comment, created_at);
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "Review ID: " + id +
                ", PRODUCT : " + product +
                ", USER : " + user +
                ", RATING: " + rating +
                ", COMMENT: '" + comment + '\'' +
                ", CREATED AT: " + created_at +
                '}';
    }

    public static class Builder {
        private long id;
        private Products product;
        private User user;
        private int rating;
        private String comment;
        private LocalDate created_at;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setProduct(Products product) {
            this.product = product;
            return this;
        }

        public Builder setUsers(User user) {
            this.user = user;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setCreated_at(LocalDate created_at) {
            this.created_at = created_at;
            return this;
        }

        public Builder copy(Review reviews) {
            this.id = reviews.getId();
            this.product = reviews.getProduct();
            this.user = reviews.getUser();
            this.rating = reviews.getRating();
            this.comment = reviews.getComment();
            this.created_at = reviews.getCreated_at();
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }
}

