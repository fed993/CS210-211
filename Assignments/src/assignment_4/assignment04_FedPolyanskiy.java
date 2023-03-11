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
