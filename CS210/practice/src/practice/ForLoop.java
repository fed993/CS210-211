package practice;

public class ForLoop {
	public static void main(String[] args) {
		for (int i = 1; i <= 9; i += 2) { // i represents value to write, should iterate by 2
			for(int j = 0; j <= i; j += 1) { // j represents number of times to write to the same line, goes until i
				System.out.print(i);
			}
//			System.out.println();
		}
		
//		int howMany = 5;
//		for (int i = 1; i <= howMany; i++) {
//			for(int j = 1; j <= i*2; j++) {
//				System.out.print( (i*2) );
//			}
//			System.out.println();
//		}
	}
	
//	
}
