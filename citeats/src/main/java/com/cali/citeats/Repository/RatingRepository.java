// RatingRepository
package com.cali.citeats.Repository;

import com.cali.citeats.Entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<RatingEntity, Integer> {

    // Define the method to find ratings by restaurantId
    List<RatingEntity> findByRestaurantRestaurantId(int restaurantId);

    @Query("SELECT AVG(r.averageRating) FROM RatingEntity r WHERE r.restaurant.id = :restaurantId")
    Double calculateAverageRatingByRestaurant(@Param("restaurantId") int restaurantId);
}
