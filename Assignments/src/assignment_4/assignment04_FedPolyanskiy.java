/*
 * CS210  (Assignment 4)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.03.10 - Winter Quarter
 *
 *	This main method creates an instance of People, and prompts People to 
 *		list a few different lists of people's name, based on their occupation, gender, and age.
 * 
 */

package assignment_4;

import java.io.*;

public class assignment04_FedPolyanskiy {
	public static void main(String args[]) throws FileNotFoundException {
		People p = new People("people.txt");
		
		p.list("student");
		p.list("student", "male", 18);
		p.list("student", "female", 15, 18);
		p.list("student", 20);
	}
}
