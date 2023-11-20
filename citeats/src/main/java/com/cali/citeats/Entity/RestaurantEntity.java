package com.cali.citeats.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tblrestaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RestaurantID")
    private int restaurantId;

    @Column(name = "RatingID")
    private Integer rating;

    @Column(name = "LocationID", nullable = false)
    private Integer locationId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "RestaurantOpeningHours")
    private Date restaurantOpeningHours;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "CuisineType")
    private String cuisineType;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "Website")
    private String website;

    public RestaurantEntity() {
        super();
    }

    public RestaurantEntity(int restaurantId, Integer rating, Integer locationId, String name, Date restaurantOpeningHours,
                            String address, String cuisineType, String phoneNumber, String website) {
        super();
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.locationId = locationId;
        this.name = name;
        this.restaurantOpeningHours = restaurantOpeningHours;
        this.address = address;
        this.cuisineType = cuisineType;
        this.phoneNumber = phoneNumber;
        this.website = website;
    }

    // Getters and Setters
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRestaurantOpeningHours() {
        return restaurantOpeningHours;
    }

    public void setRestaurantOpeningHours(Date restaurantOpeningHours) {
        this.restaurantOpeningHours = restaurantOpeningHours;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
