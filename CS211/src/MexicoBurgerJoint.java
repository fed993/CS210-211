

public class MexicoBurgerJoint extends BurgerJoint {
	private final double USD_TO_PESO = 18.05;
	private String mexicoAdditionalToppings = ", taco source";
	
	@Override
	public void menu() {
		System.out.printf("price: %.2f topping: %s\n", super.getCost() * USD_TO_PESO, (super.getToppings() + mexicoAdditionalToppings));
	}

}
