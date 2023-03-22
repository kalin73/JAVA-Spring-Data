package com.softuni.gamestore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softuni.gamestore.domain.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
