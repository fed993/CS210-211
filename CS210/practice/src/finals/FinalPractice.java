/*
 * CS210  (Final Practice)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.03.23 - Winter Quarter
 *
 *This program prompts the user for a string, and checks three criteria:
 *		1. the string must have a length less than 9
 *		2. the string must have an equal number of uppercase and lowercase characters
 *		3. the first and last char of the string must be the same
 * 	When these criteria are met, the program exits after printing "bye!" 
 * 	Otherwise, it will continue asking the user to provide a string
 */

package finals;

import java.util.*;

public class FinalPractice {
	static final int FIRST_CHAR_INDEX = 0;
	static final int MAX_STRING_LENGTH = 9;
	
	public static void main(String args[]) {
		// init scanner and input string
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		
		//prompt user for input, check for validity. A valid string has:
		// length is less than MAX_STRING_LENGTH
		// of lowercase and uppercase characters
		// first char = second char
		do {
			System.out.print("input a string: ");
			input = keyboard.next();
		} while(!checkLengthLessThanMAX_STRING_LENGTH(input) 
				|| !checkNumberOfUpperAndLowerChars(input) 
				|| !checkFirstEqualsLast(input));
		
		// when successful, print bye!
		System.out.println("bye!");
	}
	
	//check if the first and last chars of string provided are the same. return true/false
	public static boolean checkFirstEqualsLast(String input) {
		// this is a local var since it is easier to read, and there is no way to access input's length  
		//  besides inside this method. Should I not use the constant naming convention?
		final int LAST_CHAR_INDEX = (input.length() - 1); 
		return input.charAt(FIRST_CHAR_INDEX) == input.charAt(LAST_CHAR_INDEX);
	}
	
	//check if the length of the provided string is less than the maximum. return true/false
	public static boolean checkLengthLessThanMAX_STRING_LENGTH(String input) {
		return (input.length() < MAX_STRING_LENGTH);
	}
	
	//check if the number of lowercase and uppercase letters is the same. return true/false
	public static boolean checkNumberOfUpperAndLowerChars(String input) {
		int numberOfLowercaseCharacters = 0;
		//iterate through string, increment sum for each uppercase char found
		for (int i = FIRST_CHAR_INDEX; i < input.length(); i++) {
			if (Character.isLowerCase(input.charAt(i))) {
				numberOfLowercaseCharacters++;
			}
		}
		
		int numberOfUppercaseCharacters = 0;
		//iterate through string, increment sum for each lowercase char found
		for (int i = FIRST_CHAR_INDEX; i < input.length(); i++) {
			if (Character.isUpperCase(input.charAt(i))) {
				numberOfUppercaseCharacters++;
			}
		}
		
		return numberOfLowercaseCharacters == numberOfUppercaseCharacters;
	}
}








//int[] A = {1,2,3};
//int[] B = Arrays.copyOf(A, 3);
//int[] C = B;
//C[0] = A[1];
//A[1] = C[2];
//B[2] = 4;
//System.out.println(Arrays.toString(A));
//System.out.println(Arrays.toString(B));
//System.out.println(Arrays.toString(C));

//double score  = 70.0;
//String grade;
//
//if (score >= 70) {
//	grade = "C";
//} else {
//	grade = "F";
//}
//

//int j = 0;
//int sum = 0;
//for (int i = 1; i <=3 ;i++ ) {
//	sum++;
//	j = sum;
//	System.out.println(sum);
//}
//System.out.println(j);

//String S = "abcdef";
//System.out.println(S.substring(S.length()-1));
