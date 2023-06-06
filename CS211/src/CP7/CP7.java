package CP7;
/*
 * CS211  (Class Practice 6: Big Data practice)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.27 - Spring Quarter
 *
 *	This program pulls all the earthquakes in the last hour reported by the USGS Earthquake API
 *	and displays the total, where they were located, their magnitude, and whether or not they caused a Tsunami.
 * 
 */


import java.io.*;
import java.net.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class CP7 {
	private static String API_URL ="https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";
	
	public static void main(String args[]) {
		
		try {
			URL url = new URL(API_URL);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			JSONParser jsonParser = new JSONParser();
			
			JSONObject earthquakesJSON = (JSONObject)jsonParser.parse(br);
			
			printEarthquakes(earthquakesJSON);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// this method reads the JSON containing the earthquake data and prints out the total number, and then
	// lists each earthquake with its location, magnitude, and whether or not they caused a tsunami
	private static void printEarthquakes(JSONObject geoJSON) {
		// run countEarthquakes to get the number of earthquakes, print it
		System.out.println("Total EQ: " + countEarthquakes(geoJSON));
		
		// get Array from Features, which contains an array whose elements are each one earthquake report
		JSONArray geoArray= (JSONArray)(geoJSON.get("features")); 
		
		// for each earthquake, save the place, magnitude, and tsunami. print these items.
		for (int i = 0; i < geoArray.size(); i++) {
			String place = (String) ((JSONObject) ((JSONObject) geoArray.get(i)).get("properties")).get("place");
			String magnitude = Double.toString( (Double)((JSONObject) ((JSONObject) geoArray.get(i)).get("properties")).get("mag"));
			String tsunami = Long.toString( (Long)((JSONObject) ((JSONObject) geoArray.get(i)).get("properties")).get("tsunami"));
			
			System.out.printf((i + 1) + ". %34s. Magnitude: %5s. Tsunami: %b\n", place, magnitude, tsunami.equals(0));
		}
	}
	
	// gets the value under the "count" key found in the JSON's metadata.
	private static long countEarthquakes(JSONObject geoJSON) {
		return (long)(((JSONObject)geoJSON.get("metadata")).get("count"));
	}
}
