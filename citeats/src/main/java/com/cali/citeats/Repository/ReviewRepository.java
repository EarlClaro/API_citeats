package com.cali.citeats.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cali.citeats.Entity.ReviewEntity;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {

	List<ReviewEntity> findByRestaurantId(int restaurantId);
	
	List<ReviewEntity> findByUserId(int userId);
	
	List<ReviewEntity> findByIsDeletedFalseAndUserId(int userId);
}
