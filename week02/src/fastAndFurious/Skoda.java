package fastAndFurious;

public class Skoda extends Car{
	
	public Skoda(){
		super(true);
	}
	
	@Override
	public boolean isEcoFriendly(){
		return true;
	}
	
}
