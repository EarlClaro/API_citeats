package com.cali.citeats.Service;

import com.cali.citeats.Entity.FavoritesEntity;
import com.cali.citeats.Repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:3000") 
public class FavoritesService {

    @Autowired
    private FavoritesRepository favoritesRepository;

    public FavoritesEntity createFavorite(int userId, int restaurantId, String name) {
        FavoritesEntity newFavorite = new FavoritesEntity();
        newFavorite.setUserId(userId);
        newFavorite.setRestaurantId(restaurantId);
        newFavorite.setName(name);
        return favoritesRepository.save(newFavorite);
    }

    public List<FavoritesEntity> getAllFavorites() {
        return favoritesRepository.findAll();
    }

    public FavoritesEntity updateFavorite(int id, int userId, int restaurantId, String name) {
        FavoritesEntity existingFavorite = favoritesRepository.findById(id).orElse(null);
        if (existingFavorite != null) {
            existingFavorite.setUserId(userId);
            existingFavorite.setRestaurantId(restaurantId);
            existingFavorite.setName(name);
            return favoritesRepository.save(existingFavorite);
        }
        return null;
    }

    public boolean deleteFavorite(int id) {
        FavoritesEntity existingFavorite = favoritesRepository.findById(id).orElse(null);
        if (existingFavorite != null) {
            favoritesRepository.delete(existingFavorite);
            return true;
        }
        return false;
    }
}
