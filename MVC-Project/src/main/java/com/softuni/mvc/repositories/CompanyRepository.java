package com.softuni.mvc.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.mvc.models.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
	Optional<Company> findFirstByName(String name);
}
