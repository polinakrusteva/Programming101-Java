package week08;

public class Multiplier implements Runnable {

	private int _x;
	private int _y;

	public Multiplier(int x, int y) {
		_x = x;
		_y = y;
	}

	private double multiply() {
		return _x * _y;
	}

	@Override
	public void run() {
		System.out.println(multiply());
	}

}
