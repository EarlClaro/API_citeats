package com.cali.citeats.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblrating")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RatingID")
    private int ratingId;

    @Column(name = "RestaurantID")
    private int restaurantId; // Representing RestaurantEntity as an integer

    @Column(name = "AverageRating")
    private Double averageRating;

    @Column(name = "NumberOfRatings")
    private Integer numberOfRatings;

    public RatingEntity() {
        super();
    }

    public RatingEntity(int ratingId, int restaurantId, Double averageRating, Integer numberOfRatings) {
        super();
        this.ratingId = ratingId;
        this.restaurantId = restaurantId;
        this.averageRating = averageRating;
        this.numberOfRatings = numberOfRatings;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(Integer numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }
}
