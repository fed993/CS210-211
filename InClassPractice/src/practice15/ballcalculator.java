package practice15;

class Ball {
	
	int size = 0;
	Ball(int x) {
		System.out.println(size);
		size = x;
	}
}

class Area {
	public static double base;
	public static double height;
	
	Area(double b, double h){
		base = b;
		height = h;
	}
	
	public double triangleArea() {
		return (base * height) / 2.0;
	}
}

public class ballcalculator {
	public static void main(String args[]) {
//		Ball b1 = new Ball(3);
//		System.out.println(b1.size);
//		Ball b2 = new Ball(b1.size);
//		System.out.println(b2.size);
		
		double width;
		double height;
		
		width = 10.0;
		height = 2.0;
		Area first = new Area(width, height);
		
		width = 30.0;
		height = 5.0;
		Area second = new Area(width, height);
		
		System.out.println(first.triangleArea());
		System.out.println(second.triangleArea());
	}
	
	
	/*
	 * The output will be:
0
3
0
3

The code first (ln 6, bottom) initializes an instance of Ball called b1, running the Ball(int) constructor. The constructor will print the size of b1, (ln 7 top) which is initialized to 0. Then, it sets the size to whatever int was passed in, in this case, 3.  Then, (ln 7 bottom) the code prints the size of b1, which is now set to 3. Then, (ln 8 bottom) the code initializes an instance of Ball called b2, passing in the size of b1 as the parameter. During the constructor, once again, the code prints the initialized size of b2, which is 0. Then, (ln 9 bottom) the code prints the size of b2, which has now been set to the size of b1, which is 3.
	 
	 *
	 *The code will output:
75.0
75.0

This is because "base" and "height" class variables in the Area class are static, meaning they are shared between all instances of the Area class. When the second triangle is created (lines 16-18 bottom), it overwrites the base and height information for the first class, so when lines 20 and 21 run, first.triangleArea() will calculate using the intended base and height of the second triangle, and then second.triangleArea() will also calculate using the intended base and height of the second triangle.

line by line;

ln7-8: declare width and height local vars
ln 11-12: init width and height local vars for first triangle, width = 10.0, height = 2.0
ln 13: create an instance of the Area class, called first, passing width and height in. 10.0 is stored in the static class variable base, and 2.0 is stored in the static class variable height.
ln 16-17: init width and height local vars for first triangle, width = 30.0, height = 5.0
ln 18: create an instance of the Area class, called second, passing width and height in. The static variables base and height are shared between first and second, meaning despite there being two instances, there is only one set of static variables that are accessible to all instances. So, when second writes to width with 30.0 and to height with 5.0, when first accesses width and height it will see 30.0 and 5.0.
ln 20: calculate area of first (width = 30.0 height = 5.0), print it (75.0)
ln 20: calculate area of second (width = 30.0 height = 5.0), print it (75.0)
	 */
	
}
