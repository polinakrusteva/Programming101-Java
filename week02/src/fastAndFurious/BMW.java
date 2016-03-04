package fastAndFurious;

public class BMW extends Car {

	public BMW() {
		super(true);
	}

	@Override
	public boolean isEcoFriendly() {
		return true;
	}

}
