

import java.util.*;

public class CP5HashSet {
	static HashSet<String> CS210 = new HashSet<String>();
	static HashSet<String> CS211 = new HashSet<String>();
	static HashSet<String> CS212 = new HashSet<String>();

	public static void Initialize() {
		CS210.add("Bill");
		CS210.add("Eva");
		CS210.add("Olivia");
		CS211.add("Eva");
		CS211.add("Olivia");
		CS211.add("Kim");
		CS212.add("Chloe");
		CS212.add("Jane");
		CS212.add("Olivia");
		CS212.add("Bill");
	}

	public static void atLeastOneClass() {
		Set<String> temp1 = new HashSet<String>(CS210);
		Set<String> temp2 = new HashSet<String>(CS211);
		Set<String> temp3 = new HashSet<String>(CS212);
		
		temp1.addAll(temp2); // perform union of CS211 onto CS210
		temp1.addAll(temp3); // perform union on CS212 onto union of CS211 onto CS210
		// alternatively, this could be one line: temp1.addAll(temp2).addAll(temp3)
		// I didn't make it one line as I figured this was cleaner!
		
		System.out.print("At least one class: " + temp1 + "\n");
	}

	public static void allClasses() {
		Set<String> temp1 = new HashSet<String>(CS210);
		Set<String> temp2 = new HashSet<String>(CS211);
		Set<String> temp3 = new HashSet<String>(CS212);
		
		temp1.retainAll(temp2); // perform intersect of CS211 onto CS210
		temp1.retainAll(temp3); // perform intersect of CS212 onto intersect of CS211 onto CS210
		// alternatively, this could be one line: temp1.retainAll(temp2).retainAll(temp3)
		// I didn't make it one line as I figured this was cleaner!
		
		System.out.print("CS210 and CS211 and CS212: " + temp1 + "\n");
	}

	public static void onlyCS210() {
		Set<String> temp1 = new HashSet<String>(CS210);
		Set<String> temp2 = new HashSet<String>(CS211);
		Set<String> temp3 = new HashSet<String>(CS212);
		
		temp1.removeAll(temp2); // perform difference of CS211 onto CS210
		temp1.removeAll(temp3); // perform difference of CS212 onto difference of CS211 onto CS210
		
		System.out.print("CS210 Only: " + temp1 + "\n");
	}

	public static void violation() {

	}

	public static void CS210andCS211notCS212Classes() {

	}

	public static void main(String[] args) {
		Initialize();
		atLeastOneClass();
		allClasses();
		onlyCS210();
		violation();
		CS210andCS211notCS212Classes();
	}
}
