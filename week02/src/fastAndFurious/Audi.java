package fastAndFurious;

public class Audi extends Car{
	private int mileage;
	
	public Audi(int mileage){
		super(true);
		this.mileage = mileage;
	}
	
	@Override
	boolean isEcoFriendly() {
		return true;
	}
	
	public int getMileage(){
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}
