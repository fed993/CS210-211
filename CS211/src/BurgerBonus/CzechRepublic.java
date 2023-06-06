/*
 * CS211  (Bonus: Burger)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.28 - Spring Quarter
 *
 * This class extends the abstract class Burger211, describing franchises in the czech republic. The currency is set to CZK, 
 *  and users can pass a city name to the constructor to build a franchise in that city.
 *  Temperature is converted to Celsius since that is the standard in the czech republic.
 * 	The menu() method displays the price of burgers and any promotions currently offered.
 * 
 */

package BurgerBonus;

public class CzechRepublic extends Burger211 {
	
	double discountTemp = 0;
	double discountRate = 0.80;
	double exchangeRate = 0;
	double temp = 0;
	
	// get exchange rate from API, get weather from API, calculate proper temperature conversion, print the menu
	CzechRepublic(String city) {
		exchangeRate = ExchangeRate.getRate("CZK");
		temp = Weather.getTemp(city);
		temp = (temp - 273.15);
		menu(city);
	}
	
	// menu() prints the menu out to the user. This includes price, exchange rate, temperature, and any promotions
	// currently offered.
	public void menu(String city) {
		System.out.printf("Czech Republic (%s)\n", city);
		System.out.printf("Exchange Rate: %f\n", (exchangeRate));
		System.out.printf("Temperature: %f\u00b0\n", (temp));
		if (temp <= discountTemp) {
			System.out.printf("Burger Price: %f (was %f) - Weather Promotion: Below Freezing! Get a burger and warm up! \n",
					(getPrice() * exchangeRate * discountRate), (getPrice() * exchangeRate));
		} else {
			System.out.printf("Burger Price: %f\n", (getPrice() * exchangeRate));
		}
	}
	
}
