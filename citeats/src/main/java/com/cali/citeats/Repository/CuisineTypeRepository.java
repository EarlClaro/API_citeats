package com.cali.citeats.Repository;

import com.cali.citeats.Entity.CuisineTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuisineTypeRepository extends JpaRepository<CuisineTypeEntity, Integer> {
    // You can add custom query methods if needed
}
