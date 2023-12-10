package com.cali.citeats.Controller;

import com.cali.citeats.Entity.UserEntity;
import com.cali.citeats.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable int userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/createUser")
    @ResponseStatus(HttpStatus.CREATED)
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/by-email/{email}")
    public UserEntity getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PutMapping("/updatePassword/{userId}")
    public String updatePassword(@PathVariable int userId, @RequestBody Map<String, String> request) {
        String newPassword = request.get("newPassword");
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("New password cannot be empty.");
        }

        userService.updatePassword(userId, newPassword);
        return "Password updated successfully.";
    }

    @PutMapping("/updateUser/{userId}")
    public UserEntity updateUser(@PathVariable int userId, @RequestBody UserEntity user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }
}
