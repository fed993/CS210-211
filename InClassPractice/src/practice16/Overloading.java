package practice16;

/*
 * The output will be:
"c=25.0 d=13.0 e=0.0"

a = 12, as an int, and b = 13.0, as a double.

c is the result of m(int, double), meaning the first method is run. The result is summing 12 and 13.0, making c = 25.0.

d is the result of m(double, double), meaning the second method is run. This is because the only method with a first parameter that is a double is the second method. a is an int, and doesn't match with the second parameter, but this is okay because we can plug in ints into doubles, and Java will treat them as their integer component, with a decimal component of 0. m(25.0, 12) returns 13.0, meaning d = 13.0

e is the result of m(int, int). This is because the second parameter, d, is cast to an int, before being sent to the methods. The method returns the result of 12 % 13, meaning "What's the remainder when we divide 12 by 13?" Since 12 is smaller than 13, the remainder is 0. The result is returned as a double, so e = 0.0
 * 
 * 
 * The mistake here is flagging the variables shape.width and shape.height with the static keyword. This means that width and height are shared between all instances of shape, so if any instance writes to width or height, all instances will have their width or height overwritten.

When shape s2 sets its width and height on lines 26 and 27, they overwrite the width and height of s1. This means that when lines 28 and 29 run, the (intended) area of s2 is printed twice. 

To fix this mistake, simply remove the static keyword from lines 5 and 6. Then, width and height will be variables unique to each instance of shape (instance variables) instead of shared between all instances (class variables).
 */

public class Overloading {
	static double m(double x, int y) {
		return x - y;
	}
	
	public static void main(String[] args) {
		
		System.out.println(m(25.0, 12));
	}

}
