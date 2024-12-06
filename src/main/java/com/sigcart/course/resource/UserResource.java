package com.sigcart.course.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
	   
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri(); 
		return ResponseEntity.created(uri).body(obj);
		
	}
	
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
	   service.delete(id);
	   return ResponseEntity.noContent().build();		
		
	}

}
