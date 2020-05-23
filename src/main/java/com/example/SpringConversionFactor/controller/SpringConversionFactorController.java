package com.example.SpringConversionFactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringConversionFactor.entity.CurrencyConversion;
import com.example.SpringConversionFactor.repository.CurrencyConversionRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/eureka/v1")
@Slf4j
public class SpringConversionFactorController {

	@Autowired
	private CurrencyConversionRepository currencyConversionRepository;
	
	// http://localhost:8061/eureka/v1/addConversionFactor
	@PostMapping(value="/addConversionFactor",produces="application/json")
	@HystrixCommand(fallbackMethod="getDataFallBack")
	public ResponseEntity<CurrencyConversion> addConversionFactor(@RequestBody CurrencyConversion currencyConversion) throws Exception{
		log.info("in addConversionFactor ... " + currencyConversion);
		currencyConversionRepository.save(currencyConversion);
		return new ResponseEntity<>(currencyConversion, HttpStatus.OK);
	}
	
	// http://localhost:8061/eureka/v1/updateConversionFactor
	@PostMapping(value="/updateConversionFactor",produces="application/json")
	public ResponseEntity<CurrencyConversion> updateConversionFactor(@RequestBody CurrencyConversion currencyConversion){
		log.info("in updateConversionFactor ... " + currencyConversion);
		CurrencyConversion currencyConversion2 = currencyConversionRepository.getCurrencyFromCountryCode(currencyConversion.getCountryCode());
		currencyConversion2.setConversionFactor(currencyConversion.getConversionFactor());
		currencyConversionRepository.save(currencyConversion2);
		return new ResponseEntity<>(currencyConversion2, HttpStatus.OK);
	}
	
	
	// http://localhost:8061/eureka/v1/getConversionFactor
	@GetMapping(value="/getConversionFactor/{countryCode}",produces="application/json")
	public ResponseEntity<Double> getConversionFactor(@PathVariable String countryCode){
		log.info("in getConversionFactor ... " + countryCode);
		CurrencyConversion currencyConversion = currencyConversionRepository.getCurrencyFromCountryCode(countryCode);
		return new ResponseEntity<Double>(currencyConversion.getConversionFactor(), HttpStatus.OK);
	}
	
	public ResponseEntity<CurrencyConversion> getDataFallBack() {
		log.info("In fallback method...");
		CurrencyConversion currencyConversion = new CurrencyConversion(5478,"USA",1.00);
		return ResponseEntity.ok(currencyConversion);
	}
}
