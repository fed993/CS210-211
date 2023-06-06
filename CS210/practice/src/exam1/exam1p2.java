package exam1;

/* 
 * CS210 Exam 1 P2 (Create User ID)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.14 - Winter Quarter
 *
 * This program prompts the user to create a user ID, and checks for validity. 
 * 	A valid id is 
 * 					-between 4 and 7 chars in length
 * 					-starting with a letter
 * 					-contains a least one number
 * 					-first and last char must be identical
 * 
 */

import java.util.Scanner;

public class exam1p2 {
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		String userID = "";

		do {// prompt user for an ID
			System.out.println("Please input your user ID:");
			userID = userInput.next();
			
		} while( !(contains4Characters(userID)  &&  startsWithLetter(userID)  &&  containsAtLeastOneNumber(userID) && firstAndLastMatch(userID))  );
		//^Check to see if the userID meets the criteria above, if not, loop and ask the user to create a new one!
		// each method prints its own error message to give the user more definite feedback.
		
		System.out.printf("%s has been created successfully", userID);
		
	}
	
	//these methods below check for validity, note that I'm using if statements
	//	to allow me to give an error message specific to the criteria checked
	//	in the same method as the checking.
	
	public static boolean contains4Characters(String userID) {
		if ( (userID.length() >= 4) && (userID.length() <= 7) ) { // check length between 4 and 7, inclusively
			return true;
		} else {
			System.out.printf("Your ID must be 4 to 7 characters in length, %s is invalid!\n", userID);
			return false;
		}
	}
	
	public static boolean startsWithLetter(String userID) {
		if ( Character.isLetter(userID.charAt(0)) ) { // check first letter to see if is a letter
			return true;
		} else {
			System.out.printf("Your ID must start with a letter, %s is invalid!\n", userID);
			return false;
		}
	}
	
	public static boolean containsAtLeastOneNumber(String userID) {
		for(int i = 1; i < userID.length(); i++) { // loop through each char in the string, ignoring the first since it must be a letter.
			if ( Character.isDigit(userID.charAt(i)) ) { // check current chars to see if is a number
				return true; // if any one of the chars is a number, exit the loop and return true
			}
		}
		System.out.printf("Please include at least one number in your ID, %s is invalid!\n", userID); 
		return false; // this is reached if the loop didn't find any characters
	}
	
	public static boolean firstAndLastMatch(String userID) {
		if (userID.charAt(0) == userID.charAt(userID.length()-1)) { // check to see if the first char (0) and the last char (len - 1) are the same
			return true;
		} else {
			System.out.printf("The first and last character of your user ID must match, %s is invalid!\n", userID);
			return false;
		}
	}
}
