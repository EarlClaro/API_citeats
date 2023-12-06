package com.cali.citeats.Repository;

import com.cali.citeats.Entity.MenuItemEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity, Integer> {

	List<MenuItemEntity> findByRestaurantId(int restaurantId);
    // You can add custom query methods if needed
}
