package filereadingpractice;

import java.io.*;
import java.util.*;

public class FileReadingPractice {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/home/eclipse-workspace/practice/student.txt");
		
		Scanner fileReader = new Scanner(file);
		double totalAge = 0;
		int counter = 0;
		
		System.out.println(file.getName());
		
//		System.out.print(fileReader.nextInt());
		
		for (int i=1; i<=6; i++) {
			fileReader.nextInt();
			fileReader.next();
			fileReader.next();
			int age = fileReader.nextInt();
			
			counter++;
			totalAge += age;
		}
		
		System.out.printf("%.2f", totalAge / counter);
		fileReader.close();
	}
}
