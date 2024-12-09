package com.sigcart.course.resource.exceptions;

import java.sql.DatabaseMetaData;
import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sigcart.course.service.exceptions.DatabaseException;
import com.sigcart.course.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/*  @ControllerAdvice É uma anotação que permite definir tratamento global de exceções ou fornecer
 *   comportamentos específicos que devem ser aplicados a um grupo ou a
 *    todos os controladores de uma aplicação. */
@ControllerAdvice
public class ResourceExceptionHandler {


	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
		
	}
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(),status.value(),error,e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
		
	}	
	
	
}
