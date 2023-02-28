package assignment_1;
/* 
 * CS210 Assignment 01 (Methods - Clementine)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.01.10 - Winter Quarter
 *
 * This program writes the lyrics to "Clementine"
 */

public class Assg01_Clementine{

  public static void main(String[] args) {
      title();
      firstVerse();
      refrain();
      secondVerse();
      refrain();
      thirdVerse();
      refrain();
   }
  
  static void title() { // prints title to Clementine
	  System.out.println("Clementine");
      System.out.println();
  }
  
  static void refrain() { // prints refrain to Clementine
	  System.out.println("Oh, my darling, oh, my darling");
      System.out.println("Oh, my darling Clementine");
      System.out.println("You are lost and gone forever");
      System.out.println("Dreadful sorry, Clementine.");
      System.out.println();
  }
  
  static void firstVerse() { // prints first verse of Clementine
	  System.out.println("In a cavern, in a canyon");
      System.out.println("Excavating for a mine");
      System.out.println("Lived a miner, forty-niner");
      System.out.println("And his daughter, Clementine.");
      System.out.println();
  }
  
  static void secondVerse() { // prints second verse of Clementine
	  System.out.println("Light she was and like a fairy");
      System.out.println("And her shoes were number 9");
      System.out.println("Herring boxes without topses");
      System.out.println("Sandals were for Clementine");
      System.out.println();
  }

  static void thirdVerse() { // prints third verse of Clementine
	  System.out.println("Drove she ducklings to the water");
      System.out.println("Every morning just at nine");
      System.out.println("Hit her foot against a splinter");
      System.out.println("Fell into the foaming brine");
      System.out.println();
  }
}