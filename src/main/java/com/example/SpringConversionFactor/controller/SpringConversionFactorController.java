package com.example.SpringConversionFactor.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringConversionFactor.entity.CurrencyConversion;
import com.example.SpringConversionFactor.utils.CurrencyConversionUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/eureka/v1")
@Slf4j
public class SpringConversionFactorController {

	// http://localhost:8061/eureka/v1/addConversionFactor
	@PostMapping(value="/addConversionFactor",produces="application/json")
	public ResponseEntity<CurrencyConversion> addConversionFactor(@RequestBody CurrencyConversion currencyConversion) throws Exception{
		log.info("in addConversionFactor ... " + currencyConversion);
		CurrencyConversionUtil.saveCurrency(currencyConversion);
		return ResponseEntity.ok(currencyConversion);
	}
	
	// http://localhost:8061/eureka/v1/updateConversionFactor
	@PostMapping(value="/updateConversionFactor",produces="application/json")
	public ResponseEntity<CurrencyConversion> updateConversionFactor(@RequestBody CurrencyConversion currencyConversion){
		log.info("in updateConversionFactor ... " + currencyConversion);
		CurrencyConversion currencyConversion2 = CurrencyConversionUtil.getCurrencyFromCountryCode(currencyConversion.getCountryCode());
		currencyConversion2.setConversionFactor(currencyConversion.getConversionFactor());
		CurrencyConversionUtil.saveCurrency(currencyConversion2);
		return ResponseEntity.ok(currencyConversion2);
	}
	
	
	// http://localhost:8061/eureka/v1/getConversionFactor
	@GetMapping(value="/getConversionFactor/{countryCode}",produces="application/json")
	public ResponseEntity<Double> getConversionFactor(@PathVariable String countryCode){
		log.info("in getConversionFactor ... " + countryCode);
		CurrencyConversion currencyConversion = CurrencyConversionUtil.getCurrencyFromCountryCode(countryCode);
		return ResponseEntity.ok(currencyConversion.getConversionFactor());
	}
	
	public ResponseEntity<CurrencyConversion> getDataFallBack(@RequestBody CurrencyConversion currencyConversion) {
		log.error("In fallback method...");
		CurrencyConversion currencyConversion2 = new CurrencyConversion("USA",1.00);
		return ResponseEntity.ok(currencyConversion2);
	}
}
