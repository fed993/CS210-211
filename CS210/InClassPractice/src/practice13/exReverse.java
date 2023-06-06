package practice13;

/* 
 * CS210 Practice 13 (Find Index)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.16 - Winter Quarter
 *
 * This program features a reverseArray method to reverse an array.
 * 	The method is tested and the result is printed.
 * 
 */

import java.util.Arrays;  

public class exReverse { 
	public static int[] reverseArray (int[] my_array) {
		int[] reversedArray = new int[(my_array.length)]; // init new array of same size
		int my_array_index = 0; // init index counter for old array
		
		for (int i = reversedArray.length-1; i >= 0; i--) { // begin output array's counter at max index, go until index reaches 0
			reversedArray[i] = my_array[my_array_index]; // write into new array's final index the value of input array's first index
			my_array_index++; // iterate input array's index counter up
		} // iterate output array's counter down
		
		return reversedArray;
	}

 	public static void main(String[] args){
 		int[] myArray = {1, 3, 5, 7, 8, 9, 11, 13, 15, 17};
 		int[] reverseArray = reverseArray(myArray);
 		
 		System.out.println("Original array : " + Arrays.toString(myArray));
 		System.out.println("Reverse array : " + Arrays.toString(reverseArray));
 	}
}

//Original array : [1, 3, 5, 7, 8, 9, 11, 13, 15, 17]

//Reverse array : [17, 15, 13, 11, 9, 8, 7, 5, 3, 1]