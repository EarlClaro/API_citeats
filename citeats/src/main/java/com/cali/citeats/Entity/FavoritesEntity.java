package com.cali.citeats.Entity;

import javax.persistence.*;

@Entity
@Table(name = "tblfavorite")
public class FavoritesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "favorite_id")
    private int favoriteId;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "restaurant_id")
    private int restaurantId;

    @Column(name = "name", nullable = false)
    private String name;

    public FavoritesEntity() {
        super();
    }

    public FavoritesEntity(int favoriteId, int userId, int restaurantId, String name) {
        super();
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.name = name;
    }

    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
