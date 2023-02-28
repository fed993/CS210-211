package practice7;

/* 
 * CS210 Practice 7 (Text and Printf)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.27 - Winter Quarter
 *
 *
line 3 outputs:5 // the length of the string s is 5! so it prints the int 5

line 4 outputs:3 // (length-2) is 3, s.charAt(3) = D, s.charAt(0) = A. D is 68 by the ascii table, and A is 65 by the ascii table. 68 - 65 is 3, so the program prints 3!

line 5 outputs:B // the String "B" is the substring of "ABCDE" where the it is between locations 1 and 2, in "0A1B2C3D4E5"

line 6 outputs:CDE // the String "CDE" is the substring "ABCDE"

line 7 outputs:output_is__0.200 // first print the string "output_is_", then reserve 6 spaces for printing, aligned right. (double)1/length becomes (1.0/5), which is 0.2. Three decimal spaces are needed, so 0.200. Since 6 spaces are reserved, there is a space added at the beginning too. so, final formatted output is _0.200. this is concatenated onto the string, so final output is "output_is__0.200"
 * 
 */

//import java.util.Scanner;

public class TextAndPrintf {
	public static void main(String[] args) {
//		Scanner input = new Scanner(System.in);
		
//		System.out.println("ABCDE".charAt(2));
		
		double pi= 3.14159265359;

        for (int i = 10; i >= 1; i--) {
        	System.out.printf("%12." + i + "f\n", pi);
        }
        for (int i = 1; i <= 10; i++) {
        	System.out.printf("%12." + i + "f\n", pi);
        }
	}
}
