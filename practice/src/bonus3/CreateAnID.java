package bonus3;

/* 
 * CS210 Bonus 3 (Create User ID)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.10 - Winter Quarter
 *
 * This program prompts the user to create a user ID, and checks for validity. 
 * 	A valid id is 
 * 					-exactly 4 chars in length
 * 					-starting with a letter
 * 					-contains a least one number
 * 
 */

import java.util.Scanner;

public class CreateAnID {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String userID = "";

		do {
			System.out.println("Please input your user ID:");
			userID = userInput.next();
			
		} while( !(contains4Characters(userID)  &&  startsWithLetter(userID)  &&  containsAtLeastOneNumber(userID)) );
		
		System.out.printf("%s has been created successfully", userID);
		
	}
	
	public static boolean contains4Characters(String userID) {
		if ( userID.length() == 4 ) {
			return true;
		} else {
			System.out.println("Your ID must be 4 characters in length!");
			return false;
		}
	}
	
	public static boolean startsWithLetter(String userID) {
		if ( Character.isLetter(userID.charAt(0)) ) { // check first letter to see if is a letter
			return true;
		} else {
			System.out.println("Your ID must start with a letter!");
			return false;
		}
	}
	
	public static boolean containsAtLeastOneNumber(String userID) {
		for(int i = 1; i < userID.length(); i++) {
			if ( Character.isDigit(userID.charAt(i)) ) { // check current chars to see if is a number
				return true;
			}
		}
		System.out.println("Please include at least one number in your ID!");
		return false;
	}
}
