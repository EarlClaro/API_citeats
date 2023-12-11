package com.cali.citeats.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cali.citeats.Entity.ReviewEntity;
import com.cali.citeats.Service.ReviewService;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/hello")
    public String helloReview() {
        return "Hello, Reviews!";
    }
    
    @GetMapping("/getReviewsByUserId/{userId}")
    public ResponseEntity<List<ReviewEntity>> getReviewsByUserId(@PathVariable int userId) {
        try {
            List<ReviewEntity> reviews = reviewService.getReviewsByUserId(userId);
            if (!reviews.isEmpty()) {
                return ResponseEntity.ok(reviews);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/createReview")
    public ReviewEntity createReview(@RequestBody ReviewEntity review) {
        return reviewService.createReview(
            review.getUserId(), 
            review.getRestaurantId(), 
            review.getRating(), 
            review.getComment(), 
            review.getDatePosted(),
            review.isDeleted()
        );
    }

    @GetMapping("/getAllReviews")
    public List<ReviewEntity> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/getReviewById/{reviewId}")
    public ReviewEntity getReviewById(@PathVariable int reviewId) {
        return reviewService.getReviewById(reviewId);
    }
    
    @GetMapping("/getReviewsByRestaurantId/{restaurantId}")
    public List<ReviewEntity> getReviewsByRestaurantId(@PathVariable int restaurantId) {
        return reviewService.getReviewsByRestaurantId(restaurantId);
    }

    @PutMapping("/updateReview/{reviewId}")
    public ReviewEntity updateReview(@PathVariable int reviewId, @RequestBody ReviewEntity updatedReview) {
        return reviewService.updateReview(
            reviewId, 
            updatedReview.getUserId(), 
            updatedReview.getRestaurantId(), 
            updatedReview.getRating(), 
            updatedReview.getComment(), 
            updatedReview.getDatePosted()
        );
    }
    
    @PutMapping("/softDeleteReview/{reviewId}")
    public ReviewEntity softDeleteReview(@PathVariable int reviewId) {
        try {
            ReviewEntity existingReview = reviewService.getReviewById(reviewId);

            if (existingReview != null) {
                // Soft delete logic
                reviewService.softDeleteReview(reviewId);
                return existingReview;
            } else {
                // Handle case where the review is not found
                throw new NoSuchElementException("Review not found with id: " + reviewId);
            }
        } catch (NoSuchElementException e) {
            // Re-throw NoSuchElementException
            throw e;
        } catch (Exception e) {
            // Handle other exceptions
            throw new RuntimeException("Internal Server Error", e);
        }
    }

    
    @DeleteMapping("/deleteReview/{reviewId}")
    public String deleteReview(@PathVariable int reviewId) {
        return reviewService.deleteReview(reviewId);
    }
}