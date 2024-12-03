package com.sigcart.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigcart.course.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

	
	
}
