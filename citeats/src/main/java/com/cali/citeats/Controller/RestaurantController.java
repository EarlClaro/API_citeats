package com.cali.citeats.Controller;

import com.cali.citeats.Entity.RestaurantEntity;
import com.cali.citeats.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/restaurants")
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{id}")
    public RestaurantEntity getRestaurantById(@PathVariable int id) {
        return restaurantService.getRestaurantById(id);
    }

    @PostMapping("/createRestaurants")
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantEntity createRestaurant(@RequestBody RestaurantEntity restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping("/getAllRestaurants")
    public List<RestaurantEntity> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }
    
    @GetMapping("/findByEmail/{email}")
    public RestaurantEntity getRestaurantByEmail(@PathVariable String email) {
        RestaurantEntity restaurant = restaurantService.getRestaurantByEmail(email);

        if (restaurant != null) {
            return restaurant;
        } else {
            throw new RuntimeException("Restaurant not found for email: " + email);
        }
        
    }
    
    @PutMapping("/updatePassword/{restaurantId}")
    public String updatePassword(@PathVariable Integer restaurantId, @RequestBody Map<String, String> requestBody) {
        try {
            String newPassword = requestBody.get("newPassword");

            if (newPassword == null || newPassword.isEmpty()) {
                throw new IllegalArgumentException("New password cannot be null or empty.");
            }

            restaurantService.updateRestaurantPassword(restaurantId, newPassword);
            return "Password updated successfully.";
        } catch (Exception e) {
            return "Error updating password.";
        }
    }


    @PutMapping("/updateRestaurants/{id}")
    public RestaurantEntity updateRestaurant(@PathVariable Integer id, @RequestBody RestaurantEntity restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }

    @PutMapping("/updateRestaurantsProfile/{id}")
    public RestaurantEntity updateRestaurantProfile(@PathVariable Integer id, @RequestBody RestaurantEntity updatedFields) {
        RestaurantEntity existingRestaurant = restaurantService.getRestaurantById(id);

        if (existingRestaurant != null) {
            RestaurantEntity updatedRestaurant = new RestaurantEntity();
            updatedRestaurant.setRestaurantId(id);
            updatedRestaurant.setrestaurantName(updatedFields.getrestaurantName());
            updatedRestaurant.setRestaurantOpeningHours(updatedFields.getRestaurantOpeningHours());
            updatedRestaurant.setAddress(updatedFields.getAddress());
            updatedRestaurant.setCuisineType(updatedFields.getCuisineType());
            updatedRestaurant.setPhoneNumber(updatedFields.getPhoneNumber());

            updatedRestaurant = restaurantService.updateRestaurantProfile(id, updatedRestaurant);

            return updatedRestaurant;
        } else {
            throw new RuntimeException("Restaurant not found");
        }
    }

    @DeleteMapping("/deleteRestaurants/{id}")
    public String deleteRestaurant(@PathVariable Integer id) {
        restaurantService.deleteRestaurant(id);
        return "Restaurant with id: " + id + " is successfully deleted!";
    }
}
