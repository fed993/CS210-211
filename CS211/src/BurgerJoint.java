

public class BurgerJoint {
	private String toppings = "beef patty, tomato, onion, ranch source";
	private double cost = 3.0;
	
	public double getCost() {
		return cost;
	}
	
	public String getToppings() {
		return toppings;
	}
	
	public void menu() {
		System.out.printf("price: %s topping: %s\n", cost, toppings);
	}
}
