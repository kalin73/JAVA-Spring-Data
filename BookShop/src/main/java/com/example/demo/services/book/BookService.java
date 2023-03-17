package com.example.demo.services.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.example.demo.domain.dto.BookInformation;
import com.example.demo.domain.entities.Book;
import com.example.demo.domain.enums.AgeRestriction;
import com.example.demo.domain.enums.EditionType;

public interface BookService {
	void seedBooks(List<Book> books);

	List<Book> findAllBookByReleaseDateAfter(LocalDate localDate);

	List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName,
			String lastName);

	List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

	List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int count);

	List<Book> findAllByPriceLessThanOrMoreThan(BigDecimal less, BigDecimal more);

	List<Book> findAllByReleaseDateNot(LocalDate date);

	List<Book> findAllByReleaseDateBefore(LocalDate date);

	List<Book> findAllByTitleContaining(String contains);

	List<Book> findAllByAuthorLastNameStartingWith(String prefix);

	Integer findCountOfBooksByBookTitleLongerThan(Integer length);

	BookInformation findFirstByTitle(String title);
	
	int increaseBookCopies(LocalDate date, int copies);
	
	int deleteAllByCopiesLessThan(int copies);
}
