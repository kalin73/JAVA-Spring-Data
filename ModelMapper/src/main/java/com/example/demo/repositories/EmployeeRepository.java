package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.EmployeeNameAndSalaryDTO;
import com.example.demo.entities.dtos.EmployeeNamesDTO;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT new com.example.demo.entities.dtos.EmployeeNamesDTO (e.firstName, e.lastName) FROM Employee e WHERE e.id = :id")
	EmployeeNamesDTO findNamesById(long id);
	
	EmployeeNameAndSalaryDTO findFirstNameAndSalaryById(long id);

}
