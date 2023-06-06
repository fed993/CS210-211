package exam1;

/*
 * 
When prompted to input the name, the code expects the user to type in an int, since the Scanner.nextInt() method is used. This can be fixed by expecting a String and using the Scanner.next() method instead on line 50.


1) The code outputs:
1.0




2)

line 7: the code initializes double num at 3

line 8 : begin for loop, i = 0, run as long as i is less than num. Each iteration of the loop will add 1 to i.
line 9: check if i < num % 2. (num % 2) == (3.0 % 2) == (1). i == 0, so 0 < 1 is true. enter if statement

line 10:pass num into division(), store result in num
line 16: enter method division() with num (3.0) as a parameter). 
line 17: return (num/2) cast into int. (3.0/2 == 1.5), (int) 1.5 == 1, return 1.

line 10: store 1 in num, num is now 1.0
line 12: print (1.0)
line 8: iterate i++, i = 1.
line 8: i < num == false, (1 < 1.0) == false, exit for loop
line 13: exit main method

1) this method takes as parameters two ints, a and b, and attempts to return their sum, a+b. The method is expected not to return, however, since the return type is set to void. This can be fixed by changing void to int. The correct method will look:

public static int sum(int a, int b) {
    return (a + b)
}

 */

import java.util.Scanner;

public class exam1p1 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("input your name");
		String name = input.next();
		if (name.equals("Chloe")) {
			System.out.println("snowboarder");
		}
		
//		System.out.println("What \"character\" does this \\print?");
		
//		int sumGPA = 7;
//		int no_of_students = 2;
//		double avgGPA = sumGPA/no_of_students;
//		System.out.println(avgGPA);
		
//		int sum = 0;
//		for (int i = 5; i<=1; i--) {
//			sum = sum + 1;
//		}
//		System.out.println(sum);
		
//		int i = 5.0;
//		double pi = 3.14;
//		String s = 'CS210';
//		System.out.println("i = ", i);
//		System.out.printf("%3.2d\n",pi);
//		System.out.println((int)pi);
		
		
//		 double pi=3.14159265359;
//
//		 for (int i = 1; i <= 5; i++) {
//			 System.out.printf("%7." + i + "f\n", pi);
//		 }
		
//		double num  = 3;
//		for (int i = 0; i < num; i++) {
//			if (i < num % 2) {
//				num = division(num);
//			}
//			System.out.println(num);
//		}
	}
	
	public static double division(double i) {
		return (int) (i/2);
	}
}
