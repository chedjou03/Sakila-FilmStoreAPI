package com.FilmStoreAPI.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.FilmStoreAPI.CustomerData.entity.EntityErrorResponse;
import com.FilmStoreAPI.error.EntityAlreadyExistedException;
import com.FilmStoreAPI.error.EntityNotFoundException;

@ControllerAdvice
public class EntityRestExceptionHandler 
{
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleStudentNotFoundException(EntityNotFoundException exc)
	{
		EntityErrorResponse error = new EntityErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleEntityAlreadyExistedException(EntityAlreadyExistedException exc)
	{
		EntityErrorResponse error = new EntityErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<EntityErrorResponse> handleGenericException(Exception exc)
	{
		EntityErrorResponse error = new EntityErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}

}
