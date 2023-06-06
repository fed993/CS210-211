package Assignment2InfixPostfix;

import java.util.*;

public class PostfixEvaluation {
	static Stack<Integer> parsingStack = new Stack<Integer>(); // retains most recent result after evauation
															   // this could be used to implement ANS 
															   // (most recent answer, as a var)
	
	
	/* 
	 * read through postfix, 
	 * 	if operand then push operand integer value to stack,
	 * 	if operator, pop two off the stack and operate the second onto the first, 
	 * 		push result of operator to the stack   
	 * 
	 * return stack value once postfix is read
	 */
	public static double evaluate(String postfix) {
		for (int i = 0; i < postfix.length(); i++) {
			if (isOperand(postfix.charAt(i))){
				parsingStack.push(Integer.parseInt(postfix.substring(i,i+1)));
			} else if (isOperator(postfix.charAt(i))) {
				parsingStack = handleOperations(parsingStack, postfix.charAt(i));
			}
		}
		return parsingStack.pop();
	}
	
	// pop two off the stack, operate second on first based on operator, push result to stack
	private static Stack<Integer> handleOperations(Stack<Integer> parsingStack, char operator) {
		int first = parsingStack.pop();
		int second = parsingStack.pop();
		
		if (operator == '+') {
			parsingStack.push((second + first));
		} else if (operator == '-') {
			parsingStack.push((second - first));
		} else if (operator == '*') {
			parsingStack.push((second * first));
		} else if (operator == '/') {
			parsingStack.push((second / first));
		} 
		
		return parsingStack;
	}
	
//	private static double parseInts() {
//		double value = 0;
//		while(Character.isDigit(c)) {
//			value = value * 10 * Integer.parseInt(postfix.substring(i,i+1))
//		}
//	}
	
	// returns true if c is an operand
	private static boolean isOperand(char c) {
		return Character.isDigit(c);
	}
	
	// returns true if c is +, -, *, or /
	private static boolean isOperator(char c) {
		if (c == '+') {
			return true;
		} else if (c == '-') {
			return true;
		} else if (c == '*') {
			return true;
		} else if (c == '/') {
			return true;
		} else {
			return false;
		}
	}
}
