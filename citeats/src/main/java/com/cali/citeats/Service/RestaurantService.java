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

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
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
            updatedRestaurant.setName(restaurant.getName());
            updatedRestaurant.setRating(id);
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

    public void deleteRestaurant(Integer id) {
        if (restaurantRepository.existsById(id)) {
            restaurantRepository.deleteById(id);
        } else {
            // Handle the case where the restaurant with the given id is not found
            throw new RuntimeException("Restaurant not found with id: " + id);
        }
    }
}
