/* 
 * CS211 Class Practice 2 (Bus Fares)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.11 - Spring Quarter
 *
 * This is a simple program that calculates bus fares for various types of bus passengers, using inheritance. 
 * 
 */

class BusRider {
  // riders have a base fare of 3.0, and base ticket color of Red
  private double fare = 3.0;
  private String color = "Red";

  //getter methods
  public double getFare() {
    return this.fare;
  }

  public String getColor() {
    return this.color;
  }
}

class Student extends BusRider {
  // students get a 50% discount on bus fares
  private final double STUDENT_RATE = 0.5;

  //@Override is not necessary but included to improve readability
  @Override
  public double getFare() {
    return super.getFare() * STUDENT_RATE;
  }

  @Override
  public String getColor() {
    return "Grey";
  }

  // calculates and prints fare ticket
  public void printTicket() {
    System.out.printf("Fare: %f Color: %s\n", getFare(), getColor());
  }
}
  
class Adult extends BusRider {
  @Override
  public double getFare() {
    return super.getFare();
  }

  @Override
  public String getColor() {
    return super.getColor();
  }

  // calculates and prints fare ticket
  public void printTicket() {
    System.out.printf("Fare: %f Color: %s\n", getFare(), getColor());
  }
}


class Main {
  public static void main(String[] args) {
    //innitiate two bus riders, print their sample tickets
    Student Ed = new Student();
    Adult Amy = new Adult();

    Ed.printTicket();
    Amy.printTicket();

    RiderOfTheBus Markus = new RiderOfTheBus("Adult");
    RiderOfTheBus Markaroni = new RiderOfTheBus("Student");

    Markus.printTicket();
    Markaroni.printTicket();
  }
}

/* 
 * CS211 Class Practice 2 (Bus Fares)
 * Fedor Polyanskiy - f.polyanskiy@bellevuecollege.edu
 * Student ID: 201 690 498
 * 2023.04.11 - Spring Quarter
 *
 * This is a simple program that calculates bus fares for various types of bus passengers, without using inheritance. Hard to scale for development (Imagine 9000 different bus passenger and ticket types? Dev time and maintainence would be high), but I think computationally faster?
 * 
 */

class RiderOfTheBus {
  // students get a 50% discount on bus fares
  private final double STUDENT_RATE = 0.5;
  
  // riders have a base fare of 3.0, and base ticket color of Red
  private double fare = 3.0;
  private String color = "Red";

  // constructor, if Student then they get a Grey ticket
  RiderOfTheBus(String type){
    if (type == "Student"){
      this.color = "Grey";
    } else {
      this.color = "Red";
    }
  }
  
  //getter methods
  public double getFare() {
    return this.fare;
  }

  public String getColor() {
    return this.color;
  }

  // check ticket color to see if they get a student discount
  public void printTicket() {
    if (this.color == "Red"){
          System.out.printf("Fare: %f Color: %s\n", this.fare, this.color);
    } else if (this.color == "Grey"){
          System.out.printf("Fare: %f Color: %s\n", this.fare * STUDENT_RATE, "Grey");

    }
  }
}