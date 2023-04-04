package com.softuni.mvc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.mvc.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsernameAndPassword(String username, String password);

}
