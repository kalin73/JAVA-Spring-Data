package com.softuni.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.mvc.models.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<List<Employee>> findAllByAgeGreaterThan(int age);
}
