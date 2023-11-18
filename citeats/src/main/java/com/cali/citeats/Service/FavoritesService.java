package com.cali.citeats.Service;

import com.cali.citeats.Entity.FavoritesEntity;
import com.cali.citeats.Repository.FavoritesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritesService {

    private final FavoritesRepository favoritesRepository;

    @Autowired
    public FavoritesService(FavoritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }

    public List<FavoritesEntity> getAllFavorites() {
        return favoritesRepository.findAll();
    }

    public FavoritesEntity getFavoriteById(int id) {
        Optional<FavoritesEntity> favorite = favoritesRepository.findById(id);
        return favorite.orElse(null);
    }

    public FavoritesEntity createFavorite(FavoritesEntity favorite) {
        return favoritesRepository.save(favorite);
    }

    public FavoritesEntity updateFavorite(int id, FavoritesEntity favorite) {
        Optional<FavoritesEntity> existingFavorite = favoritesRepository.findById(id);

        if (existingFavorite.isPresent()) {
            favorite.setFavoriteId(id);
            return favoritesRepository.save(favorite);
        } else {
            return null;
        }
    }

    public boolean deleteFavorite(int id) {
        if (favoritesRepository.existsById(id)) {
            favoritesRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
