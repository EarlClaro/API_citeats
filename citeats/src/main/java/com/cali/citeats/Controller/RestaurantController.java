package com.cali.citeats.Controller;

import com.cali.citeats.Entity.RestaurantEntity;
import com.cali.citeats.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
    
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantEntity> getRestaurantById(@PathVariable int id) {
        RestaurantEntity restaurant = restaurantService.getRestaurantById(id);

        if (restaurant != null) {
            return ResponseEntity.ok(restaurant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // C - Create a restaurant
    @PostMapping("/createRestaurants")
    public ResponseEntity<RestaurantEntity> createRestaurant(@RequestBody RestaurantEntity restaurant) {
        RestaurantEntity newRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }

    // R - Read all restaurants
    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List<RestaurantEntity>> getAllRestaurants() {
        List<RestaurantEntity> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    // U - Update a restaurant
    @PutMapping("/updateRestaurants/{id}")
    public ResponseEntity<RestaurantEntity> updateRestaurant(@PathVariable Integer id, @RequestBody RestaurantEntity restaurant) {
        RestaurantEntity updatedRestaurant = restaurantService.updateRestaurant(id, restaurant);
        if (updatedRestaurant != null) {
            return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // U - Update a restaurant profile
    @PutMapping("/updateRestaurantsProfile/{id}")
    public ResponseEntity<RestaurantEntity> updateRestaurantProfile(@PathVariable Integer id, @RequestBody RestaurantEntity updatedFields) {
        RestaurantEntity existingRestaurant = restaurantService.getRestaurantById(id);

        if (existingRestaurant != null) {
            // Create a new instance and copy the fields to be updated (excluding rating)
            RestaurantEntity updatedRestaurant = new RestaurantEntity();
            updatedRestaurant.setRestaurantId(id);
            updatedRestaurant.setName(updatedFields.getName());
            updatedRestaurant.setRestaurantOpeningHours(updatedFields.getRestaurantOpeningHours());
            updatedRestaurant.setAddress(updatedFields.getAddress());
            updatedRestaurant.setCuisineType(updatedFields.getCuisineType());
            updatedRestaurant.setPhoneNumber(updatedFields.getPhoneNumber());

            // Perform the update
            updatedRestaurant = restaurantService.updateRestaurantProfile(id, updatedRestaurant);

            return new ResponseEntity<>(updatedRestaurant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // D - Delete a restaurant
    @DeleteMapping("/deleteRestaurants/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>("Restaurant with id: " + id + " is successfully deleted!", HttpStatus.OK);
    }
}
