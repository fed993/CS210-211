package practice9;

/* 
 * CS210 Practice 9 (Random Numbers)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.31 - Winter Quarter
 *
 * This is a short program to allow the user to receive a random number between two bounds chosen
 * 
 */

import java.util.*;

public class RandomNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // initialize variables
		Random rand = new Random();
		int num1 = 0;
		int num2 = 0;

		do { // gather inputs from user
		System.out.println("Please input an integer: ");
		num1 = getIntFromUser(input);
		System.out.println("Please input another integer: ");
		num2 = getIntFromUser(input);
		} while (checkIfIntsAreSame(num1, num2)); // check if the inputs given are the same, if not, exit loop
		
		int range = (Math.max(num1, num2) - Math.min(num1, num2)) + 1; // range will be the max of the two nums minus the min of the two nums
		int offset = Math.min(num1, num2); // offset is the same as the min, added to the random function to shift from 1-range to min-max
		int randomNumber = rand.nextInt(range) + offset; // generate random number
		
		System.out.printf("Your randomly generated number between the bounds specified is: %d", randomNumber); // output to user
		
		input.close(); // close scanner
	}
	
	public static int getIntFromUser(Scanner scanner) {
		int num = scanner.nextInt(); // ask user for an initial value
		
		while(!checkInputValidity(num)) { // check if number given is between 0 and 99 inclusive, 
			System.out.println("Please input an integer: "); //if not, keep asking user for an input
			num = scanner.nextInt();
		}
		
		return num;
	}
	
	public static boolean checkInputValidity(int num) {
		if (num < 0) { // if number too small, prompt user and return false, since not valid
			System.out.println("Must be >= 0. Input again");
			return false;
		} else if (num > 99) { // if number too big, prompt user and return false, since not valid
			System.out.println("Must be <= 99. Input again");
			return false;
		} else {
			return true; // otherwise number must be valid!
		}
	}
	
	public static boolean checkIfIntsAreSame(int num1, int num2) {
		if (num1 ==  num2) { // if the two inputs are the same, prompt user and return false. else return true
			System.out.println("Can't be the same. Input again");
		}
		return (num1 == num2);
	}
}
