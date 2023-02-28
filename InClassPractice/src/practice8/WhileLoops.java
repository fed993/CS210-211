package practice8;

import java.util.Scanner;

/* 
 * CS210 Practice 8 (While Loops)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.30 - Winter Quarter
 *
 * This is a short program to demonstrate how while loops work, and how we can keep prompting the user for input
 * 	until the input is something that we want.
 * 
 */

//import java.util.Scanner;

public class WhileLoops {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in); // initialize variables, note ints are declared here 
		boolean numbersAreValid = false;        // to avoid re-declaring every time the loop runs, to save runtime
		int num1;
		int num2;
		int num3;
		
		while (!numbersAreValid) { // until the numbers are valid, run the loop!
			System.out.println("input first number:"); // collect inputs from user
			num1 = input.nextInt();
			System.out.println("input second number:");
			num2 = input.nextInt();
			System.out.println("input third number:");
			num3 = input.nextInt(); 
			
			if ((num1 != num2) && ((num1 + num2) < num3 )) { // check for validity
				System.out.println("you are a genius! Bye!");
				numbersAreValid = true; // set flag to escape loop
			} else {
				System.out.println("input again!\n"); // otherwise prompt user and run again!
			}
		}
		input.close(); // close scanner
	}
}
