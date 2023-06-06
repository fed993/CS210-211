/*
 * CS211  (Class Practice 6: HashMap practice)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.25 - Spring Quarter
 *
 * This is a description of a Member object. Members:
 * 	have name Strings + getter
 * 	have age ints + getter
 * 	have a constructor for fast initialization
 * 	have a toString() method to return the contents of the Member.
 * 
 */

package CP6;

public class Member {
	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	@Override
	public String toString() {
		return "Member{name: " + name + ", age: " + age + "}";
	}
}
