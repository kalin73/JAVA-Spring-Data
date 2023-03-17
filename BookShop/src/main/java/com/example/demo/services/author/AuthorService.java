package com.example.demo.services.author;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.domain.entities.Author;

public interface AuthorService {
	void seedAuthors(List<Author> authors);

	boolean isDataSeeded();

	Author getRandomAuthor();
	
	List<Author> findDistinctByBooksBefore(LocalDate date);
	
	List<Author> findAllByFirstNameEndsWith(String suffix);
}
