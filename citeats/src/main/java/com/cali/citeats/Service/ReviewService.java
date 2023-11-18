package com.cali.citeats.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cali.citeats.Entity.ReviewEntity;
import com.cali.citeats.Repository.ReviewRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewEntity createReview(ReviewEntity review) {
        return reviewRepository.save(review);
    }

    public List<ReviewEntity> getAllReviews() {
        return reviewRepository.findAll();
    }

    public ReviewEntity getReviewById(int reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(() -> new NoSuchElementException("Review with ID: " + reviewId + " not found"));
    }

    public ReviewEntity updateReview(int reviewId, ReviewEntity updatedReview) {
        ReviewEntity review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new NoSuchElementException("Review with ID: " + reviewId + " not found"));

        review.setUser(updatedReview.getUser()); // Assuming setUserId exists in ReviewEntity
        review.setRestaurant(updatedReview.getRestaurant()); // Assuming setRestaurantId exists in ReviewEntity
        review.setRating(updatedReview.getRating()); // Assuming setRating exists in ReviewEntity
        review.setComment(updatedReview.getComment()); // Assuming setComment exists in ReviewEntity
        review.setDatePosted(updatedReview.getDatePosted()); // Assuming setDatePosted exists in ReviewEntity

        return reviewRepository.save(review);
    }

    public String deleteReview(int reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return "Review with ID: " + reviewId + " deleted successfully";
        } else {
            return "Review with ID: " + reviewId + " not found";
        }
    }
}
