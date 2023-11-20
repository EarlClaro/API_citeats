package com.cali.citeats.Controller;

import com.cali.citeats.Entity.FavoritesEntity;
import com.cali.citeats.Service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    // C - Create a favorite
    @PostMapping("/createFavorite")
    public ResponseEntity<FavoritesEntity> createFavorite(@RequestBody FavoritesEntity favorite) {
        FavoritesEntity createdFavorite = favoritesService.createFavorite(
            favorite.getUserId(),
            favorite.getRestaurantId(),
            favorite.getName()
        );
        return new ResponseEntity<>(createdFavorite, HttpStatus.CREATED);
    }

    // R - Read all favorites
    @GetMapping("/getAllFavorites")
    public ResponseEntity<List<FavoritesEntity>> getAllFavorites() {
        List<FavoritesEntity> favorites = favoritesService.getAllFavorites();
        return new ResponseEntity<>(favorites, HttpStatus.OK);
    }

    // U - Update a favorite
    @PutMapping("/updateFavorite/{id}")
    public ResponseEntity<FavoritesEntity> updateFavorite(@PathVariable int id, @RequestBody FavoritesEntity favorite) {
        FavoritesEntity updatedFavorite = favoritesService.updateFavorite(
            id,
            favorite.getUserId(),
            favorite.getRestaurantId(),
            favorite.getName()
        );
        if (updatedFavorite != null) {
            return new ResponseEntity<>(updatedFavorite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // D - Delete a favorite
    @DeleteMapping("/deleteFavorite/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable int id) {
        if (favoritesService.deleteFavorite(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}