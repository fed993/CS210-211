package practice11;

/* 
 * CS210 Practice 11 (Do While Boolean Zen)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.01 - Winter Quarter
 *
 *	This program prompts the user for three numbers, and if the first is the same as the second, and then the first
 *		plus the second is less than the third, then the numbers provided are valid. Otherwise, the code will
 *		prompt the user for numbers again, until the user gives valid numbers
 * 
 */

import java.util.*;

public class DoWhile {
	
	static Scanner input =  new Scanner(System.in); // create scanner
	public static void main(String args[]) {
		int first; // declare variables
		int second;
		int third;
		
		do {
			System.out.println("input first number: "); // prompt user for three numbers
			first = input.nextInt();
			System.out.println("input second number: ");
			second = input.nextInt();
			System.out.println("input third number: ");
			third = input.nextInt();
			
			if (!checkNumbers(first, second, third)) { // berate the user if they chose bad numbers
				System.out.println("Input again");
			}
		} while (!checkNumbers(first, second, third));
		
		System.out.println("you are a genius, Bye!"); // congratulate the user if they chose good numbers
	}
	
	// this method compares the numbers given; if first is the same as second, and the two are smaller than the third, the numbers are good
	public static boolean checkNumbers(int first, int second, int third) {
		return ((first == second) && ((first + second) < third));
	}
}
 