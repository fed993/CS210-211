package practice14;

/* 
 * CS210 Practice 14 (Classes 1)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.23 - Winter Quarter
 *
 * This class is used to calculate areas. An instance of this class is created
 * 	in the Classes1 class, and then used to calculate the appropriate area.
 * 
 */


public class AreaCalculator {
	public double calculateTriangleArea(double base, double height) {
		return (base * height)/2;
	}
	
	public double calculateCircleArea(double radius) {
		return (Math.PI * radius * radius);
	}
}
