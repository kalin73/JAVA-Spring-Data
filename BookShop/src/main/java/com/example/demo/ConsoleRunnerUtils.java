package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

import com.example.demo.domain.enums.AgeRestriction;
import com.example.demo.domain.enums.EditionType;
import com.example.demo.services.author.AuthorService;
import com.example.demo.services.book.BookService;

@Component
public class ConsoleRunnerUtils {

	private final LocalDate BOOK_YEAR_AFTER = LocalDate.of(2000, 1, 1);

	private final LocalDate BOOK_YEAR_BEFORE = LocalDate.of(1990, 1, 1);

	private final BookService bookService;

	private final AuthorService authorService;

	public ConsoleRunnerUtils(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}

	public void getAllBooksAfterAGivenYear() {
		this.bookService.findAllBookByReleaseDateAfter(BOOK_YEAR_AFTER)
				.forEach(book -> System.out.println(book.getTitle()));

	}

	public void getAllAuthorsWithBooksReleasedDateBefore() {
		this.authorService.findDistinctByBooksBefore(BOOK_YEAR_BEFORE)
				.forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
	}

	public void getAllBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDate() {
		this.bookService.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell")
				.forEach(book -> System.out
						.println(book.getTitle() + " " + book.getReleaseDate() + " " + book.getCopies()));
	}

	public void booksTitlesByAgeRestriction(String ageRestrictionType) {
		final AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionType.toUpperCase());

		this.bookService.findAllByAgeRestriction(ageRestriction).forEach(book -> System.out.println(book.getTitle()));
	}

	public void goldenBookWithLessThan5000Copies() {
		this.bookService.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000)
				.forEach(book -> System.out.println(book.getTitle()));
	}

	public void booksByPrice() {
		this.bookService.findAllByPriceLessThanOrMoreThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
				.forEach(book -> System.out.println(book.getTitle() + " " + book.getPrice()));
	}

	public void notReleasedBook() {
		this.bookService.findAllByReleaseDateNot(LocalDate.of(2000, 1, 1))
				.forEach(book -> System.out.println(book.getTitle()));
	}

	public void booksReleasedBeforeDate() {
		this.bookService.findAllByReleaseDateBefore(LocalDate.of(1992, 4, 12)).forEach(
				book -> System.out.println(book.getTitle() + " " + book.getEditionType() + " " + book.getPrice()));
	}

	public void authorSearch(String arg) {
		this.authorService.findAllByFirstNameEndsWith(arg)
				.forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
	}

	public void booksSearchByContainingArgument(String arg) {
		this.bookService.findAllByTitleContaining(arg).forEach(book -> System.out.println(book.getTitle()));
	}

	public void bookSearchByAuthorLastNameStartingWith(String arg) {
		this.bookService.findAllByAuthorLastNameStartingWith(arg).forEach(book -> System.out.println(
				book.getTitle() + " " + book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName()));
	}

	public void findCountOfBookByTitleLength(String arg) {
		System.out.println(this.bookService.findCountOfBooksByBookTitleLongerThan(Integer.parseInt(arg)));
	}

	public void increaseBookCopies(LocalDate date, int copies) {
		this.bookService.increaseBookCopies(date, copies);
	}

	public void deleteBooksByCopiesLessThan(int copies) {
		System.out.println(this.bookService.deleteAllByCopiesLessThan(copies));
	}
}
