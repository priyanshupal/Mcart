package com.training.carts.exception;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionControllerAdvice {
	
//	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(MCartException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler2(MCartException ex) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
//	@ExceptionHandler(CartAlreadyExistsException.class)
//	public ResponseEntity<ErrorMessage> exceptionHandler3(CartAlreadyExistsException ex) {
//		ErrorMessage error = new ErrorMessage();
//		error.setErrorCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
//		error.set
//	}
}
