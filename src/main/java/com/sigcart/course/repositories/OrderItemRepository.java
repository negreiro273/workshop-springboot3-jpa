package com.sigcart.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigcart.course.entities.OrderItem;
import com.sigcart.course.entities.pk.OrderItemPK;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

	
	
}
