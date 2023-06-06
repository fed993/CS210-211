package practice;
 //Fedor Polyanskiy     201690498
public class MyRocket {
	public static void main(String[] args) {
		printCap();
		printSegment();
		printMiddle();
		printSegment();
		printThrusters();
	}
	
	static void printCap() {
		System.out.println("   /|\\  ");
		System.out.println("  / | \\");
		System.out.println(" /  |  \\");
		printStageSeperator();
	}
	
	static void printStageSeperator() {
		System.out.println("+-------+");
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
