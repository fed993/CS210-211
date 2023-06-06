/* 
 * CS211 Assignment 1 (New Random Class)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.17 - Spring Quarter
 *
 *	This is an extention of the java Random class, including 4 custom made methods:
 *	1. nextInt(int min, int max)
 *		this method takes two parameters, a maximum and a minimum, and returns either the max, min, or a rando number in between them
 * 	2. nextChar()
 * 		this method returns a random char found in the lowercase english alphabet
 * 	3. nextChar(char min, char max)
 * 		this method returns a random char between the two chars specified. If the larger one is first, then it will search to the end of 
 * 		the alphabet and start again at the beginning until it hits the min char.
 * 	4. nextCharExcept(char exclude)
 * 		this method takes a char, and returns a random char, where the char given is not included in the random choice.
 */

import java.util.*;

public class NewRandom extends Random {
	private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	public int nextInt(int min, int max) {
		return nextInt(max-min+1) + min; 	//the +1 is here to include both the min AND the max.
											//otherwise, min would be included and max would not.
	}
	
	public char nextChar() {
		return ALPHABET.charAt(nextInt(0,ALPHABET.length()-1)); 	
			//choose one of the 26 indicies of the ALPHABET string above.
			//return the char found there
		
	}
	
	public char nextChar(char first, char second) {
		if (Character.compare(first, second) < 0) {
			String newAlphabetString = ALPHABET.substring(ALPHABET.indexOf(first), ALPHABET.indexOf(second) +1);
//			System.out.println(newAlphabetString);
				//create alphabet string starting at first and stopping at second (+1 to include second)
			return newAlphabetString.charAt(nextInt(0, newAlphabetString.length()-1));
				//return a random char from within this substring, +1 to include end
		} else if (Character.compare(first, second) > 0) { // compare returns >0 when first is > second
			String newAlphabetString = ALPHABET.substring(ALPHABET.indexOf(first)) 
				//create new alphabet string that starts at the char closer to end of alphabet (first, in this case)
					+ ALPHABET.substring(0, ALPHABET.indexOf(second));
				//wrap around alphabet through start until second char, +1 to include second
			
			return newAlphabetString.charAt(nextInt(0, newAlphabetString.length() - 1));
				//similar to above, choose one of the the indicies of the newAlphabetString string
				//return the char found there
		} else {
			return first;
		}
	}
	
	public char nextCharExcept(char exclusion) {
		return nextChar(ALPHABET.charAt(ALPHABET.indexOf(exclusion) + 1), ALPHABET.charAt(ALPHABET.indexOf(exclusion)));
		// run nextChar with (excluded char + 1) and (excluded char - 1) as parameters, to get a random char
		// excluding the excluded char
		
		//for example, if exclusion == 'g', we'd run nextChar('h', 'f')
	}
	
}
