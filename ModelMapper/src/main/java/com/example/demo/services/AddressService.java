package com.example.demo.services;

import com.example.demo.entities.Address;
import com.example.demo.entities.dtos.AddressDTO;

public interface AddressService {

	Address create(AddressDTO data);

}
