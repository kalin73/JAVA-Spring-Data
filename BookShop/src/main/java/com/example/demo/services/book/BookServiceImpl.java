package com.example.demo.services.book;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.BookInformation;
import com.example.demo.domain.entities.Book;
import com.example.demo.domain.enums.AgeRestriction;
import com.example.demo.domain.enums.EditionType;
import com.example.demo.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private final BookRepository bookRepository;

	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void seedBooks(List<Book> books) {
		this.bookRepository.saveAll(books);

	}

	@Override
	public List<Book> findAllBookByReleaseDateAfter(LocalDate localDate) {
		return this.bookRepository.findAllBookByReleaseDateAfter(localDate).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName,
			String lastName) {
		return this.bookRepository
				.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName)
				.orElseThrow(NoSuchElementException::new);

	}

	@Override
	public List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction) {
		return this.bookRepository.findAllByAgeRestriction(ageRestriction).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, int count) {
		return this.bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, count)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Book> findAllByPriceLessThanOrMoreThan(BigDecimal less, BigDecimal more) {
		return this.bookRepository.findAllByPriceLessThanOrPriceGreaterThan(less, more)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Book> findAllByReleaseDateNot(LocalDate date) {
		return this.bookRepository.findAllByReleaseDateNot(date).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Book> findAllByReleaseDateBefore(LocalDate date) {
		return this.bookRepository.findAllByReleaseDateBefore(date).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Book> findAllByTitleContaining(String contains) {
		return this.bookRepository.findAllByTitleContaining(contains).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Book> findAllByAuthorLastNameStartingWith(String prefix) {
		return this.bookRepository.findAllByAuthorLastNameStartingWith(prefix).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public Integer findCountOfBooksByBookTitleLongerThan(Integer length) {
		return this.bookRepository.findCountOfBooksByBookTitleLongerThan(length)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public BookInformation findFirstByTitle(String title) {
		return this.bookRepository.findFirstByTitle(title).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public int increaseBookCopies(LocalDate date, int copies) {
		int count = this.bookRepository.increaseBookCopies(date, copies);

		System.out.println(count * copies);
		
		return count;
	}

	@Override
	public int deleteAllByCopiesLessThan(int copies) {
		return this.bookRepository.deleteAllByCopiesLessThan(copies);
	}

}
