package com.example.SpringConversionFactor.error;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomError {
	private LocalDateTime timestamp;
	private int status;
    private String errorMessage;
}
