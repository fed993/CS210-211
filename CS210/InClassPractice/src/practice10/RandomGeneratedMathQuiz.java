package practice10;

/* 
 * CS210 Practice 10 (Random Generated Math Quiz)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.01 - Winter Quarter
 *
 * This program generates two numbers, and asks the user to choose an operator between +, -, *, and /
 *  then it displays a formula (eg 6 * 7 = ?) and asks the user for the correct answer. If the user answers
 *  correctly, then it will exit the program, but otherwise it will keep asking for the answer to the same 
 *  math problem. 
 * 
 */

import java.util.Scanner;
import java.util.Random;

public class RandomGeneratedMathQuiz {
	
	final static int CONSTANT_ERROR = -100; // this is used when the operation supplied by user is not allowed
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		while (true) {
			Random rand = new Random();
			
			String operation = getUserInput(input);
			int num1 = generateRandomInt(rand);
			int num2 = generateRandomInt(rand);
			
			int correctAnswer = calculateCorrectAnswer(operation, num1, num2);
			
			if (correctAnswer == CONSTANT_ERROR) { // should never get here
				continue; // skip testing the user since they gave you an invalid input and the code didn't catch it
			}
			
			testTheUser(operation, num1, num2, correctAnswer, input);
		}
		
	}
	
	// this method displays the test to the user and prompts for the answer until the user answers correctly
	public static void testTheUser(String operation, int num1, int num2, int correctAnswer, Scanner scanner) {
		System.out.printf("%d %s %d = ?\n", num1, operation, num2); // prints the math question!
		int userAnswer = scanner.nextInt(); // gets user's answer
		
		while (userAnswer != correctAnswer) {
			System.out.println("wrong answer!"); // berate the user for being a dummy
			System.out.printf("\n%d %s %d = ?\n", num1, operation, num2); // prints the math question!
			userAnswer =  scanner.nextInt(); // gets user's answer
		}
		
		System.out.printf("You are a math genius! Bye."); // applaud the user for getting the right answer
	}
	
	// this method generates a random number from 2 to 10, inclusive.
	public static int generateRandomInt(Random rand) {
		return rand.nextInt(9) + 2;
	}
	
	// this method takes the given operation and randomly generated numbers, and finds the correct answer to check against. 
	//  it will default to integer addition if the operation is submitted invalidly.
	public static int calculateCorrectAnswer(String operation, int num1, int num2) {
		if (operation.equals("/")) { 
			return num1 / num2;
		} else if (operation.equals("-")) {
			return num1 - num2;
		} else if (operation.equals("*")) {
			return num1 * num2;
		} else if (operation.equals("+")) {
			return num1 + num2;
		} else {
			return CONSTANT_ERROR;
		}
	}
	
	// this method makes sure the user supplied a valid operation, either +, -, /, or *
	public static boolean checkUserInput(String operation) {
		if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/")) {
			return true;
		} else {
			System.out.println("You must input one of the following:  \"+\", \"-\", \"*\", \"/\"");
			return false;
		}
	}
	
	// this method asks the user to supply an operation, either +, -, /, or * 
	public static String promptUserForOperation(Scanner scanner) {
		System.out.println("Please give me an operation to perform! Acceptable operations are: \"+\", \"-\", \"*\", \"/\"");
		String operation = scanner.next();
		
		return operation;
	}
	
	// this method handles the higher level logic for getting the operation from the user
	public static String getUserInput(Scanner scanner) {
		String operation = promptUserForOperation(scanner); //  get operation from user
		
		while (!checkUserInput(operation)) { // make sure the user gave you a valid operation, if not, try again
			operation = promptUserForOperation(scanner);
		}
		
		return operation; // return the operation once it is valid
	}
}
