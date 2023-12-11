package com.cali.citeats.Repository;

import com.cali.citeats.Entity.FavoritesEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<FavoritesEntity, Integer> {
    // You can add custom query methods if needed
    List<FavoritesEntity> findAllByUserId(int userId);
}