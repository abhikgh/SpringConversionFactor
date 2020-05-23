package com.example.SpringConversionFactor.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CurrencyException extends RuntimeException{
	private String errorCode;
	private String errorMessage;
	private HttpStatus httpStatus;
}
