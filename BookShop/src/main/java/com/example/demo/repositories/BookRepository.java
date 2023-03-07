package com.example.demo.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<List<Book>> findAllBookByReleaseDateAfter(LocalDate localDate);

	Optional<List<Book>> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName,
			String lastName);
}
