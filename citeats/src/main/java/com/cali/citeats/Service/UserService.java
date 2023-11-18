package com.cali.citeats.Service;

import com.cali.citeats.Entity.UserEntity;
import com.cali.citeats.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user) {
        // Add any additional validation or business logic before saving
        return userRepository.save(user);
    }

    public UserEntity updateUser(int id, UserEntity user) {
        Optional<UserEntity> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            // Update user properties based on your needs
            UserEntity updatedUser = existingUser.get();
            updatedUser.setUsername(user.getUsername());
            updatedUser.setPassword(user.getPassword());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setUserType(user.getUserType());

            return userRepository.save(updatedUser);
        } else {
            // Handle the case where the user with the given id is not found
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    public String deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User with ID " + id + " deleted successfully";
        } else {
            return "User with ID " + id + " not found";
        }
    }
}
