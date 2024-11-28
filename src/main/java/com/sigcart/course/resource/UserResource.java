package com.sigcart.course.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sigcart.course.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<User> finAll(){
		
		User u = new User(1L,"Uemerson", "Negreiro273@gmail.com", "65992047706", "12356");
		return ResponseEntity.ok().body(u);
		
	}
	
	

}
