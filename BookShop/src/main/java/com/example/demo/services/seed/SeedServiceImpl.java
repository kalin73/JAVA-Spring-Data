package com.example.demo.services.seed;

import static com.example.demo.constants.FilePath.AUTHOR_FILE_NAME;
import static com.example.demo.constants.FilePath.BOOK_FILE_NAME;
import static com.example.demo.constants.FilePath.CATEGORY_FILE_NAME;
import static com.example.demo.constants.FilePath.RESOURCE_URL;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.domain.entities.Author;
import com.example.demo.domain.entities.Book;
import com.example.demo.domain.entities.Category;
import com.example.demo.domain.enums.AgeRestriction;
import com.example.demo.domain.enums.EditionType;
import com.example.demo.services.author.AuthorService;
import com.example.demo.services.book.BookService;
import com.example.demo.services.category.CategoryService;

@Component
public class SeedServiceImpl implements SeedService {
	private final BookService bookService;
	private final CategoryService categoryService;
	private final AuthorService authorService;

	public SeedServiceImpl(BookService bookService, CategoryService categoryService, AuthorService authorService) {
		this.bookService = bookService;
		this.categoryService = categoryService;
		this.authorService = authorService;
	}

	@Override
	public void seedAuthors() throws IOException {
		if (!this.authorService.isDataSeeded()) {
			this.authorService
					.seedAuthors(
							Files.readAllLines(Path.of(RESOURCE_URL + AUTHOR_FILE_NAME)).stream()
									.filter(s -> !s.isBlank())
									.map(firstAndLastName -> Author.builder().firstName(firstAndLastName.split(" ")[0])
											.lastName(firstAndLastName.split(" ")[1]).build())
									.collect(Collectors.toList()));
		}

	}

	@Override
	public void seedCategories() throws IOException {
		if (!this.categoryService.isDataSeeded()) {
			this.categoryService.seedCategories(
					Files.readAllLines(Path.of(RESOURCE_URL + CATEGORY_FILE_NAME)).stream().filter(s -> !s.isBlank())
							.map(name -> Category.builder().name(name).build()).collect(Collectors.toList()));
		}
	}

	@Override
	public void seedBooks() throws IOException {
		List<Book> books = Files.readAllLines(Path.of(RESOURCE_URL + BOOK_FILE_NAME))
				.stream()
				.filter(s -> !s.isBlank())
				.map(row -> {
					String[] data = row.split("\\s+");
					
					String title = Arrays.stream(data)
							.skip(5)
							.collect(Collectors.joining(" "));

            return Book.builder()
            		.title(title)
            		.editionType(EditionType.values()[Integer.parseInt(data[0])])
            		.price(new BigDecimal(data[3]))
            		.releaseDate(LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
            		.ageRestriction(AgeRestriction.values()[Integer.parseInt(data[4])])
            		.author(this.authorService.getRandomAuthor())
            		.categories( categoryService.getRandomCategories())
            		.copies(Integer.parseInt(data[2]))
            		.build();

				
			})
				.collect(Collectors.toList());
		
		this.bookService.seedBooks(books);

	}

}
