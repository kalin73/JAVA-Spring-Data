package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	Optional<List<Author>> findDistinctByBooksReleaseDateBefore(LocalDate date);

	Optional<List<Author>> findAllByFirstNameEndingWith(String suffix);

}
