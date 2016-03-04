package fastAndFurious;

public class Honda extends Car {
	
	public Honda() {
		super(true);
	}

	@Override
	boolean isEcoFriendly() {
		return true;
	}

}
