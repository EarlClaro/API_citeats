package com.cali.citeats.Controller;

import com.cali.citeats.Entity.UserEntity;
import com.cali.citeats.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")

@CrossOrigin(origins = "http://localhost:3000") 
public class UserController {

    @Autowired
    private UserService userService;
    
    //Get user by ID
    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }
    

    // C - Create a user
    @PostMapping("/createUser")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        UserEntity newUser = userService.createUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        
    }

    // R - Read all users
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    
    //Get user by email
    @GetMapping("/by-email/{email}")
    public ResponseEntity<UserEntity> getUserByEmail(@PathVariable String email) {
        UserEntity user = userService.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PutMapping("/updatePassword/{userId}")
    public ResponseEntity<String> updatePassword(@PathVariable int userId, @RequestBody Map<String, String> request) {
        String newPassword = request.get("newPassword");
        if (newPassword == null || newPassword.isEmpty()) {
            return ResponseEntity.badRequest().body("New password cannot be empty.");
        }

        userService.updatePassword(userId, newPassword);
        return ResponseEntity.ok("Password updated successfully.");
    }



    // U - Update a user
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable int userId, @RequestBody UserEntity user) {
        try {
            UserEntity updatedUser = userService.updateUser(userId, user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // D - Delete a user
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) {
        String result = userService.deleteUser(userId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}


