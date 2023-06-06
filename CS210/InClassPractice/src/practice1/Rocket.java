package practice1;

public class Rocket {
	 //Fedor Polyanskiy     201690498  f.polyanskiy@bellevuecollege.edu
	public static void main(String[] args) {
		printCap();
		printSegment();
		printMiddle();
		printSegment();
		printThrusters();
	}
	
	static void printStageSeperator() {
		System.out.println("+-------+");
	}
	
	static void printCap() {
		
		System.out.println("   /|\\  ");
		System.out.println("  / | \\");
		System.out.println(" /  |  \\");
		printStageSeperator();
	}
	
	static void printSegment() {
		System.out.println("|       |");
		System.out.println("|       |");
		printStageSeperator();
	}
	
	static void printMiddle() {
		System.out.println("|  969  |");
		printStageSeperator();
	}
	
	static void printThrusters() {
		System.out.println("   /|\\  ");
		System.out.println("  / | \\");
		System.out.println(" /  |  \\");
	}
}
