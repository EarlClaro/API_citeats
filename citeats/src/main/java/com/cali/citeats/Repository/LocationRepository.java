// LocationRepository.java
package com.cali.citeats.Repository;

import com.cali.citeats.Entity.LocationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends CrudRepository<LocationEntity, Integer> {

    @Query("SELECT l FROM LocationEntity l WHERE l.restaurant.restaurantId = :restaurantId")
    List<LocationEntity> findByRestaurantId(@Param("restaurantId") int restaurantId);
}
