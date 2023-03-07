package com.example.demo.services.book;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.domain.entities.Book;
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
}
