package practice13;

/* 
 * CS210 Practice 13 (Find Index)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.02.16 - Winter Quarter
 *
 * This program features a findIndex method to search for the index of
 * 	an element in an array.
 * 
 */

public class ex1FindIndex {
	// this function reads through an array front to back, searching for
	//  a given element.
    public static int  findIndex (int[] my_array, int t) { 
    	int index = 0;
    	while (my_array[index] != t) {
    		index++;
    		// continue looping until the index is found
    	}
    	return index;
    }  

 

    public static void main(String[] args) { 
     int[] my_array = new int[] {25, 10, 55, 65, 36, 92, 77, 8, 13, 79}; 
     System.out.println("Index position of 55 is: " + findIndex(my_array, 55)); 
     System.out.println("Index position of 13 is: " + findIndex(my_array, 13)); 
    } 

}

//sample output
//Index position of 55 is: 2
//Index position of 13 is: 8
