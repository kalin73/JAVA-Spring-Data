package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;

import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.CreateEmployeeDTO;
import com.example.demo.entities.dtos.address.AddressDTO;
import com.example.demo.entities.dtos.address.CreateAddressDTO;
import com.example.demo.services.AddressService;
import com.example.demo.services.EmployeeService;
import com.google.gson.Gson;

//@Component
public class AppMain implements CommandLineRunner {
	private final AddressService addressService;
	private final EmployeeService employeeService;
	private final Scanner sc;
	private final Gson gson;

	public AppMain(AddressService addressService, EmployeeService employeeService, Gson gson, Scanner sc) {
		this.addressService = addressService;
		this.employeeService = employeeService;
		this.gson = gson;
		this.sc = sc;
	}

	@Override
	public void run(String... args) throws Exception {

		createAddress();
		// createEmployee(sc);
		// printAllEmployees();
		// printEmployeeNames();

		// printEmployeeNameAndSalary();

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

		CreateAddressDTO address = new CreateAddressDTO(country, city);

		CreateEmployeeDTO employeeDTO = new CreateEmployeeDTO(firstName, null, salary, birthday, address);

		Employee employee = employeeService.create(employeeDTO);

		System.out.println(employee);
	}

	public void createAddress() {
		String input = sc.nextLine();

		CreateAddressDTO data = this.gson.fromJson(input, CreateAddressDTO.class);

		AddressDTO address = addressService.create(data);

		System.out.println(this.gson.toJson(address));
	}

}
