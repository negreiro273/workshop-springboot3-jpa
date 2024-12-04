package com.sigcart.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigcart.course.entities.Category;
import com.sigcart.course.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryResource {
	
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category> > finAll(){
		
		//Category u = new Category(1L,"Uemerson", "Negreiro273@gmail.com", "65992047706", "12356");
		
		List<Category> list = service.findAll();			
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id ){
		
		Category obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	

}
