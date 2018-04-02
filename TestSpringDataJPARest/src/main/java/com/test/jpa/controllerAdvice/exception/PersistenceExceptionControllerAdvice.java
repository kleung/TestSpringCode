package com.test.jpa.controllerAdvice.exception;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PersistenceExceptionControllerAdvice {
	
	@ExceptionHandler(value= {PersistenceException.class, EntityNotFoundException.class, RuntimeException.class})
	public ResponseEntity<ErrorRestResponse> handlePersistenceException(RuntimeException re) {
		String errorMessage = re.getMessage();
		
		ErrorRestResponse errorRestResponse = new ErrorRestResponse();
		errorRestResponse.setErrorMessage(errorMessage);
		
		ResponseEntity<ErrorRestResponse> result = new ResponseEntity<ErrorRestResponse>(errorRestResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		return result;
	}

}
