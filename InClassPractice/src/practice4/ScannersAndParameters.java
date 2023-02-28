package practice4;

import java.util.*;
/* 
 * CS210 InClassPractice 4 (Scanners and Parameters)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.18 - Winter Quarter
 *
 * This program prompts user for a symbol and number of times to draw a symbol, 
 * 	and then draws that symbol that many times
 */

public class ScannersAndParameters {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // creates Scanner object to handle user inputs
		
		System.out.print("Input a symbol: "); // prompt user for symbol, note symbol may be multiple characters, in which case they will all be printed on a line, for /quantity/ lines
		String symbol = input.next();
		
		System.out.print("How many " + symbol + " would you like to draw?"); // prompts user for a quantity of lines to print, each line can be any number of characters
		int quantity = input.nextInt();
		
		System.out.println(); // this spaces the symbols away from the prompts by a line, for readability
		printSymbols(symbol, quantity); // prints the symbol String quantity times 
		
		input.close();
	}
	
	public static void printSymbols(String symbol, int quantity) { // printSymbols takes a String and an int, prints that String on separate lines (int) times.
		for (int i = 1; i <= quantity; i++) { // loop runs quantity times
			System.out.println(symbol); // each run of loop will print a line of symbol
		}
	}
}
