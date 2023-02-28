package assignment_3;

/* 
 * CS210 Bonus 3 (Create User ID)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.10 - Winter Quarter
 *
 *
 *
 * 
 */

import java.io.*;
import java.util.*;


public class CreateAndCheckID {
	public static void main(String[] args) throws FileNotFoundException  {
		File file = new File("IDs.txt"); // init files
		
		Scanner fileReader = new Scanner(file); // init file scanner
		Scanner userInput = new Scanner(System.in); // init user input scanner
		
		String userID = "";
		ArrayList<String> userIDs = new ArrayList<String>();
		
		userIDs = readFile(fileReader, userIDs);
		
		userID = getUserID(userInput);
		
		userIDs.add(userID);
		System.out.printf("%s has been created successfully", userID);
		
		PrintStream out = new PrintStream(file); 
		writeFile(out, userIDs);
		
		
	}
	
	
	public static void writeFile(PrintStream out, ArrayList userIDs) {
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
		System.out.println("Please input your user ID:");
		return userInput.next();
	}
	
	public static boolean checkValidity(String userID) {
		boolean validityFlag = true;
		if (contains4Characters(userID)) {
			System.out.println("Must contain between 4 and 8 characters!");
			validityFlag = false;
		}
		if (startsWithLetter(userID)) {
			validityFlag = false;
		}
		if (containsAtLeastOneNumber(userID)){
			validityFlag = false;
		} 
		return validityFlag;
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
