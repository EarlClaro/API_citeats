package com.cali.citeats.Controller;

import com.cali.citeats.Entity.RatingEntity;
import com.cali.citeats.Service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    // C - Create a rating
    @PostMapping("/addRating")
    public ResponseEntity<RatingEntity> addRating(@RequestBody RatingEntity rating) {
        RatingEntity addedRating = ratingService.addRating(rating);
        return new ResponseEntity<>(addedRating, HttpStatus.CREATED);
    }

    // R - Read all ratings
    @GetMapping("/getAllRatings")
    public ResponseEntity<List<RatingEntity>> getAllRatings() {
        List<RatingEntity> allRatings = ratingService.getAllRatings();
        return new ResponseEntity<>(allRatings, HttpStatus.OK);
    }

    // R - Read ratings by restaurant
    @GetMapping("/getRatingByRestaurant/{restaurantId}")
    public ResponseEntity<List<RatingEntity>> getRatingByRestaurant(@PathVariable int restaurantId) {
        List<RatingEntity> ratingsByRestaurant = ratingService.getRatingByRestaurant(restaurantId);
        return new ResponseEntity<>(ratingsByRestaurant, HttpStatus.OK);
    }

    // R - Read average rating by restaurant
    @GetMapping("/getAverageRatingByRestaurant/{restaurantId}")
    public ResponseEntity<Double> getAverageRatingByRestaurant(@PathVariable int restaurantId) {
        Double averageRating = ratingService.getAverageRatingByRestaurant(restaurantId);
        return new ResponseEntity<>(averageRating, HttpStatus.OK);
    }

    // U - Update a rating
    @PutMapping("/updateRating/{ratingId}")
    public ResponseEntity<RatingEntity> updateRating(
            @PathVariable int ratingId,
            @RequestBody RatingEntity newRatingDetails) {
        RatingEntity updatedRating = ratingService.updateRating(ratingId, newRatingDetails);
        return new ResponseEntity<>(updatedRating, HttpStatus.OK);
    }

    // D - Delete a rating
    @DeleteMapping("/deleteRating/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable int ratingId) {
        String deletionMessage = ratingService.deleteRating(ratingId);
        return new ResponseEntity<>(deletionMessage, HttpStatus.OK);
    }
}
