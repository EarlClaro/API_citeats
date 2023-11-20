package com.cali.citeats.Service;

import com.cali.citeats.Entity.ReviewEntity;
import com.cali.citeats.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // Create a review
    public ReviewEntity createReview(int userId, int restaurantId, Integer rating, String comment, Date datePosted) {
        ReviewEntity newReview = new ReviewEntity(userId, restaurantId, rating, comment, datePosted);
        return reviewRepository.save(newReview);
    }

    // Get all reviews
    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get review by ID
    public ReviewEntity getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    // Update a review
    public ReviewEntity updateReview(int reviewId, int userId, int restaurantId, Integer rating, String comment, Date datePosted) {
        ReviewEntity existingReview = reviewRepository.findById(reviewId).orElse(null);
        if (existingReview != null) {
            existingReview.setUserId(userId);
            existingReview.setRestaurantId(restaurantId);
            existingReview.setRating(rating);
            existingReview.setComment(comment);
            existingReview.setDatePosted(datePosted);
            return reviewRepository.save(existingReview);
        }
        return null;
    }

    // Delete a review
    public String deleteReview(int reviewId) {
        ReviewEntity existingReview = reviewRepository.findById(reviewId).orElse(null);
        if (existingReview != null) {
            reviewRepository.delete(existingReview);
            return "Review deleted successfully";
        }
        return "Review not found";
    }
}