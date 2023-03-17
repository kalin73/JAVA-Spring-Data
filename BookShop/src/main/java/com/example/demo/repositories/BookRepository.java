package com.example.demo.repositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.dto.BookInformation;
import com.example.demo.domain.entities.Book;
import com.example.demo.domain.enums.AgeRestriction;
import com.example.demo.domain.enums.EditionType;

public interface BookRepository extends JpaRepository<Book, Long> {
	Optional<List<Book>> findAllBookByReleaseDateAfter(LocalDate localDate);

	Optional<List<Book>> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName,
			String lastName);

	Optional<List<Book>> findAllByAgeRestriction(AgeRestriction ageRestriction);

	Optional<List<Book>> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int count);

	Optional<List<Book>> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal less, BigDecimal more);

	Optional<List<Book>> findAllByReleaseDateNot(LocalDate date);

	Optional<List<Book>> findAllByReleaseDateBefore(LocalDate date);

	Optional<List<Book>> findAllByTitleContaining(String contains);

	Optional<List<Book>> findAllByAuthorLastNameStartingWith(String prefix);

	@Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :length")
	Optional<Integer> findCountOfBooksByBookTitleLongerThan(Integer length);

	@Query("SELECT new com.example.demo.domain.dto.BookInformation(b.title, b.editionType, b.ageRestriction, b.price)"
			+ " FROM Book b WHERE b.title = :title")
	Optional<BookInformation> findFirstByTitle(String title);

	@Query("UPDATE Book b SET b.copies = b.copies + :copies " + "WHERE b.releaseDate > :date")
	@Modifying
	@Transactional
	int increaseBookCopies(LocalDate date, int copies);
	
	@Transactional
	int deleteAllByCopiesLessThan(int copies);
}
