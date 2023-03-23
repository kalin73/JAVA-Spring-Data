package com.example.demo.services;

import com.example.demo.entities.dtos.addresses.AddressDTO;
import com.example.demo.entities.dtos.addresses.CreateAddressDTO;

public interface AddressService {

	AddressDTO create(CreateAddressDTO data);

}
