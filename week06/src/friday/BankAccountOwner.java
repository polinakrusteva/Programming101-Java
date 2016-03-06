package friday;

public class BankAccountOwner {

	private String firstName;
	private String lastName;
	private int age;

	public BankAccountOwner(String firstName, String lastName, int age) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}

	public BankAccountOwner(BankAccountOwner other){
		setFirstName(other.getFirstName());
		setLastName(other.getLastName());
		setAge(other.getAge());
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getAge() {
		return this.age;
	}

	public void setFirstName(String firstName) {
		if (!firstName.matches("^[a-zA-Z]+$")) {
			throw new IllegalArgumentException("Invalid name input");
		} else {
			this.firstName = firstName;
		}
	}

	public void setLastName(String lastName) {
		if (!firstName.matches("^[a-zA-Z]+$")) {
			throw new IllegalArgumentException("Invalid name input");
		} else {
			this.lastName = lastName;
		}
	}

	public void setAge(int age) {
		if(age < 18){
			throw new IllegalArgumentException("Cannot create a bank account if owner age is less than 18");
		}
		this.age = age;
	}

}
