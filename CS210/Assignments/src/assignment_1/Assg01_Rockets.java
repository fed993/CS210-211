package assignment_1;

/* 
 * CS210 Assignment 01 (Methods - Sequence)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.10 - Winter Quarter
 *
 * This program creates some art of two rockets
 */

public class Assg01_Rockets {
	public static void main(String[] args) {
		printTop();
		printSegment();
		printMiddle();
		printSegment();
		printBottom();
	}
	
	static void printStageSeparator() { //prints stage separators!
		System.out.println("+-------+ +-------+");
	}
	
	static void printTop() { //prints top section of the art!
		System.out.println("   /|\\     \\  |  /");
		System.out.println("  / | \\     \\ | / ");
		System.out.println(" /  |  \\     \\|/  ");
		printStageSeparator();
	}
	
	static void printSegment() { // prints each segement of rocket
		System.out.println("|       | |       |");
		System.out.println("|       | |       |");
		printStageSeparator();
	}
	
	static void printMiddle() { // prints middle two numbers!
		System.out.println("|  969  | |  696  |");
		printStageSeparator();
	}
	
	static void printBottom() { // although bottom is same as top, this is separated into another method for readability.
		System.out.println("   /|\\     \\  |  /");
		System.out.println("  / | \\     \\ | / ");
		System.out.println(" /  |  \\     \\|/  ");
	}
}
