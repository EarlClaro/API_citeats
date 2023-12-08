package com.cali.citeats.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblrestaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RestaurantID")
    private int restaurantId;

    @Column(name = "RatingID")
    private Float rating;

    @Column(name = "LocationID")
    private Integer locationId;
    
    @Column(name = "Name", nullable = false)
    private String name;
    
    @Column(name = "email", nullable = false)
    private String  email;
    
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "RestaurantOpeningHours")
    private String restaurantOpeningHours; 

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

    public RestaurantEntity(int restaurantId, Float rating, Integer locationId, String name, String restaurantOpeningHours,
                            String address, String cuisineType, String phoneNumber, String website, String password, String email) {
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
        this.password = password;
        this.email = email;
    }
    // Getters and Setters
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
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

    public String getRestaurantOpeningHours() {
        return restaurantOpeningHours;
    }

    public void setRestaurantOpeningHours(String restaurantOpeningHours) {
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
