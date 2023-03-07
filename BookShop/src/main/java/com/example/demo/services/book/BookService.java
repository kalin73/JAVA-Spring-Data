package com.example.demo.services.book;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.domain.entities.Book;

public interface BookService {
	void seedBooks(List<Book> books);

	List<Book> findAllBookByReleaseDateAfter(LocalDate localDate);

	List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName,
			String lastName);
}
