package com.sigcart.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sigcart.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
