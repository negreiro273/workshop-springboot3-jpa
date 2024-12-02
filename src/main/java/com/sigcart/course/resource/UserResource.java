package com.sigcart.course.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigcart.course.entities.User;
import com.sigcart.course.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User> > finAll(){
		
		//User u = new User(1L,"Uemerson", "Negreiro273@gmail.com", "65992047706", "12356");
		
		List<User> list = service.findAll();			
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id ){
		
		User obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	

}
