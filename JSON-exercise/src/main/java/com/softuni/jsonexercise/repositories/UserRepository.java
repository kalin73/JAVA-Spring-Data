package com.softuni.jsonexercise.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softuni.jsonexercise.domain.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value="SELECT * FROM `product_shop`.users ORDER BY RAND () LIMIT 1", nativeQuery = true)
	Optional<User>getRandomEntity();
	
	Optional<List<User>> findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerFirstName();
}
