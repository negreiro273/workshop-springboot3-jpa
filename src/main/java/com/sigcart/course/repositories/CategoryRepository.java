package com.sigcart.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigcart.course.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	
}
