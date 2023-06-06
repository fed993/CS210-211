package Assignment2InfixPostfix;

/*
 * CS211  (Class Practice 11: postfix evaluation)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.05.18 - Spring Quarter
 *
 *	This program takes a math expression, including (), +, -, *, and /, and evaluates it. 
 *
 *	This is split into three tasks, 
 *	1. checking if the expression is valid and all braces are closed, 
 *	2. converting the expression in its input state (infix) into the computer operable (postfix) state, 
 *	3. and evaluating the expression by operating on it.
 *
 *	These are all implemented with stacks.
 * 
 */

import java.util.*;

public class MyExpressionTest {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		String expression = "";
		
		while (true) { // ask for an expression, check if is valid.
			System.out.printf("\nEnter a math expression: ");
			expression = keyboard.nextLine();
			
			if (expression.length() == 0) { // if there is no input given and enter is pressed, program terminates.
				System.out.printf("\nBye!");
				break;
			} else {
				if (ExpressionEvaluation.checkValidity(expression)) {
					String postfix = InfixToPostfix.convert(expression);
					
					double result = PostfixEvaluation.evaluate(postfix);
					
					System.out.printf("Result: %f", result);
				}
			}// end if
		}// end while
	}// end main	
}// end class
