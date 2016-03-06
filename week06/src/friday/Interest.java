package friday;

public class Interest {

	private double interest;
	private String type;

	public Interest(double interest, String type) {
		setInterest(interest);
		setType(type);
	}

	public Interest(Interest other) {
		setInterest(interest);
		setType(type);
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		if (!type.equals("complex") || !type.equals("simple")) {
			throw new IllegalArgumentException(
					"Interest type must be complex or simple");
		} else {
			this.type = type;
		}
	}
}
