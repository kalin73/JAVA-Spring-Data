package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Optional<Address> findByCountryAndCity(String country, String city);

}
