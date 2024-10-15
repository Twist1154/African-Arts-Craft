package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Review;
import za.ac.cput.service.ReviewService;


import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService service;

    @Autowired
    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review savedReview = service.create(review);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = service.read(id);
        return review != null ? new ResponseEntity<>(review, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = service.findAll();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/product/{product_id}")
    public ResponseEntity<List<Review>> getReviewsByProduct(@PathVariable Long product_id) {
        List<Review> reviews = service.findByProduct_Id(product_id);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<Review>> getReviewsByUser(@PathVariable Long user_id) {
        List<Review> reviews = service.findByUser_Id(user_id);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
