package com.example.SpringConversionFactor.error;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomError> handleException(Exception e) {
		CustomError errors = new CustomError(LocalDateTime.now(),HttpStatus.NOT_FOUND.value(),e.getMessage());
        return new ResponseEntity<CustomError>(errors, HttpStatus.NOT_FOUND);
    }
	
}
