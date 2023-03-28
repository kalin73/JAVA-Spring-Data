package com.example.demo.services;

import com.example.demo.entities.dtos.address.AddressDTO;
import com.example.demo.entities.dtos.address.CreateAddressDTO;

public interface AddressService {

	AddressDTO create(CreateAddressDTO data);

}
