/*
 * CS211  (Bonus: Burger)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.28 - Spring Quarter
 *
 * This class polls weather API for current weather in city provided, and returns the average air temperature
 * 	in that city, in Kelvin.
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

public class Weather {
	
	// gets temperature of the city passed in as a parameter, in Kelvin. 
	// Convert to local temperature in your implementation of the country class!!!
	public static double getTemp(String city) {
		double temp = 1.0;
		String API_URL = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=2ca06e115bb3ab170b3748394807231f";
		
		try {
			URL url = new URL(API_URL);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject rateJSON = (JSONObject)jsonParser.parse(br);
			
			temp = (double)((JSONObject)rateJSON.get("main")).get("temp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return temp;
	}
}
