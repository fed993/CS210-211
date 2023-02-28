package booleanZen;

/* 
 * CS210 Bonus 2 (Boolean Zen)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.02 - Winter Quarter
 *
 * This program asks the user for two ints, and if they are the same, it terminates. Otherwise, it will keep asking
 * 	the user for ints until the two supplied are the same
 * 
 */

import java.util.Scanner;

public class BooleanZen {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // create scanner
		int int1 = 0; 
		int int2 = 1;
		
		while(!intsAreEqual(int1, int2)) { // keep asking for inputs until they are the same
			int1 = getIntFromUser(scanner); // prompt user for input
			System.out.println("Another please!");
			int2 = getIntFromUser(scanner);
		}
		
		System.out.println("you are a genius! Bye!"); // congratulate the user for correct answer
		scanner.close(); // close scanner
	}
	
	
	public static boolean intsAreEqual(int num1, int num2) {
		return (num1 == num2);
	}
	
	public static int getIntFromUser(Scanner scanner) {
		System.out.println("Please input an int:");
		return scanner.nextInt();
	}
}
