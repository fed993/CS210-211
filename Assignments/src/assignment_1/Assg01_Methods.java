package assignment_1;
/* 
 * CS210 Assignment 01 (Methods - Sequence)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.10 - Winter Quarter
 *
 * This program is a short puzzle.
 */

public class Assg01_Methods {

    public static void first() {// prints "first method", then runs third(), which prints "third method\nsecond method", then runs second() which prints "second method"
        System.out.println("first method");
        third();
        second();
        
    }

    public static void second() { // prints "second method"
        System.out.println("second method");
        
        
    }
 
    public static void third() { // prints "third method", then runs second() which prints "second method"
        System.out.println("third method");
        second();
        
        
    } 
 
    public static void main(String[] args) {
    // DO NOT change this main method
       first();
       third();
       second();
       third();
    // DO NOT change this main method
    }

}


// Desired output:
// first method
// third method
// second method
// second method
// third method
// second method
// second method
// third method
// second method

