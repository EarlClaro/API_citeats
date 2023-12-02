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

    // D - Delete a restaurant
    @DeleteMapping("/deleteRestaurants/{id}")
    public ResponseEntity<String> deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return new ResponseEntity<>("Restaurant with id: " + id + " is successfully deleted!", HttpStatus.OK);
    }
}
