package finals;

import java.util.*;
import java.io.*;

//class Person{
//	String name, type, gender;
//	int age;
//}
//
//class People{
//	ArrayList<Person> peopleList = new ArrayList();
//	
//	People(String fileNew) throws FileNotFoundException {
//		Scanner fileReader = new Scanner(new File(fileNew));
//		while (fileReader.hasNext()) {
//			Person human = new Person();
//		}
//	}
//}

class Star{
	String color  = "";
	int howMany = 0;
	
	Star(String color) {
		this.color = color;
	}
	Star(String color, int howMany) {
		this.color = color;
		this.howMany = howMany;
	}
}

public class FinalsForReals {
	public static void main(String args[]) {
//		double[] a = new double[4];
//		System.out.println(Arrays.toString(a));
		
//		int x = 1;
//		double y = 1.0;
//		double z = 2.0;
//		
//		y = A(x, y);
//		y = A(x, (int)y);
//		System.out.println(x + " " + y + " " + z);
		
//		double score = 90.0;
		String grade = "banana";
//		
//		if (score >= 90 && score <= 100)
//			grade = "A";
//		if (score >= 80)
//			grade = "B";
//		if (score >= 70)
//			grade = "C";
//		else
//			grade = "F";
		
		System.out.println(grade[grade.length() -1]);
	}
	
//	public static int A(int x, int y) {
//		return x + y;
//	}
//	
//	public static double A(double x, double y) {
//		return x + y;
//	}
	
//	public static double A(int x) {
//		return 'x' - 'y';
//	}
	
//	public static int A(int x) {
//		if (x>3) {
//			return 3;
//		}
//		else if (x<=3) {
//			return 0;
//		}
//	}
}
