/*
 * CS211  (Bonus: Burger)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.28 - Spring Quarter
 *
 * This class polls a currency exchange rate API and returns the exchange rate from USD to the currency given
 * 
 * NOTE: API key is hardcoded here, which is remarkably insecure. It would be neat to learn how to securely get 
 * 	the API key into the URL!	
 * 
 */


package BurgerBonus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ExchangeRate {
	// URL of exchange rate API
	private static String API_URL = "https://v6.exchangerate-api.com/v6/7732fc0bc6c387a4f7c8eaa7/latest/USD";
	
	// getRate gets a JSON of all conversion rates from USD to ___ and returns the proper one based on country 
	// code provided.
	public static double getRate(String countryCode) {
		double rate = 1;
		
		try {
			URL url = new URL(API_URL);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject rateJSON = (JSONObject)jsonParser.parse(br);
			
			rate = (double)((JSONObject)rateJSON.get("conversion_rates")).get(countryCode);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rate;
	}
}
