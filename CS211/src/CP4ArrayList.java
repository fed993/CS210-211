/* 
 * CS211 Class Practice 4 (ArrayList)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.18 - Spring Quarter
 *	
 *		
 *	This class contains methods to parse a file to an ArrayList, print the contents of the ArrayList,
 *	and search the ArrayList for contents matching a specified value. It also implements try-catch statements.	
 *
 */

import java.util.*;
import java.io.*;

public class CP4ArrayList {
	
	public static void main(String args[]) {
		try {
			ArrayList<Student> students = parseFile("score.txt"); //students will store the Students found in file
			
			printContents(students); // print the contents of the ArrayList
			
			findStudents(askForInt(), students); // find students with the scores specified
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
		
	}
	
	//reads entire file given the in string fileName to an ArrayList of <Student> objects, 
	//returns entire ArrayList<Student>.
	public static ArrayList<Student> parseFile(String fileName) throws FileNotFoundException {
		ArrayList<Student> students = new ArrayList<Student>();
		File file = new File(fileName);
		Scanner fileReader = new Scanner(file);
		
		while (fileReader.hasNext()) {
			//build student object
			Student s = new Student();
			//populate student object
			s.name = fileReader.next();
			s.score = fileReader.nextInt();
			//add student object to ArrayList
			students.add(s);
		}
		
		return students;
	}
	
	//iterate over array, print all students names and scores.
	public static void printContents(ArrayList<Student> students) {
		for (Student student : students) {
			System.out.printf("Name: %8s   Score: %d\n", student.name, student.score);
		}
	}
	
	//runs loop asking for int, parsing to an integer, and if parsing fails asks again. otherwise returns int given
	public static int askForInt() {
		Scanner keyboard = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("\nInput desired score: ");
				return Integer.parseInt(keyboard.next());
				
			} catch (NumberFormatException e) {
				System.out.print("Input integer number only!");
				continue;
			}
		}
	}
	
	//iterate over array, print all students names that match the score desired
	public static void findStudents(int score, ArrayList<Student> students) {
		for (Student student : students) {
			if (student.score >= score) {
				System.out.printf("Name: %8s   Score: %d\n", student.name, student.score);
			}
		}
	}
}
