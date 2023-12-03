package com.cali.citeats.Service;

import com.cali.citeats.Entity.UserEntity;
import com.cali.citeats.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@Service
@CrossOrigin(origins = "http://localhost:3000") 
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //Find user by Id
    public UserEntity getUserById(int userId) {
        Optional<UserEntity> user = userRepository.findById(userId);

        if (user.isPresent()) {
            return user.get();
        } else {
            // Handle the case where the user with the given id is not found
            throw new RuntimeException("User not found with id: " + userId);
        }
        
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user) {
        // Add any additional validation or business logic before saving
        return userRepository.save(user);
    }

    public UserEntity updateUser(int userId, UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findById(userId);

        if (existingUser.isPresent()) {
            // Update user properties based on your needs
            UserEntity updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setEmail(user.getEmail());

            return userRepository.save(updatedUser);
        } else {
            // Handle the case where the user with the given id is not found
            throw new RuntimeException("User not found with id: " + userId);
        }
    }

    public String deleteUser(int userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return "User with ID " + userId + " deleted successfully";
        } else {
            return "User with ID " + userId + " not found";
        }
    }
}
