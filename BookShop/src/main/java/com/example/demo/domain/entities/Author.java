package com.example.demo.domain.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "authors")
public class Author extends BaseEntity {
	@Column
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@OneToMany(targetEntity = Book.class, mappedBy = "author")
	private Set<Book> books;
}
