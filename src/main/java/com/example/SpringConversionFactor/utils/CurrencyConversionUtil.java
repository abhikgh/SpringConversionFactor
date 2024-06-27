package com.example.SpringConversionFactor.utils;

import java.util.HashMap;
import java.util.Map;

import com.example.SpringConversionFactor.entity.CurrencyConversion;

public class CurrencyConversionUtil {

	private static  Map<String,Double> currencyMap = new HashMap<>();
	
	public static void saveCurrency(CurrencyConversion currencyConversion) {
		currencyMap.put(currencyConversion.getCountryCode(), currencyConversion.getConversionFactor());
	}
	
	public static CurrencyConversion getCurrencyFromCountryCode (String countryCode) {
		CurrencyConversion currencyConversion = new CurrencyConversion();
		currencyConversion.setCountryCode(countryCode);
		currencyConversion.setConversionFactor(currencyMap.get(countryCode));
		return currencyConversion;
	}
	
}
