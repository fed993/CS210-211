/*
 * CS211  (Class Practice 6: HashMap practice)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.25 - Spring Quarter
 *
 * This is a simple program that allows a user to create a "database" of members, stored by ID. 
 * 	Users can:
 * 		Add Members
 * 		Remove Members 
 * 		View all Members
 * 
 * This can be improved by writing the members to secondary storage instead of just memory,
 * and reading from secondary storage when the program starts up. 
 * 
 * If we wanted to implement multiple interfaces to the secondary storage, we'd need some kind
 * of synchronization protocol, so that terminals reading from storage have the most up-to-date information
 * and terminals writing to storage don't interfere with reading.
 * 
 * Ideally, this would also all be networked over the internet, so that means serialization and working with 
 * networking protocols too.
 *
 *	This would make for a really neat cumulative project that someone could work on through all cs211! 
 *	Maybe cs211++ ;)
 */

package CP6;

import java.util.*;

public class CP6 {
	public static void main(String args[]) {
		HashMap<String, Member> members = new HashMap<>();
		Scanner keyboard = new Scanner(System.in); // init scanner and map

		int selection = promptSelection(keyboard); // prompt user for menu choice

		// technically menu() could have been it's own method. I guess. I think this is
		// cleaner though.
		while (true) { // handle menu options
			if (selection == 1) { // run ADD feature, prompt for selection afterwards
				add(keyboard, members);
				selection = promptSelection(keyboard);
			} else if (selection == 2) { // run REMOVE feature, prompt for selection afterwards
				remove(keyboard, members);
				selection = promptSelection(keyboard);
			} else if (selection == 3) { // run VIEW feature, prompt for selection afterwards
				printCurrentMembers(members);
				selection = promptSelection(keyboard);
			} else if (selection == 4) { // exit program
				System.out.println("Bye!");
				break;
			}
		}
	}

	// prompt the user to choose options 1, 2, or 3. If not 1, 2, or 3, ask again
	// and
	// let the user know what to do differently.
	private static int promptSelection(Scanner keyboard) {
		int selection = 0;

		do {
			try {
				System.out.println("\nSelect 1)add   2)remove   3)view   4)quit");

				selection = Integer.parseInt(keyboard.next());
			} catch (NumberFormatException e) {
				System.out.print("Please input only a single integer!");
			}
		} while (!(selection == 1 || selection == 2 || selection == 3 || selection == 4));

		return selection;
	}

	// prompt the user for the ID, name, and age of the member being added. No error
	// checking for valid inputs.
	// if the key already exists, let the user know that they are overwriting an
	// existing entry.
	// if the key doesn't exist, add it to the map.
	// print the whole map when done.
	private static void add(Scanner keyboard, HashMap<String, Member> members) {
		System.out.print("\nPlease input id:"); // prompt user for id, name, age
		String id = keyboard.next();
		System.out.print("\nPlease input name:");
		String name = keyboard.next();
		System.out.print("\nPlease input age: ");
		int age = Integer.parseInt(keyboard.next());

		// I wanted to implement checking for key collisions with try-catch here, but
		// I found out that .put() doesn't throw exceptions. Common results online
		// build a custom HashMap class that implements Map, and I figured that was
		// outside
		// the scope of this assignment. So, I decided to keep the -overwrite if the key
		// is the same- behavior
		// and let the user know that an overwrite occurred, since this is how HashMaps
		// are implemented.
		// If I wanted to keep the data from being overwritten, I'd have built a
		// HashMap<ArrayList> and store
		// the Member instances indexed in the list, and append to the list when there
		// is a collision.

		if (members.containsKey(id)) { // if the map already contains the key, let the user know they are overwriting.
			System.out.printf("\nOverwriting id %s with %s and age %d\n", id, name, age);
			Member previous = members.put(id, new Member(name, age));
			System.out.printf("Overwrote id %s: member name %s of " + "age %d with: member name %s and age %d\n\n", id,
					previous.getName(), previous.getAge(), name, age);
		} else { // if key doesn't exist, just add the member
			System.out.printf("\nAdding %s with id %s and age %d\n\n", name, id, age);
			members.put(id, new Member(name, age));
			System.out.printf("Added: %s member name %s and age %d\n\n", id, name, age);
		}
		
		printCurrentMembers(members);
	}

	//prompt user for ID, check if it is in the map, attempt to remove, tell user the state of the map.
	private static void remove(Scanner keyboard, HashMap<String, Member> members) {
		System.out.print("\nPlease input id to be removed: "); // prompt user for ID
		String id = keyboard.next();

		if (members.containsKey(id)) { // if ID found, remove and let the user know. 
			members.remove(id);
			System.out.println(id + " successfully removed!\n");
		} else { // if ID not found, let user know that removal failed.
			System.out.println("\nMember " + id + " not found!");
			System.out.println("Removal failed.\n");
		}
		
		printCurrentMembers(members);
	}
	
	// print map size, iterate over map keys, return a string of ID, name, and age for each element in map.
	private static void printCurrentMembers(HashMap<String, Member> members) {
		System.out.println("Current members: " + members.size());

		for (String memberID : members.keySet()) {
			System.out.println("id: " + memberID + " " + members.get(memberID));
		}
	}

}
