package practice12;

/* 
 * CS210 Practice 12 (Midterm Exam Practice)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.01 - Winter Quarter
 *
 * This program prompts the user for three numbers, and if the first is the same as the second, and then the first
 *	plus the second is less than the third, then the numbers provided are valid. Otherwise, the code will
 *	prompt the user for numbers again, until the user gives valid numbers
 * 
 */



import java.util.Random;
import java.util.Scanner;

public class MidtermExamPractice {
	
	

	final static int CONSTANT_ERROR = -100; // this is used when the operation supplied by user is not allowed
	
	public static void main(String args[]) {
		
		if (Character.isLetter('f')) {
			System.out.print("It's a letter!!!");
		} else {
			System.out.print("ITS NOT A LETTER!!!!!!!!!!");
		}
		
		Scanner input = new Scanner(System.in);
		while (true) {
			Random rand = new Random();
			
			int firstBound = 0;
			int secondBound = 0;
			
			do {
				System.out.println("input first number: "); // prompt user for three numbers
				firstBound = input.nextInt();
				System.out.println("input second number: ");
				secondBound = input.nextInt();
				
				if (!checkNumbers(firstBound, secondBound)) { // berate the user if they chose bad numbers
					System.out.println("Input again");
				}
			} while (!checkNumbers(firstBound, secondBound));
			
			String operation = getOperation(input);
			
			int num1 = generateRandomInt(rand, firstBound, secondBound);
			int num2 = generateRandomInt(rand, firstBound, secondBound);
			
			int correctAnswer = calculateCorrectAnswer(operation, num1, num2);
			
			if (correctAnswer == CONSTANT_ERROR) { // should never get here
				continue; // skip testing the user since they gave you an invalid input and the code didn't catch it
			}
			
			testTheUser(operation, num1, num2, correctAnswer, input);
		}
	}
	
	public static boolean checkNumbers(int num1, int num2) {
		return !((num1 <= 0) || (num2 - num1 < 10));
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
	
	// this method generates a random number between the bounds given
	public static int generateRandomInt(Random rand, int firstBound, int secondBound) {
		int range = (Math.max(firstBound, secondBound) - Math.min(firstBound, secondBound)) + 1; // range will be the max of the two nums minus the min of the two nums
		int offset = Math.min(firstBound, secondBound); // offset is the same as the min, added to the random function to shift from 1-range to min-max
		return rand.nextInt(range) + offset; // generate and return random number
	}
	
	// this method takes the given operation and randomly generated numbers, and finds the correct answer to check against. 
	//  it will default to integer addition if the operation is submitted invalidly.
	public static int calculateCorrectAnswer(String operation, int num1, int num2) {
		if (operation.equals("+")) { 
			return num1 + num2;
		} else if (operation.equals("-")) {
			return num1 - num2;
		} else {
			return CONSTANT_ERROR;
		}
	}
	
	// this method makes sure the user supplied a valid operation, either +, -, /, or *
	public static boolean checkUserInput(String operation) {
		if (operation.equals("+") || operation.equals("-")) {
			return true;
		} else {
			System.out.println("You must input one of the following:  \"+\" or \"-\"");
			return false;
		}
	}
	
	// this method asks the user to supply an operation, either +, -, /, or * 
	public static String promptUserForOperation(Scanner scanner) {
		System.out.println("Please give me an operation to perform! Acceptable operations are \"+\" or \"-\"");
		String operation = scanner.next();
		
		return operation;
	}
	
	// this method handles the higher level logic for g››etting the operation from the user
	public static String getOperation(Scanner scanner) {
		String operation = promptUserForOperation(scanner); //  get operation from user
		
		while (!checkUserInput(operation)) { // make sure the user gave you a valid operation, if not, try again
			operation = promptUserForOperation(scanner);
		}
		
		return operation; // return the operation once it is valid
	}
}
