package practice6;

/* 
 * CS210 InClassPractice 6 (If Statements)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.24 - Winter Quarter
 *
 * This program prompts the user for a width and height of a rectangle, and a radius of a circle, 
 * 	then calculate the area of the rectangle and area of the circle, and show which area is larger
 * 	as well as by what factor
 * 
 */

import java.util.Scanner;

public class IfStatements {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // initialize scanner
		
		System.out.print("Input rectangle width: "); // prompt user for rectangle width
		double rWidth = input.nextDouble();
		System.out.print("Input rectangle height: "); // prompt user for rectangle height
		double rHeight = input.nextDouble();
		
		System.out.print("Input circle radius: "); // prompt user for circle radius
		double cRadius = input.nextDouble();
		
		double rArea = calculateRectangleArea(rWidth, rHeight); // calculate rectangle area
		
		double cArea = calculateCircleArea(cRadius); // calculate circle area
		
		System.out.println();
		System.out.println("Rectangle area: " + rArea); // display calculated areas to user
		System.out.println("Circle area: " + cArea);
		System.out.println();
		
		if (rArea == cArea) { // areas are same, display that to user!
			System.out.println("The rectangle and the circle have the same area!");
		} else if (rArea > cArea) { // rectangle is bigger, display how much bigger to user!
			System.out.println("The area rectangle seems " + (rArea / cArea) + " times bigger than the area of the circle");
		} else { // if they're not the same, and the rectangle is not bigger, then the circle is bigger! display how much bigger to user
			System.out.println("The area circle seems " + (cArea / rArea) + " times bigger than the area of the rectangle");
		}
		
		input.close(); // close scanner
	}
	
	public static double calculateRectangleArea(double wide, double high) { // this method takes two parameters, width and height of a rectangle, and returns the area of the circle
		double area = wide * high;
		return area;
	}

	public static double calculateCircleArea(double radius) { // this method takes one parameter, radius of a circle, calculates the area, and returns the area of the circle
		double area = Math.PI * Math.pow(radius, 2);
		return area;
	}
}
