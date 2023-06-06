package recursionPractice;

public class RecursionPractice {
	public static void main(String[] args) {
		recursion(999999);
	}
	
	private static void recursion(int i) {
		if (i <= 0) {
			System.out.println("we hit zerooooooooooo!!!!!!!!!!!!!!!!!!!!!!");
		} else if (i > 0) {
			recursion(i-1);
		} else {
			recursion(i+1);
		}
	}
}
