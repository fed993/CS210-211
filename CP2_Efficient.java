class BusRider {
  private double fare = 1.0;
  private String color = "Red";

  public double getFare() {
    return this.fare;
  }

  public String getColor() {
    return this.color;
  }
}

class Student extends BusRider {
  private final double STUDENT_RATE = 0.5;
  
  @Override
  public double getFare() {
    return super.getFare() * STUDENT_RATE;
  }

  @Override
  public String getColor() {
    return "Grey";
  }

  public void printTicket() {
    System.out.printf("Fare: %f Color: %s\n", getFare(), getColor());
  }
}
  
class Adult extends BusRider {
  public double getFare() {
    return super.getFare();
  }

  public String getColor() {
    return super.getColor();
  }

  public void printTicket() {
    System.out.printf("Fare: %f Color: %s\n", getFare(), getColor());
  }
}


public class CP2_Efficient {
  public static void main(String[] args) {
    Student Ed = new Student();
    Adult Amy = new Adult();

    Ed.printTicket();
    Amy.printTicket();
  }
}