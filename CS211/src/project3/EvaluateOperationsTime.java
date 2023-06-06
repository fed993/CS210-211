package project3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/*
 * CS211  (Class Practice 12: ArrayList vs LinkedList speed test)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.05.25 - Spring Quarter
 *
 * This program tests the time it takes to add large quantities of elements
 *  to both ArrayLists and LinkedLists, searching for elements in large ArrayLists 
 *  and LinkedLists, and removing large quantities of elements from both ArrayList 
 *  and LinkedLists. 
 * 
 */

public class EvaluateOperationsTime {
	static final int NUM_INDICES = 60000; // starting size
	static final int NUM_REMOVED = 30000; // amount to remove from each
	static final int NUM_TESTS = 5; // number of trials to run
	
	static ArrayList<String> AL = new ArrayList<String>(); // create lists
	static LinkedList<String> LL = new LinkedList<String>();
	
	static double TimeAdd_ArrayList;
	static double TimeAdd_LinkedList;
	
	static Random rand = new Random();
	static Bar211 bar ; // creates visual output
	
	public static void main(String[] args) {
		bar = new Bar211("CS 211, Spring 2023", NUM_TESTS);
		
		add();
		search();
		remove();
	}
	// add elements to lists
	private static void add() {
		int 
	}
	
	
	// search for elements in lists
	private static void search() {
		
	}
	
	
	// removes large number of elements from lists
	private static void remove() {
		
		
		for (int i = 0; i < NUM_TESTS; i++) {
			ArrayList<String> AL = new ArrayList<String>(); // create lists
			LinkedList<String> LL = new LinkedList<String>();
			
			AL = initialize(AL, NUM_INDICES); //initialize lists to starting size
			LL = initialize(LL, NUM_INDICES);
			
			double timeStart = System.currentTimeMillis(); // start counting miliseconds
			AL = delete(AL, NUM_REMOVED); // perform NUM_REMOVED remove operations on AL
			double timeEnd = System.currentTimeMillis(); // stop counting
			double ALTime = timeEnd - timeStart; // record time
			
			timeStart = System.currentTimeMillis(); // start counting miliseconds
			LL = delete(LL, NUM_REMOVED); // perform NUM_REMOVED remove operations on LL
			timeEnd = System.currentTimeMillis(); // stop counting
			double LLTime = timeEnd - timeStart; // record time
			
			System.out.printf("Running Large List Test: %s\n", i+1); // display results, +1 for test number since i = 0
			System.out.printf("Removed: %s\n", NUM_REMOVED);
			System.out.printf("ArrayList time: %s seconds\n", (ALTime/1000)); // /1000 for milisecond to second conversion
			System.out.printf("LinkedList time: %s seconds\n", (LLTime/1000)); // ^
			System.out.printf("ArrayList processing time was %.2f%% of LinkedList\n\n", ((ALTime/LLTime) * 100) ); // *100 to convert to percent
		}
	}
		
		// adds size elements to ArrayList, returns ArrayList
		private static ArrayList<String> initialize(ArrayList<String> AL, int size) {
			for (int i = 0; i < size; i++) { 
				AL.add("SOME STRING, LITERALLY THIS COULD BE ANYTHING");
			}
			
			return AL;
		}
		
		// adds size elements to LinkedList, returns LinkedList
		private static LinkedList<String> initialize(LinkedList<String> LL, int size) {
			for (int i = 0; i < size; i++) {
				LL.add("SOME STRING, LITERALLY THIS COULD BE ANYTHING");
			}
			
			return LL;
		}
		
		// removes numberToRemove elements from ArrayList, returns ArrayList
		private static ArrayList<String> delete(ArrayList<String> AL, int numberToRemove) {
			Random rand = new Random();
			
			for (int i = 0; i < numberToRemove; i++) {
				int removalInedx = rand.nextInt(AL.size());
				AL.remove(removalInedx);
			}
			
			return AL;
		}
		
		// removes numberToRemove elements from LinkedList, returns LinkedList
		private static LinkedList<String> delete(LinkedList<String> LL, int numberToRemove) {
			Random rand = new Random();
			
			for (int i = 0; i < numberToRemove; i++) {
				int removalInedx = rand.nextInt(LL.size());
				LL.remove(removalInedx);
			}
			
			return LL;
		}
}
