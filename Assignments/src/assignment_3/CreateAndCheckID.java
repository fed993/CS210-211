package assignment_3;

/* 
 * CS210 Bonus 3 (Create User ID)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.27 - Winter Quarter
 *
 *	This program is a 'rudimentary (and highly insecure) database for storage of user generated identites'. A File stores IDs already in use, it is read to the user, and 
 *		then the user is prompted to create a new ID. New IDs must follow 6 rules:
 *			1) Duplicate IDs should be disallowed, and the user IDs are case sensitive. 
 *			2) IDs must be between 4 and 8 characters in length.  
 *			3) IDs must have lower-case AND upper case. 
 *			4) IDs must start with a letter like [a-z A-Z] 
 *			5) IDs must have at least one number like [0-9] 
 *			6) IDs must have at least one special character.  
 *		If the rules from 1-6 are violated, an appropriate error message informing the user is displayed. Once a valid ID is created, the updated list of IDs is written back to the file. 
 *		Then, the updated file is read to the user.
 * 
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class CreateAndCheckID {
	public static ArrayList<String> id = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException  {
		final String ID_DATABASE_PATH = "IDs.txt"; // locate file path
		
		
		
		
		File file = new File(ID_DATABASE_PATH); // init files
		
		Scanner fileReader = new Scanner(file); // init file scanner
		
		
		
		
		Scanner userInput = new Scanner(System.in); // init user input scanner
		
		String userID = ""; // this will store the ID the user is creating
		ArrayList<String> userIDs = new ArrayList<String>(); // this will store the IDs already in use
		
		userIDs = readFile(fileReader, userIDs); // read the IDs already in use to memory
		
		// prompt user to create an ID, keep prompting until it is valid
		do {
			System.out.println();
			userID = getUserID(userInput);
		} while (!checkValidity(userID, userIDs));
		
		// if user id is valid, add to list of IDs. report success
		userIDs.add(userID);
		System.out.printf("%s has been created successfully", userID);

		// write the list of IDs to the file.
		PrintStream out = new PrintStream(file); 
		writeFile(out, userIDs);
		
		// show updated list of IDs now that a new one has been created
		System.out.println();
		System.out.println();
		System.out.println("List of IDs (" + userIDs.size() + ")");
		printUserIDsInFile();
	}
	
	public static void printUserIDsInFile() throws FileNotFoundException {
		final String ID_DATABASE_PATH = "IDs.txt"; // locate file path
		File file = new File(ID_DATABASE_PATH); // init files
		Scanner fileReader = new Scanner(file); // init file scanner
		
		while (fileReader.hasNext()) { // print contents of file
			System.out.println(fileReader.next());
		}
		
		fileReader.close();
	}
	
	public static void writeFile(PrintStream out, ArrayList<String> userIDs) {
		for (int i = 0; i < userIDs.size(); i++) {
			out.println(userIDs.get(i));
		}
	}
	

	public static ArrayList<String> readFile(Scanner fileReader, ArrayList<String> userIDs) {
		System.out.println("Current User IDs:");
		while (fileReader.hasNext()) {
			String temp = fileReader.next();
			System.out.println(temp);
			userIDs.add(temp);
		}
		
		return userIDs;
	}
	
	public static String getUserID(Scanner userInput) {
		System.out.print("Please create a new user ID: ");
		return userInput.next();
	}
	
	public static boolean checkValidity(String userID, ArrayList<String> userIDs) {
		boolean validityFlag = true;
		if (!contains4to8Characters(userID)) { // if greater than 8 or less than 4 in size, report error
			System.out.println("Must contain between 4 and 8 characters!");
			validityFlag = false;
		}
		if (!startsWithLetter(userID)) { // if doesn't start with letter, report error
			System.out.println("Your ID must start with a letter!");
			validityFlag = false;
		}
		if (!containsAtLeastOneNumber(userID)){ // if doesn't contain at least one number, report error
			System.out.println("Please include at least one number in your ID!");
			validityFlag = false;
		}
		if (!containsAtLeastOneSpecialCharacter(userID)){ // if doesn't contain at least one special char, report error
			System.out.println("Please include at least one special character in your ID!");
			validityFlag = false;
		}
		if (!containsUppercaseAndLowercase(userID)){ // if doesn't contain both upper and lower, report error
			System.out.println("Please include both upper and lower case characters in your ID!");
			validityFlag = false;
		}
		if (isDuplicate(userID, userIDs)) { // if is a duplicate ID, report error
			System.out.println(userID + " is already in use! Please create a unique ID!");
			validityFlag = false;
		}
		return validityFlag;
	}
	
	
	
	public static boolean contains4to8Characters(String userID) {
		final int MIN_ID_LENGTH = 4;
		final int MAX_ID_LENGTH = 8;
		return ( (userID.length() >= MIN_ID_LENGTH ) && (userID.length() <= MAX_ID_LENGTH) ); // return true if between 4-8 chars in length, inclusive.
	}
	
	public static boolean startsWithLetter(String userID) {
		final int FIRST_LETTER_INDEX = 0; // the index of the first letter is 0
		return Character.isLetter(userID.charAt(FIRST_LETTER_INDEX)); // check first letter to see if is a letter
		
	}
	
	public static boolean containsAtLeastOneSpecialCharacter(String userID) {
		final int INITIAL_CHECK_INDEX = 0; // start reading the string at the beginning!
		for(int i = INITIAL_CHECK_INDEX; i < userID.length(); i++) { 
			if ( !( Character.isLetterOrDigit(userID.charAt(i)) )  ) { // check current chars to see if it isn't a number or a letter (therefore is a special character)
				return true;
			}
		}
		return false;
	}
	
	public static boolean isDuplicate(String userID, ArrayList<String> userIDs) {
		for(String i : userIDs) { // this means to iterate through the list userIDs, where each iteration i becomes the next element in userIDs. 
			//Coming from python, I much prefer this method of for-looping :)
			if ( i.equals(userID) ) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean containsUppercaseAndLowercase(String userID) {
		final int INITIAL_CHECK_INDEX = 0; // start at 0 since we are reading the entire string to check for upper and lower case letters
		boolean upperCaseFlag = false;
		boolean lowerCaseFlag = false;
		for(int i = INITIAL_CHECK_INDEX; i < userID.length(); i++) {
			if ( Character.isUpperCase(userID.charAt(i)) ) { // check current chars to see if is uppercase
				upperCaseFlag = true;
			}
			if ( Character.isLowerCase(userID.charAt(i)) ) { // check current chars to see if is lowercase
				lowerCaseFlag = true;
			}
		}
		return (lowerCaseFlag && upperCaseFlag);
	}
	
	public static boolean containsAtLeastOneNumber(String userID) {
		final int INITIAL_CHECK_INDEX = 0; // start reading the string at the beginning!
		for(int i = INITIAL_CHECK_INDEX; i < userID.length(); i++) {
			if ( Character.isDigit(userID.charAt(i)) ) { // check current chars to see if is a number
				return true;
			}
		}
		return false;
	}
}
