package za.ac.cput.factory;

import za.ac.cput.domain.Products;
import za.ac.cput.domain.Review;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

/**
 * ReviewFactory.java
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 26-Jul-24
 */

public class ReviewFactory {
    public static Review buildReview(long review_id, Products product, User user, int rating,
                                     String comment, LocalDate created_at) {
        if (Helper.isNullOrEmpty(rating) ||
                Helper.isNullOrEmpty(comment) ||
                Helper.isNullOrEmpty(String.valueOf(created_at))
        ) return null;

        return new Review.Builder()
                .setId(review_id)
                .setProduct(product)
                .setUsers(user)
                .setRating(rating)
                .setComment(comment)
                .setCreated_at(created_at)
                .build();
    }
}
