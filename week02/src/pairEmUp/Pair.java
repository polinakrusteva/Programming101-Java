package pairEmUp;

public class Pair {
	private final Object first;
	private final Object second;

	public Pair(Object first, Object second) {
		this.first = first;
		this.second = second;
	}

	public Object getFirst() {
		return this.first;
	}

	public Object getSecond() {
		return this.second;
	}

	@Override
	public String toString() {
		return "[" + first.toString() + ", " + second.toString() + "]";
	}

	@Override
	public boolean equals(Object other) {
		if((other instanceof Pair) && this.first.equals(((Pair)other).getFirst()) && this.second.equals(((Pair)other).getSecond())) {
			return true;
		}
		return false;
	}
}
