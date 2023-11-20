package com.cali.citeats.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cali.citeats.Entity.RatingEntity;
import com.cali.citeats.Repository.RatingRepository;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public RatingEntity addRating(RatingEntity rating) {
        return ratingRepository.save(rating);
    }

    public List<RatingEntity> getAllRatings() {
        return ratingRepository.findAll();
    }

    public List<RatingEntity> getRatingByRestaurant(int restaurantId) {
        return ratingRepository.findByRestaurantId(restaurantId);
    }

    public Double getAverageRatingByRestaurant(int restaurantId) {
        return ratingRepository.calculateAverageRatingByRestaurant(restaurantId);
    }

    public RatingEntity updateRating(int ratingId, RatingEntity newRatingDetails) {
        Optional<RatingEntity> optionalRating = ratingRepository.findById(ratingId);

        if (optionalRating.isPresent()) {
            RatingEntity existingRating = optionalRating.get();

            // Update the existing rating with new details
            existingRating.setAverageRating(newRatingDetails.getAverageRating());
            existingRating.setNumberOfRatings(newRatingDetails.getNumberOfRatings());

            // Save and return the updated rating
            return ratingRepository.save(existingRating);
        } else {
            throw new RuntimeException("Rating not found with id: " + ratingId);
        }
    }

    public String deleteRating(int ratingId) {
        Optional<RatingEntity> optionalRating = ratingRepository.findById(ratingId);

        if (optionalRating.isPresent()) {
            RatingEntity existingRating = optionalRating.get();

            ratingRepository.delete(existingRating);
            return "Rating with id " + ratingId + " has been deleted.";
        } else {
            throw new RuntimeException("Rating not found with id: " + ratingId);
        }
    }
}
