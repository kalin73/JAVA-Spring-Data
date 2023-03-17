package com.example.demo.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.example.demo.domain.enums.AgeRestriction;
import com.example.demo.domain.enums.EditionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book extends BaseEntity {
	@Column(nullable = false, length = 50)
	private String title;

	@Column(length = 1000)
	private String description;

	@Enumerated(EnumType.STRING)
	private EditionType editionType;

	@Column(nullable = false)
	private BigDecimal price;

	@Column(nullable = false)
	private Integer copies;

	@Column
	private LocalDate releaseDate;

	@Enumerated(EnumType.STRING)
	private AgeRestriction ageRestriction;

	@ManyToOne
	private Author author;

	@ManyToMany
	private Set<Category> categories;
}
