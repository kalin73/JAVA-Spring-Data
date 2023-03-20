package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Address;
import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.AddressDTO;
import com.example.demo.entities.dtos.CreateEmployeeDTO;
import com.example.demo.services.AddressService;
import com.example.demo.services.EmployeeService;

@Component
public class AppMain implements CommandLineRunner {
	private final AddressService addressService;
	private final EmployeeService employeeService;

	public AppMain(AddressService addressService, EmployeeService employeeService) {
		this.addressService = addressService;
		this.employeeService = employeeService;
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// createAddress(sc);
		// createEmployee(sc);
		// printAllEmployees();
		// printEmployeeNames();

		printEmployeeNameAndSalary();

		sc.close();

	}

	public void printEmployeeNameAndSalary() {
		System.out.println(this.employeeService.findNameAndSalaryById(1L));

	}

	public void printEmployeeNames() {
		System.out.println(this.employeeService.findNamesById(1l));

	}

	public void printAllEmployees() {
		this.employeeService.findAll().forEach(System.out::println);

	}

	public void createEmployee(Scanner sc) {
		String firstName = sc.nextLine();
		BigDecimal salary = new BigDecimal(sc.nextLine());
		LocalDate birthday = LocalDate.parse(sc.nextLine());

		String country = sc.nextLine();
		String city = sc.nextLine();

		AddressDTO address = new AddressDTO(country, city);

		CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, address);

		Employee employee = employeeService.create(employeeDTO);

		System.out.println(employee);
	}

	public void createAddress(Scanner sc) {
		String country = sc.nextLine();
		String city = sc.nextLine();

		AddressDTO data = new AddressDTO(country, city);

		Address address = addressService.create(data);

		System.out.println(address);
	}

}
