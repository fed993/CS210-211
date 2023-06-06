/* 
 * CS211 Assignment 1 (New Random Class)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.17 - Spring Quarter
 *
 *	This is a class to test the functionality of NewRandom.java
 *
 */

public class NewRandomTest {
	public static void main(String args[]) {
		NewRandom r = new NewRandom();
		
		System.out.println("\nTesting nextInt(int, int)");
		// choose 40 random numbers from 5 - 9 inclusive, print them
		for (int i = 0;i < 40; i++) {
			System.out.print(" "+r.nextInt(5, 9));
		}
		
		System.out.println("\nTesting nextChar()");
		// choose 40 random characters from the lowercase alphabet
		for (int i = 0;i < 40; i++) {
			System.out.print(" "+r.nextChar());
		}
		
		System.out.println("\nTesting nextChar(char small, char big)");
		//choose 40 random characters between c and x
		for (int i = 0;i < 40; i++) {
			System.out.print(" "+r.nextChar('c', 'x'));
		}
		
		System.out.println("\nTesting nextChar(char big, char small)");
		//choose 40 random characters between x and c
		for (int i = 0;i < 40; i++) {
			System.out.print(" "+r.nextChar('x', 'c'));
		}
		
		System.out.println("\nTesting nextCharExcept(char c)");
		//choose 40 random characters excluding c
		for (int i = 0;i < 40; i++) {
			System.out.print(" "+r.nextCharExcept('c'));
		}
	}
}
