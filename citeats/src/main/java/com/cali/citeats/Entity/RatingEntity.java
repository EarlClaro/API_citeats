package com.cali.citeats.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblrating")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RatingID")
    private int ratingId;

    @OneToOne
    @JoinColumn(name = "RestaurantID", unique = true)
    private RestaurantEntity restaurant;

    @Column(name = "AverageRating")
    private Double averageRating;

    @Column(name = "NumberOfRatings")
    private Integer numberOfRatings;

    public RatingEntity() {
        super();
    }

    public RatingEntity(int ratingId, RestaurantEntity restaurant, Double averageRating, Integer numberOfRatings) {
        super();
        this.ratingId = ratingId;
        this.restaurant = restaurant;
        this.averageRating = averageRating;
        this.numberOfRatings = numberOfRatings;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public RestaurantEntity getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(RestaurantEntity restaurant) {
        this.restaurant = restaurant;
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
