package assignment_4;

import java.io.*;
import java.util.*;

// this defines a person object, used to store information about each person in the file
//class Person {
//	public String role = "";
//	public String name = "";
//	public String gender = "";
//	public int age = 1;
//}

/*this class reads the file to a list, contains methods to filter the list based on  
	the occupation of the person
	the gender of the person
	the age of the person
 	and will print the valid names. If none are found, the methods let the user know that 
 	nobody matches the description given.
 A future version could generate a sublist of valid people and return it
 */
public class People {
	static ArrayList<Person> persons = new ArrayList<Person>();
	
	// read file and create a Person for each line in the file. Add each Person to the ArrayList
	People(String file) throws FileNotFoundException {
		File peopleFile = new File(file);
		Scanner fileReader = new Scanner(peopleFile);
		
		while (fileReader.hasNext()) {
			Person human = new Person();
			human.role = fileReader.next();
			human.name = fileReader.next();
			human.gender = fileReader.next();
			human.age = fileReader.nextInt();
			persons.add(human);
		}
	}
	
	// list all people with the matching role
	public void list(String role) {
		System.out.println("List of people");
		System.out.println("Type: " + role);
		
		for (Person human : persons) {
			if (human.role.equals(role)) {
				System.out.println(human.name);
			}
		}
		System.out.println();
	}
	
	// list all people with the matching role, gender, and are older or equal to the ageMin
	public void list(String role, String gender, int ageMin) {
		System.out.println("List of people");
		System.out.println("Type: " + role + " Gender: " + gender + " Age: >= " + ageMin);
		boolean foundAnyone = false;
		
		for (Person human : persons) {
			if ( !(human.role.equals(role)) ) {
				continue; // skip this person if they have the wrong role
			}
			if ( !(human.gender.equals(gender)) ) {
				continue; // skip this person if they have the wrong gender
			}
			if (human.age < ageMin) {
				continue; // skip this person if they are two young
			}
			
			System.out.println(human.name);
			foundAnyone = true;
		}
		
		if (!foundAnyone) {
			System.out.println("Nobody matches this description!");
		}
		System.out.println();
	}
	
	// list all people with the matching role, gender, and are older or equal to the ageMin AND younger or equal to the ageMax
	public void list(String role, String gender, int ageMin, int ageMax) {
		System.out.println("List of people");
		System.out.println("Type: " + role + " Gender: " + gender + " Age: >= " + ageMin + " and <= " + ageMax);
		boolean foundAnyone = false;
		
		for (Person human : persons) {
			if ( !(human.role.equals(role)) ) {
				continue; // skip this person if they have the wrong role
			}
			if ( !(human.gender.equals(gender)) ) {
				continue; // skip this person if they have the wrong gender
			}
			if (human.age < ageMin) {
				continue; // skip this person if they are two young
			}
			if (human.age > ageMax) {
				continue; // skip this person if they are too old
			}
			
			System.out.println(human.name);
			foundAnyone = true;
		}
		
		if (!foundAnyone) {
			System.out.println("Nobody matches this description!");
		}
		System.out.println();
	}
	
	// list all people with the matching role, and are older or equal to the ageMin
	public void list(String role, int ageMin) {
		System.out.println("List of people");
		System.out.println("Type: " + role + " Age: >= " + ageMin);
		boolean foundAnyone = false;
		
		for (Person human : persons) {
			if ( !(human.role.equals(role)) ) {
				continue; // skip this person if they have the wrong role
			}
			if (human.age < ageMin) {
				continue; // skip this person if they are two young
			}
			
			System.out.println(human.name);
			foundAnyone = true;
		}
		
		if (!foundAnyone) {
			System.out.println("Nobody matches this description!");
		}
		System.out.println();
	}
}
