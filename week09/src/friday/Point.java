package friday;

public class Point {

	private double x;
	private double y;

	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point other) {
		this.x = other.getX();
		this.y = other.getY();
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return "[" + this.x + ", " + this.y + "]";
	}
}
