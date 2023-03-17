package com.example.demo.services.author;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.springframework.stereotype.*;

import com.example.demo.domain.entities.Author;
import com.example.demo.repositories.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
	private final AuthorRepository authorRepository;

	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}

	@Override
	public void seedAuthors(List<Author> authors) {
		this.authorRepository.saveAll(authors);

	}

	@Override
	public boolean isDataSeeded() {
		return this.authorRepository.count() > 0;
	}

	@Override
	public Author getRandomAuthor() {
		long count = this.authorRepository.count();
		if (count != 0) {
			long randomAuthorId = new Random().nextLong(1, count);
			return this.authorRepository.findById(randomAuthorId).orElseThrow(NoSuchElementException::new);
		}
		throw new RuntimeException();
	}

	@Override
	public List<Author> findDistinctByBooksBefore(LocalDate date) {
		return this.authorRepository.findDistinctByBooksReleaseDateBefore(date)
				.orElseThrow(NoSuchElementException::new);
	}

	@Override
	public List<Author> findAllByFirstNameEndsWith(String suffix) {
		return this.authorRepository.findAllByFirstNameEndingWith(suffix).orElseThrow(NoSuchElementException::new);
	}

}
