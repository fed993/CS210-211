package practice5;

import java.util.Scanner;

/* 
 * CS210 InClassPractice 5 (Sum of All Ints Between Two Numbers)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.20 - Winter Quarter
 *
 * This program takes as input two integers, and finds the sum of all integers between the two, 
 *  including the two inputs. For example, 
 *  input a = 5
 *  input b = 10
 *  output c = 5 + 6 + 7 + 8 + 9 + 10
 */

public class SumNumbersInBetween {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // initialize scanner
		
		System.out.print("Please input the first number: "); // get first input from user
		int firstInt = input.nextInt();
		
		System.out.print("Please input the second number: "); // get second input from user
		int secondInt = input.nextInt();
		
		int sum = sumBetween(firstInt, secondInt); // calculate sum
		System.out.println("\nThe total in between those two numbers is: " + sum); // output sum to user
		
		input.close(); // close Scanner to prevent memory leaks?
	}
	
	public static int sumBetween(int first, int second) {
		int runningTotal = 0; // create running total to keep track of the sum
		for (int i = first; i <= second; i++) { // loop will start at the first number, and sum current number to running total, until it reaches second number, including second
			runningTotal += i;
		}
		return runningTotal; // output the sum
	}
}
