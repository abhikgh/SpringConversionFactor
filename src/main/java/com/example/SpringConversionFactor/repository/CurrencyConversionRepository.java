package com.example.SpringConversionFactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SpringConversionFactor.entity.CurrencyConversion;

@Repository
public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Integer> {

	@Query("select c from CurrencyConversion c where c.countryCode = :countryCode")
	public CurrencyConversion getCurrencyFromCountryCode(String countryCode);

}
