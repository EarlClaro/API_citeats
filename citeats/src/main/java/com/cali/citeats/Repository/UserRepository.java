package com.cali.citeats.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cali.citeats.Entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
	
	

}
