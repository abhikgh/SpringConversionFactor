package com.example.SpringConversionFactor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

	private String countryCode;
	private Double conversionFactor;

}
