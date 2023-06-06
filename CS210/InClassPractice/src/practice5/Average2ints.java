package practice5;

/* 
 * CS210 InClassPractice 5 (Averaging Two Integers)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.20 - Winter Quarter
 *
 * This program takes two integers as input from the user, averages them, and displays
 *  the result back to the user
 */

import java.util.Scanner;

public class Average2ints {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // initialize scanner
		
		System.out.print("Please input the first number: "); // get first input from user
		int firstInt = input.nextInt();
		
		System.out.print("Please input the second number: "); // get second input from user
		int secondInt = input.nextInt();
		
		double average = average(firstInt, secondInt); // calculate and store average of inputs
		System.out.println("\nThe average is: " + average); //output average
		
		input.close(); // close scanner to prevent memory leaks?
	}
	
	public static double average(int first, int second) {
		double result = ((double) (first + second)) / 2; // cast result of sum as a double, so that the division gives you a double
		return result; // output answer
	}
}
