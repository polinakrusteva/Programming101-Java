package week08;

public class Divisor implements Runnable {

	private int _a;
	private int _b;

	public Divisor(int a, int b) {
		_a = a;
		_b = b;
	}

	@Override
	public void run() {
		System.err.println(divide());
	}

	private double divide() {
		if (_b == 0) {
			throw new IllegalArgumentException("Cannot divide by zero.");
		}
		return _a / _b;
	}

}
