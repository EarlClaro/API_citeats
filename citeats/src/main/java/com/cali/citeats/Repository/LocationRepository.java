package com.cali.citeats.Repository;

import com.cali.citeats.Entity.LocationEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

    // You can add custom queries here if needed

}
