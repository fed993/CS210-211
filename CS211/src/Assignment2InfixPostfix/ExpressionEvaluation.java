package Assignment2InfixPostfix;

/*
 * CS211  (Class Practice 11: postfix evaluation)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.05.18 - Spring Quarter
 *
 *	This class takes a math expression, and checks it for validity.  
 *
 *	A valid expression contains only numbers, parentheses, brackets, and operators.
 *	All parentheses and brackets must be matched. 
 */

import java.util.Stack;

public class ExpressionEvaluation {
	static Stack<Character> brackets = new Stack<Character>();
	
	public static boolean checkValidity(String infix) {
		for(int i = 0; i < infix.length(); i++) {
			if ((infix.charAt(i) == '{') || (infix.charAt(i) == '(')) {
				brackets.push(infix.charAt(i));
			} else if ((infix.charAt(i) == '}') || (infix.charAt(i) == ')')) {
				if (infix.charAt(i) == brackets.peek()) {
					brackets.pop();
				} else {
					if (brackets.pop() == '{') {
						System.out.println("Invalid expression, { expected");
						return false;
					} else if (brackets.pop() == '(') {
						System.out.println("Invalid expression, ( expected");
						return false;
					}
				}
			}
		}
		if (brackets.peek() == '(' || brackets.peek() == '{') {
			if (brackets.pop() == '{') {
				System.out.println("Invalid expression, { unmatched");
				return false;
			} else if (brackets.pop() == '(') {
				System.out.println("Invalid expression, ( unmatched");
				return false;
			}
		}
		
		return true;
	}
}
