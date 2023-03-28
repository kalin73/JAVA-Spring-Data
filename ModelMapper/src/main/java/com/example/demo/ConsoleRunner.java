package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Address;
import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.EmployeeDTO;
import com.example.demo.entities.dtos.converterTest.Birthday;
import com.example.demo.entities.dtos.converterTest.BirthdayDto;

@Component
public class ConsoleRunner implements CommandLineRunner {
	private final ModelMapper mapper;

	public ConsoleRunner(ModelMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void run(String... args) throws Exception {
		ModelMapper mapper = new ModelMapper();

		testConverter();

//		PropertyMap<Employee, EmployeeDTO> propertyMap = new PropertyMap<>() {
//
//			@Override
//			protected void configure() {
//				map().setCity(source.getAddress().getCity());
//
//			}
//
//		};
//		 mapper.addMappings(propertyMap);

//
//		TypeMap<Employee, EmployeeDTO> typeMap = mapper.createTypeMap(Employee.class, EmployeeDTO.class);
//		typeMap.addMappings(
//				mapping -> mapping.map(source -> source.getAddress().getCity(), EmployeeDTO::setAddressCity));
//		typeMap.validate();
//
//		Address address = new Address("Bulgaria", "Sofia");
//		Employee employee = new Employee("First", BigDecimal.TEN, address);
//
//		EmployeeDTO employeeDTO = typeMap.map(employee);
//
//		System.out.println(employeeDTO);

	}

	private void testConverter() {
		Birthday birthday = new Birthday();
		birthday.setDate(LocalDate.now());

		BirthdayDto dto = this.mapper.map(birthday, BirthdayDto.class);

		Birthday bd = this.mapper.map(dto, Birthday.class);

		System.out.println(bd.getDate());
	}

}
