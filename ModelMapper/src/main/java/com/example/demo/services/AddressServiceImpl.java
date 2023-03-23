package com.example.demo.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Address;
import com.example.demo.entities.dtos.addresses.AddressDTO;
import com.example.demo.entities.dtos.addresses.CreateAddressDTO;
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
	public AddressDTO create(CreateAddressDTO data) {
		Address address = mapper.map(data, Address.class);

		Address saved = this.addressRepository.save(address);

		return this.mapper.map(saved, AddressDTO.class);
	}

}
