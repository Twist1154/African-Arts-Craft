package za.ac.cput.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;

import java.util.List;

@Slf4j
@Service
public class ReviewService implements IReviewService {
    private ReviewRepository repository;

    @Autowired
    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    @Override
    public Review create(Review review) {
        return repository.save(review);
    }

    @Override
    public Review read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Review update(Review review) {
        Review existingReview = read(review.getId());
        if (existingReview != null) {
            Review updatedReview = new Review.Builder()
                    .copy(review)
                    .setId(existingReview.getId())
                    .setProduct(existingReview.getProduct())
                    .setUser(review.getUser())
                    .setRating(review.getRating())
                    .setComment(review.getComment())
                    .setCreated_at(existingReview.getCreated_at())
                    .build();
            return repository.save(updatedReview);
        }
        log.error("Review with id  not found", review.getId());
        return null;
    }

    @Override
    public List<Review> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
