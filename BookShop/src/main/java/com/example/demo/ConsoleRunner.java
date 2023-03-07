package com.example.demo;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.demo.services.author.AuthorService;
import com.example.demo.services.book.BookService;
import com.example.demo.services.seed.SeedService;

@Component
public class ConsoleRunner implements CommandLineRunner {
	private final LocalDate BOOK_YEAR_AFTER = LocalDate.of(2000, 1, 1);

	private final LocalDate BOOK_YEAR_BEFORE = LocalDate.of(1990, 1, 1);

	private final SeedService seedService;

	private final BookService bookService;

	private final AuthorService authorService;

	public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
		this.seedService = seedService;
		this.bookService = bookService;
		this.authorService = authorService;
	}

	@Override
	public void run(String... args) throws Exception {
		this.seedService.seedAllData();
		this.getAllBooksAfterAGivenYear();
		this.getAllAuthorsWithBooksReleasedDateBefore();
		this.getAllAuthorsOrderByBooks();
		this.getAllBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDate();
	}

	private void getAllBooksAfterAGivenYear() {
		this.bookService.findAllBookByReleaseDateAfter(BOOK_YEAR_AFTER)
				.forEach(book -> System.out.println(book.getTitle()));

	}

	private void getAllAuthorsWithBooksReleasedDateBefore() {
		this.authorService.findDistinctByBooksBefore(BOOK_YEAR_BEFORE)
				.forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
	}

	private void getAllAuthorsOrderByBooks() {
		this.authorService.findAllGroupByBooksOrderByCount().forEach(author -> System.out
				.println(author.getFirstName() + " " + author.getLastName() + " " + author.getBooks().size()));
	}

	private void getAllBooksByAuthorFirstNameAndAuthorLastNameOrderByReleaseDate() {
		this.bookService.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell")
				.forEach(book -> System.out
						.println(book.getTitle() + " " + book.getReleaseDate() + " " + book.getCopies()));
	}

}
