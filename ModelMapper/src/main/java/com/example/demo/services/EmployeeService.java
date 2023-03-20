package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.CreateEmployeeDTO;
import com.example.demo.entities.dtos.EmployeeDTO;
import com.example.demo.entities.dtos.EmployeeNameAndSalaryDTO;
import com.example.demo.entities.dtos.EmployeeNamesDTO;

public interface EmployeeService {

	Employee create(CreateEmployeeDTO employeeDTO);

	List<EmployeeDTO> findAll();

	EmployeeNamesDTO findNamesById(long id);

	EmployeeNameAndSalaryDTO findNameAndSalaryById(long id);

}
