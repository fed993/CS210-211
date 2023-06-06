package exam;

import java.util.*;

public class MidExam {
	
	
	public static void main(String[] args) {
//		ArrayList<Integer> al =  new ArrayList<Integer>();
//		HashSet<Integer> hs =  new HashSet<Integer>();
//		HashMap<Integer, Integer> hm =  new HashMap<Integer, Integer>();
//		
//		for(int i = 0; i < 2; i++) {
//			al.add(i++);
//			hs.add(i);
//			hm.put(i--, al.get(i));
//		}
//		
//		System.out.println(al);
//		System.out.println(hs);
//		System.out.println(hm);
		
		long humidityL = 92;
		try {
			String humidity = Double.toString((long)humidityL);
			System.out.println(humidity);
		} catch (ClassCastException e) {
			e.printStackTrace();
		}
	}
}
