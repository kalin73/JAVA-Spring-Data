package com.softuni.mvc.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.softuni.mvc.models.dtos.employees.EmployeesOverAge;
import com.softuni.mvc.models.dtos.employees.ImportEmployeesDto;
import com.softuni.mvc.models.entities.Employee;
import com.softuni.mvc.repositories.EmployeeRepository;
import com.softuni.mvc.repositories.ProjectRepository;
import com.softuni.mvc.utils.ValidationUtil;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final ProjectRepository projectRepository;
	private final ModelMapper modelMapper;
	private final ValidationUtil validationUtil;

	public EmployeeService(EmployeeRepository employeeRepository, ProjectRepository projectRepository,
			ModelMapper modelMapper, ValidationUtil validationUtil) {
		this.employeeRepository = employeeRepository;
		this.projectRepository = projectRepository;
		this.modelMapper = modelMapper;
		this.validationUtil = validationUtil;
	}

	public String getXMLContent() throws IOException {
		return String.join("\n",
				Files.readAllLines(Path.of("src", "main", "resources", "files", "xmls", "employees.xml")));
	}

	public void importEmployees() throws IOException, JAXBException {
		String xmlContent = this.getXMLContent();
		ByteArrayInputStream stream = new ByteArrayInputStream(xmlContent.getBytes());

		JAXBContext context = JAXBContext.newInstance(ImportEmployeesDto.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ImportEmployeesDto employeesDto = (ImportEmployeesDto) unmarshaller.unmarshal(stream);

		List<Employee> employees = employeesDto.getEmployees()
				.stream()
				.filter(this.validationUtil::isValid)
				.filter(employeeDto -> this.projectRepository.findFirstByName(employeeDto.getProject().getName()).isPresent())
				.map(employeeDto -> modelMapper.map(employeeDto, Employee.class))
				.map(employee -> employee.builderWithProject(this.projectRepository.findFirstByName(employee.getProject().getName()).get()))
				.toList();

		this.employeeRepository.saveAll(employees);

	}

	public boolean areImported() {
		return this.employeeRepository.count() > 0;

	}

	public String getEmployeesOverAge() {
		return this.employeeRepository.findAllByAgeGreaterThan(25).orElseThrow(NoSuchElementException::new)
				.stream()
				.map(employee -> modelMapper.map(employee,EmployeesOverAge.class))
				.map(employee -> employee.toString())
				.collect(Collectors.joining(System.lineSeparator()));
	}
}
