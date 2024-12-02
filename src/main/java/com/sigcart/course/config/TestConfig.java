package com.sigcart.course.config;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sigcart.course.entities.User;
import com.sigcart.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
    private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(0,"Uemerson Negreiro","negreiro273@gmail.com","65992047706","123456"); 
	    User u2 = new User(0, "Alex Green", "alex@gmail.com", "977777777", "123456"); 

	    userRepository.saveAll(Arrays.asList(u1,u2));
	}
	
	
	
	
}