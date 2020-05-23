package com.example.SpringConversionFactor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="CURRENCY_CONVERSION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "country_code", length=3)
	@NotEmpty
	private String countryCode;

	@Column(name = "conversion_factor")
	@NotNull
	private Double conversionFactor;
	
}
