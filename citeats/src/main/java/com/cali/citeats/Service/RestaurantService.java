package com.cali.citeats.Service;

import com.cali.citeats.Entity.RestaurantEntity;
import com.cali.citeats.Repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "http://localhost:3000") 
public class RestaurantService {
	
	@Autowired
    private final RestaurantRepository restaurantRepository;

    
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    
    //Get restaurant by Id
    public RestaurantEntity getRestaurantById(int id) {
        // Implement logic to get the restaurant by ID from the repository
        return restaurantRepository.findById(id).orElse(null);
    }
    
    public RestaurantEntity getRestaurantByEmail(String email) {
        Optional<RestaurantEntity> restaurantOptional = restaurantRepository.findByEmail(email);

        if (restaurantOptional.isPresent()) {
            return restaurantOptional.get();
        } else {
            return null; // or throw an exception based on your business logic
        }
    }
    
    public RestaurantEntity updateRestaurantPassword(Integer restaurantId, String newPassword) {
        Optional<RestaurantEntity> optionalRestaurant = restaurantRepository.findById(restaurantId);

        if (optionalRestaurant.isPresent()) {
            RestaurantEntity restaurant = optionalRestaurant.get();
            
            // Add validation logic or encryption if needed
            restaurant.setPassword(newPassword);

            return restaurantRepository.save(restaurant);
        } else {
            throw new RuntimeException("Restaurant not found");
        }
    }

    
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public RestaurantEntity createRestaurant(RestaurantEntity restaurant) {
        // Add any additional validation or business logic before saving
        return restaurantRepository.save(restaurant);
    }

    public RestaurantEntity updateRestaurant(Integer id, RestaurantEntity restaurant) {
        Optional<RestaurantEntity> existingRestaurant = restaurantRepository.findById(id);

        if (existingRestaurant.isPresent()) {
            // Update restaurant properties based on your needs
            RestaurantEntity updatedRestaurant = existingRestaurant.get();
            updatedRestaurant.setrestaurantName(restaurant.getrestaurantName());
            updatedRestaurant.setRating(restaurant.getRating());
            updatedRestaurant.setRestaurantOpeningHours(restaurant.getRestaurantOpeningHours());
            updatedRestaurant.setAddress(restaurant.getAddress());
            updatedRestaurant.setCuisineType(restaurant.getCuisineType());
            updatedRestaurant.setPhoneNumber(restaurant.getPhoneNumber());


            return restaurantRepository.save(updatedRestaurant);
        } else {
            // Handle the case where the restaurant with the given id is not found
            throw new RuntimeException("Restaurant not found with id: " + id);
        }
    }
    
    //Handles restaurant profile update without rating
    public RestaurantEntity updateRestaurantProfile(Integer id, RestaurantEntity restaurant) {
        Optional<RestaurantEntity> existingRestaurant = restaurantRepository.findById(id);

        if (existingRestaurant.isPresent()) {
            // Update restaurant properties based on your needs
            RestaurantEntity updatedRestaurant = existingRestaurant.get();

            if (restaurant.getrestaurantName() != null) {
                updatedRestaurant.setrestaurantName(restaurant.getrestaurantName());
            }

            if (restaurant.getRestaurantOpeningHours() != null) {
                updatedRestaurant.setRestaurantOpeningHours(restaurant.getRestaurantOpeningHours());
            }

            if (restaurant.getAddress() != null) {
                updatedRestaurant.setAddress(restaurant.getAddress());
            }

            if (restaurant.getCuisineType() != null) {
                updatedRestaurant.setCuisineType(restaurant.getCuisineType());
            }

            if (restaurant.getPhoneNumber() != null) {
                updatedRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
            }

            // Exclude the rating from the update to prevent it from being set to null

            return restaurantRepository.save(updatedRestaurant);
        } else {
            // Handle the case where the restaurant with the given id is not found
            throw new RuntimeException("Restaurant not found with id: " + id);
        }
    }



    public void deleteRestaurant(Integer id) {
        if (restaurantRepository.existsById(id)) {
            restaurantRepository.deleteById(id);
        } else {
            // Handle the case where the restaurant with the given id is not found
            throw new RuntimeException("Restaurant not found with id: " + id);
        }
    }
}
