package CP12;

/*
 * CS211  (Class Practice 12: ArrayList vs LinkedList speed test)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.05.25 - Spring Quarter
 *
 * This program tests the time it takes to remove large quantities of
 * indicies from both ArrayLists and LinkedLists, and compares them. 
 * 
 * ArrayLists are found to be on average 10% the time of LinkedLists. 
 * 	Though ArrayLists remove in O(n) and LinkedLists should remove in O(n) as well,
 * 	experimentally this is not the result we see. ArrayLists, on this machine (Early 2015 Macbook Air)
 * 	are running in a tenth the time of the LinkedLists. 
 * 
 * My best guess is that this has to do with how the CPU is caching the memory to be removed. 
 * 	Since LinkedLists are not necessarily stored in in memory
 * 	sequentially, the CPU prefech can't load the next element to be removed into cache, meaning every time
 * 	there is a new element to be deleted it needs to be found in the RAM, which is costly. 
 * 
 * Conversely, ArrayLists are likely implemented sequentially in memory, meaning that the CPU
 * 	can prefetch a whole cache_size worth of elements to arraycopy over when it performs the 
 * 	removal action. For the next cache_size elements, the cpu can perform very fast operations 
 * 	while the prefetch will load the next ones into another cache.
 * 
 * I also tried creating lots of tiny lists, and removing the middle element from them. 
 * 	Here, the LinkedList performs much faster than the ArrayList, on average, 75,000 x faster.
 * 
 */

import java.util.*;

public class ArrayListVsLinkedList {
	
	
	public static void main(String args[]) {
		runLargeSizeTests();
		runLotsOfLittleTests();
	
	}
	
	// creates large lists, removes large number of elements from each of them
	private static void runLargeSizeTests() {
		final int NUM_INDICES = 60000; // starting size
		final int NUM_REMOVED = 30000; // amount to remove from each
		final int NUM_TESTS = 5; // number of trials to run
		
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
	
	// creates large number of lists, removes middle element from each of them
	private static void runLotsOfLittleTests() {
		final int NUM_INDICES = 9; // starting size
		final int NUM_LISTS = 60000; // number of lists
		final int NUM_TESTS = 5; // number of trials to run
		
		for (int i = 0; i < NUM_TESTS; i++) {
			ArrayList<String> AL = new ArrayList<String>(); // create lists
			LinkedList<String> LL = new LinkedList<String>();
			
			long ALTime = 0;
			for (int j = 0; j < NUM_LISTS; j++) {
				AL = initialize(AL, NUM_INDICES); //initialize lists to starting size
				
				long timeStart = System.nanoTime(); // start counting nanoseconds
				AL.remove(NUM_INDICES / 2); // remove middle index
				long timeEnd = System.nanoTime(); // stop counting
				
				ALTime += (timeEnd - timeStart); // record time
			}
			
			long LLTime = 0;
			for (int j = 0; j < NUM_LISTS; j++) {
				LL = initialize(LL, NUM_INDICES); //initialize lists to starting size
				
				long timeStart = System.nanoTime(); // start counting nanoseconds
				LL.remove(NUM_INDICES / 2); // remove middle index
				long timeEnd = System.nanoTime(); // stop counting
				
				LLTime += (timeEnd - timeStart); // record time
			}
			
			System.out.printf("Running Small List Test: %s\n", i+1); // display results, +1 for test number since i = 0
			System.out.printf("Lists made: %s\n", NUM_LISTS);
			System.out.printf("ArrayList time: %s microseconds \n", (ALTime/1000000)); // /1000000 for microsecond to second conversion
			System.out.printf("LinkedList time: %s microseconds\n", (LLTime/1000000)); // ^
			System.out.printf("ArrayList processing time was %.2f%% of LinkedList\n\n", (double)((ALTime/LLTime) * 100) ); // *100 to convert to percent
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
