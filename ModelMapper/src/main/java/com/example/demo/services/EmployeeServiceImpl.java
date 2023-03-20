package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Address;
import com.example.demo.entities.Employee;
import com.example.demo.entities.dtos.CreateEmployeeDTO;
import com.example.demo.entities.dtos.EmployeeDTO;
import com.example.demo.entities.dtos.EmployeeNameAndSalaryDTO;
import com.example.demo.entities.dtos.EmployeeNamesDTO;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final AddressRepository addressRepository;
	private final ModelMapper mapper;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository,
			ModelMapper mapper) {
		this.employeeRepository = employeeRepository;
		this.addressRepository = addressRepository;
		this.mapper = mapper;
	}

	@Override
	@Transactional
	public Employee create(CreateEmployeeDTO employeeDTO) {
		Employee employee = mapper.map(employeeDTO, Employee.class);

		Optional<Address> address = this.addressRepository.findByCountryAndCity(employeeDTO.getAddress().getCountry(),
				employeeDTO.getAddress().getCity());

		address.ifPresent(employee::setAddress);

		return this.employeeRepository.save(employee);
	}

	@Override
	public List<EmployeeDTO> findAll() {

		return this.employeeRepository.findAll().stream().map(x -> mapper.map(x, EmployeeDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeNamesDTO findNamesById(long id) {
		return this.employeeRepository.findNamesById(id);
	}
	
	@Override
	public EmployeeNameAndSalaryDTO findNameAndSalaryById(long id) {
		return this.employeeRepository.findFirstNameAndSalaryById(id);
	}

}
