package fastAndFurious;

public abstract class Car {
	private boolean ecoFriendly;
	
	public Car(boolean ecoFriendly) {
		this.ecoFriendly = ecoFriendly;
	}

	abstract boolean isEcoFriendly();
}
