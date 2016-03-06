package friday;

public class BankAccount {

	private long accountNumber;
	private BankAccountOwner owner;
	private double balance;
	private Interest interest;
	private History history;

	// TODO add logic for account number serialization
	public BankAccount(long accountNumber, BankAccountOwner owner,
			double balance, Interest interest) {
		this.accountNumber = accountNumber;
		this.owner = new BankAccountOwner(owner);
		this.balance = balance;
		this.interest = new Interest(interest);
		this.history = new History();
	}

	public long getAccountNumber() {
		return this.accountNumber;
	}

	public BankAccountOwner getBankAccountOwner() {
		return this.owner;
	}

	public double getBalance() {
		return this.balance;
	}

	public Interest getInterest() {
		return this.interest;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void add(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException(
					"Cannot add negative amount of money");
		} else {
			setBalance(this.getBalance() + amount);
		}
	}

	public void withdraw(double amount)
			throws InsufficientFundsException, Exception {
		if (this.balance - amount < 0) {
			throw new InsufficientFundsException(
					"Cannot withdraw more money than in balance");
		} else if (this.interest.getInterest() > 1) {
			throw new Exception(
					"Forbidden withdraws when interest is greater than 1%");
		} else {
			setBalance(this.balance - amount);
		}

	}

	public void transfer(BankAccount newOwner, double amount)
			throws InsufficientFundsException {
		if (this.balance - amount < 0) {
			throw new InsufficientFundsException(
					"Cannot transfer less money than in balance");
		} else {
			this.setBalance(this.balance - amount);
			newOwner.setBalance(this.getBalance() + amount);
		}
	}

	public History getHistory() {
		return history;
	}
}
