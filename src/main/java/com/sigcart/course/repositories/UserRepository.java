package com.sigcart.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigcart.course.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
