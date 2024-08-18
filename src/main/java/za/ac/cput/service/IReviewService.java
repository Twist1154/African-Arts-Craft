package za.ac.cput.service;

import za.ac.cput.domain.Review;

import java.util.List;

public interface IReviewService {
    Review save(Review review);

    Review findById(Long id);

    List<Review> findAll();

    void deleteById(Long id);
}
