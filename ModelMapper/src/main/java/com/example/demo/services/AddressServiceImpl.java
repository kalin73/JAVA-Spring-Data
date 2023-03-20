package com.example.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Address;
import com.example.demo.entities.dtos.AddressDTO;
import com.example.demo.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
	private final AddressRepository addressRepository;
	private final ModelMapper mapper;

	public AddressServiceImpl(AddressRepository addressRepository, ModelMapper mapper) {
		this.addressRepository = addressRepository;
		this.mapper = mapper;
	}

	@Override
	public Address create(AddressDTO data) {
		Address address = mapper.map(data, Address.class);

		return this.addressRepository.save(address);
	}

}
