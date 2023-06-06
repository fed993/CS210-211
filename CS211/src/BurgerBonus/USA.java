/*
 * CS211  (Bonus: Burger)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.28 - Spring Quarter
 *
 * This class extends the abstract class Burger211, describing franchises in the USA. The currency is set to USD, 
 *  and users can pass a city name to the constructor to build a franchise in that city.
 *  Temperature is converted to fareheit since that is the standard in the US.
 * 	The menu() method displays the price of burgers and any promotions currently offered.
 * 
 */

package BurgerBonus;

public class USA extends Burger211 {
	
	double discountTemp = 72.0;
	double discountRate = 0.28;
	double exchangeRate = 0;
	double temp = 0;
	
	// get exchange rate from API, get weather from API, calculate proper temperature conversion, print the menu
	USA(String city) {
		exchangeRate = ExchangeRate.getRate("USD");
		temp = Weather.getTemp(city);
		temp = ((temp - 273.15) * 9/5 + 32);
		menu(city);
	}
	
	// menu() prints the menu out to the user. This includes price, exchange rate, temperature, and any promotions
	// currently offered.	
	public void menu(String city) {
		System.out.printf("USA (%s)\n", city);
		System.out.printf("Exchange Rate: %f\n", (exchangeRate));
		System.out.printf("Temperature: %f\u00b0\n", (temp));
		if (temp == discountTemp) {
			System.out.printf("Burger Price: %f (was %f) - Weather Promotion: Exactly 72\u00b0 72% off! \n",
					(getPrice() * exchangeRate * discountRate), (getPrice() * exchangeRate));
		} else {
			System.out.printf("Burger Price: %f\n", (getPrice() * exchangeRate));
		}
	}
	
}
