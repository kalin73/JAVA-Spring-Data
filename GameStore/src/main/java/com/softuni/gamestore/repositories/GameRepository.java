package com.softuni.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.gamestore.domain.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
	boolean existsByTitle(String title);
}
