/*
 * CS211  (Bonus: Burger)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.28 - Spring Quarter
 *
 * This abstract class describes a country where a burger franchise could be. All burgers have a base price of $3,
 * 	which is modified for each country based on their currency exchange rate. 
 * 	Each franchise will also have a temperature gauge at that location, local to that franchise.
 * 
 */

package BurgerBonus;

public abstract class Burger211 {
	private double price = 3.0;
	
	public double getPrice() {
		return this.price;
	}
	
	public abstract void menu(String city);
}
