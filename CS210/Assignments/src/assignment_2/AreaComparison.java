package assignment_2;

/* 
 * CS210 Assignment 2 (Area Comparison)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.25 - Winter Quarter
 *
 * This program prompts the user for a shape, then the size of the shape, then repeats for another shape.
 *  Then, it calculates the areas of the shapes, and reports to the user the area of each shape and, and show which areas is larger
 * 	as well as by what factor
 * 
 */

import java.util.Scanner;


public class AreaComparison {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String firstShape = handleFirstInput(input);
		double firstShapeArea = determineArea(firstShape, input);
		
		String secondShape = handleSecondInput(input, firstShape);
		double secondShapeArea = determineArea(secondShape, input);
		
		displayShapeAreas(firstShape, firstShapeArea, secondShape, secondShapeArea);
		outputToUser(firstShape, firstShapeArea, secondShape, secondShapeArea);
		
		input.close();
	}
	
	// this method takes as input an int, representing a shape, and returns the shape, as a string
	public static String convertShapeIntToString(int shapeInput) {
		String shape = "";
		
		if (shapeInput == 1) {
			shape = "Rectangle";
		} else if (shapeInput == 2) {
			shape = "Triangle";
		} else if (shapeInput == 3) {
			shape = "Circle";
		}
		
		return shape;
	}
	
	// this method checks that the ints input are either a 1, 2, or a 3 and will prompt the user otherwise
	public static boolean checkInputInRange(int shapeInput) {
		// if the input is either a 1, 2, or 3, input is valid
		if ((shapeInput == 1) || (shapeInput == 2) || (shapeInput == 3)) {
			return true;
		} else { // otherwise input is invalid, prompt user for valid input
			System.out.println("Invalid input! Please input only a \"1\", \"2\", or \"3\".\n");
			return false;
		}
	}
	
	// this method handles getting the first shape from the user.
	// if the user inputs an int not equal to 1, 2, or 3, it will loop until a valid int is provided
	// there is no error handling for non-int user inputs.
	public static String handleFirstInput(Scanner input) {
		boolean gotInput = false;
		int shapeInput = 0;
		String shape = "";
		
		// this loop will prompt user for a shape until the valid input case (ints 1, 2, or 3) is found
		while (!gotInput) { 
			System.out.print("Define a first shape (1)rectangle, 2)triangle, 3)circle): ");
			shapeInput = input.nextInt();
			
			if (checkInputInRange(shapeInput)) {
				gotInput = true; // if the input is a 1, 2, or 3, close the loop!
				shape = convertShapeIntToString(shapeInput);
			}
		}
		
		return shape;
	}
	
	public static boolean checkIfShapesAreSame(int newShape, String firstShape) {
		if (newShape == 1 && firstShape == "Rectangle") {
			System.out.println("Your second shape is the same as the first shape! Please chose another shape!\n");
			return true;
		} else if (newShape == 2 && firstShape == "Triangle") {
			System.out.println("Your second shape is the same as the first shape! Please chose another shape!\n");
			return true;
		} else if (newShape == 3 && firstShape == "Circle"){
			System.out.println("Your second shape is the same as the first shape! Please chose another shape!\n");
			return true;
		} else {
			return false;
		}
	}
	
	// this method takes a second shape from the user,
	// makes sure the shape isn't the same as the first, 
	// makes sure the input given is a valid shape, 
	// and returns the shape as a string.
	public static String handleSecondInput(Scanner input, String firstShape) {
		boolean gotInput = false;
		int shapeInput = 0;
		String shape = "";
		
		while (!gotInput) { // this loop will run until the valid input case is found
			System.out.print("Define a second shape (1)rectangle, 2)triangle, 3)circle): ");
			shapeInput = input.nextInt();
			
			// first check to see if the second shape is the same as the second, prompt user, no change to flag as loop is still invalid
			if (!checkIfShapesAreSame(shapeInput, firstShape)) {
				// also check if input is a 1, 2, or 3, anything else is not acceptable!
				if (checkInputInRange(shapeInput)) {
					shape = convertShapeIntToString(shapeInput);
					gotInput = true; // if the input is valid, close the loop!
				}
			}
		}
		return shape;
	}
	
	// these next 3 methods handle the low level dimension inputs for each shape, return their area
	public static double determineRectangleArea(Scanner scanner) {
		System.out.print("Rectangle Width:  ");
		double width = scanner.nextDouble();
		System.out.print("Rectangle Height: ");
		double height = scanner.nextDouble();
		
		System.out.println(); //						 this println is added for formatting
		return calculateRectangleArea(width, height);
	}
	
	public static double determineTriangleArea(Scanner scanner) {
		System.out.print("Triangle Base:   ");
		double base = scanner.nextDouble();
		System.out.print("Triangle Height: ");
		double height = scanner.nextDouble();
		
		System.out.println(); //						 this println is added for formatting
		return calculateTriangleArea(base, height);	}
	
	public static double determineCircleArea(Scanner scanner) {
		System.out.print("Circle Radius: ");
		double radius = scanner.nextDouble();
		
		System.out.println(); //						 this println is added for formatting
		return calculateCircleArea(radius);
	}
	
	// this method takes the shape as a String, and a Scanner with which to prompt the user
	// and prompts the user for the dimensions of the shape. 
	// it calls the appropriate method to calculate the shape's area
	// and returns the area as a double
	public static double determineArea(String shape, Scanner input) {
		double area = 0.0;
		
		if (shape == "Rectangle") {
			area = determineRectangleArea(input);
		} else if (shape == "Triangle") {
			area = determineTriangleArea(input);
		} else if (shape == "Circle") {
			area = determineCircleArea(input);
		}
		
		return area;
	}
	
	// this method displays the areas of each shape out to the user
	public static void displayShapeAreas(String firstShape, double firstShapeArea, String secondShape, double secondShapeArea) {
		String formattedPrompt = firstShape + " area: "; // create formatted string to output proper shape name
		
		System.out.printf("%-16s%.2f", formattedPrompt, firstShapeArea); // print what the first shape area is
		
		formattedPrompt = secondShape + " area:"; // update formatted string to output proper shape name
		
		System.out.println();
		System.out.printf("\n%-16s%.2f", formattedPrompt, secondShapeArea); // print what the second shape area is
	}
	
	// this method displays the relationship between the areas of each shape to the user
	public static void outputToUser(String firstShape, double firstShapeArea, String secondShape, double secondShapeArea) {
		firstShape = (firstShape.substring(0,1).toLowerCase()) + firstShape.substring(1); // change first shape first letter to lowercase
		secondShape = secondShape.substring(0,1).toLowerCase() + secondShape.substring(1); // change second shape first letter to lowercase
		
		System.out.println(); //						 this println is added for formatting
		
		if (firstShapeArea > secondShapeArea) { // if the first area is bigger, print with text "bigger"
			System.out.printf("The area of the %s seems %.2f times bigger than the area of the %s.", firstShape, firstShapeArea/secondShapeArea, secondShape);
		} else if (firstShapeArea < secondShapeArea){ // if the first area is s
			System.out.printf("The area of the %s seems %.2f times smaller than the area of the %s.", firstShape, firstShapeArea/secondShapeArea, secondShape);
		} else { // if the areas are the same, print this to the user
			System.out.printf("The area of the %s seems %.2f times the area of the %s., they're the same size!", firstShape, firstShapeArea/secondShapeArea, secondShape);
		}
		
	}
	
	// this method takes two parameters, width and height of a rectangle, and returns the area of the rectangle
	public static double calculateRectangleArea(double wide, double high) { 
		double area = wide * high;
		return area;
	}
	
	// this method takes two parameters, the base and height of a triangle, calculates the area, and returns the area of the triangle
	public static double calculateTriangleArea(double base, double height) {
		double area = (base * height) / 2;
		return area;
	}
	
	// this method takes one parameter, radius of a circle, calculates the area, and returns the area of the circle
	public static double calculateCircleArea(double radius) { 
		double area = Math.PI * Math.pow(radius, 2);
		return area;
	}
}
