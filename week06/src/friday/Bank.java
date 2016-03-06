package friday;

import java.util.LinkedList;
import java.util.List;

public class Bank {

	private List<BankAccount> accounts;

	public Bank() {
		this.accounts = new LinkedList<>();
	}

	public void add(BankAccount account) {
		accounts.add(account);
	}

	public BankAccount get(long accountNumber) {
		for (BankAccount account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

}
