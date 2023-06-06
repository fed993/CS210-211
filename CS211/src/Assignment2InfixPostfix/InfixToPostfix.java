package Assignment2InfixPostfix;

/*
 * CS211  (infix to postfix)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.05.23 - Spring Quarter
 *
 *	This program takes a math expression, including (), +, -, *, and /, and converts it to a postfix 
 *
 *	For example, "1+2"  would be converted to "12+"
 *
 *	This is split into five steps in a loop over all characters:
 *	1.	if token is 
 *	2.  
 *	3. 	
 *	4. 	
 *	5.	
 *
 *	These are all implemented with stacks.
 * 
 */

import java.util.*;

public class InfixToPostfix {
	private static HashMap<Character, Integer> precedence = new HashMap<Character, Integer>();
	
	public static String convert(String expression) {
		String postfix = "";
		
		loadPrecedence();
		
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			
			if (Character.isDigit(c) && (i+1) <= expression.length() && Character.isDigit(expression.charAt(i+1))) {
				postfix = postfix + String.valueOf(c);
			}
		}
		
		
		System.out.println("WE ALLL GOOOOOOOOOOOOOOOOD");
		return postfix;
	}
	
	private static void loadPrecedence() {
		precedence.put('(', 0);
		precedence.put(')', 0);
		precedence.put('+', 1);
		precedence.put('-', 1);
		precedence.put('*', 2);
		precedence.put('/', 2);
	}
}
