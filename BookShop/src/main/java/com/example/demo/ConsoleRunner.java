package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.services.author.AuthorService;
import com.example.demo.services.book.BookService;

@Component
@SuppressWarnings("unused")
public class ConsoleRunner implements CommandLineRunner {
	private final BookService bookService;

	private final AuthorService authorService;

	private final Scanner sc;

	public ConsoleRunner(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
		this.sc = new Scanner(System.in);

	}

	@Override
	public void run(String... args) throws Exception {

	}

}
