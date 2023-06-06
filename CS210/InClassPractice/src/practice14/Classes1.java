package practice14;

/* 
 * CS210 Practice 14 (Classes 1)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.23 - Winter Quarter
 *
 * This program prompts the user for a shape, between a triangle or a circle,
 * 	and then asks the user for the shape's dimensions. It creates an instance
 * 	of the area calculating class, and then calculates the area using the instance
 * 	and displays the shape name and its area
 * 
 */

import java.util.*;

public class Classes1 {
	static final double CONST_ERROR = -999999999;
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); // init scanner
		
		String shape; // init vars for storing shape information
		double area;
		
		do { // loop to prompt user for the shape
			System.out.println("Would you like the area of a triangle or a circle?");
			System.out.println("Please specify \"triangle\" or \"circle\" below:");
			shape = keyboard.next();
		} while ( !(shape.equals("triangle") || shape.equals("circle")) );
		
		area = calculateArea(shape, keyboard);
		printToUser(shape, area);
	}
	public static double calculateArea(String shape, Scanner keyboard) {
		AreaCalculator areaCalculator = new AreaCalculator();
		if (shape.equals("triangle")) {
			double base = promptForBase(keyboard);
			double height = promptForHeight(keyboard);
			
			return areaCalculator.calculateTriangleArea(base, height);
		} else if (shape.equals("circle")) {
			double radius = promptForRadius(keyboard);
			
			return areaCalculator.calculateCircleArea(radius);
		} else {
			// this should be unreachable, here be dragons!
			return CONST_ERROR;
		}
	}
	
	//
	public static double promptForBase(Scanner keyboard) {
		System.out.println("Please input the base of the triangle: ");
		return keyboard.nextDouble();
	}
	
	//
	public static double promptForHeight(Scanner keyboard) {
		System.out.println("Please input the height of the triangle: ");
		return keyboard.nextDouble();
	}
	
	//
	public static double promptForRadius(Scanner keyboard) {
		System.out.println("Please input the radius of the circle: ");
		return keyboard.nextDouble();
	}
	
	public static void printToUser(String shape, double area) {
		System.out.println(shape + " area: " + area);
	}
}
