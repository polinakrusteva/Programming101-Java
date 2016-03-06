package friday;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CLI {
	private Bank bank = new Bank();

	public Set<String> prepareCommands() {
		Set<String> commands = new HashSet<>();
		commands.add("create_bank_account");
		commands.add("show_history");
		commands.add("add_money");
		commands.add("withdraw_money");
		commands.add("transfer_money");
		commands.add("calculate_amount");
		commands.add("commands_list");
		commands.add("exit");
		return commands;
	}

	public void createBankAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first name: ");
		String firstName = scanner.nextLine();
		System.out.println("Enter last name: ");
		String lastName = scanner.nextLine();
		System.out.println("Enter age: ");
		int age = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter initial balance: ");
		double balance = Double.parseDouble(scanner.nextLine());
		System.out.println("Enter account number: ");
		long accountNumber = Long.parseLong(scanner.nextLine());
		System.out.println("Enter interest type: ");
		String intType = scanner.nextLine();
		System.out.println("Enter interest value: ");
		Double intValue = Double.parseDouble(scanner.nextLine());

		BankAccountOwner owner = new BankAccountOwner(firstName, lastName, age);
		Interest interest = new Interest(intValue, intType);
		BankAccount account = new BankAccount(accountNumber, owner, balance,
				interest);

		bank.add(account);
		bank.get(accountNumber).getHistory().add("Created a bank account");

		scanner.close();
	}

	public void showHistory() throws NonExistingBankAccountException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter account number: ");
		long accountNumber = Long.parseLong(scanner.nextLine());

		scanner.close();

		if (bank.get(accountNumber) == null) {
			throw new NonExistingBankAccountException(
					"Bank account doesn't exist!");
		}
		bank.get(accountNumber).getHistory().showHistory();

	}

	public void addMoney() throws NonExistingBankAccountException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter account number: ");
		long accountNumber = Long.parseLong(scanner.nextLine());
		System.out.println("Enter amount of money you want to add: ");
		double money = Double.parseDouble(scanner.nextLine());

		scanner.close();

		if (bank.get(accountNumber) == null) {
			throw new NonExistingBankAccountException(
					"Bank account doesn't exist!");
		}
		bank.get(accountNumber).add(money);
		bank.get(accountNumber).getHistory()
				.add(String.format("Added %d", money));

	}

	public void withdrawMoney() throws InsufficientFundsException, Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter account number: ");
		long accountNumber = Long.parseLong(scanner.nextLine());
		System.out.println("Enter amount of money you want to withdraw: ");
		double money = Double.parseDouble(scanner.nextLine());

		scanner.close();

		if (bank.get(accountNumber) == null) {
			throw new NonExistingBankAccountException(
					"Bank account doesn't exist");
		}
		bank.get(accountNumber).withdraw(money);
		bank.get(accountNumber).getHistory()
				.add(String.format("Withdrawed %d", money));

	}

	public void transferMoney()
			throws InsufficientFundsException, NonExistingBankAccountException {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter origin account number: ");
		long originAccountNumber = Long.parseLong(scanner.nextLine());
		System.out.println("Enter destination account number: ");
		long destinationAccountNumber = Long.parseLong(scanner.nextLine());
		System.out.println("Enter amount of money you want to transfer: ");
		double money = Double.parseDouble(scanner.nextLine());

		scanner.close();

		if (bank.get(originAccountNumber) == null
				|| bank.get(destinationAccountNumber) == null) {
			throw new NonExistingBankAccountException(
					"Bank account doesn't exist!");
		}
		bank.get(originAccountNumber)
				.transfer(bank.get(destinationAccountNumber), money);
		bank.get(originAccountNumber).getHistory()
				.add(String.format(
						"Transfered %d to bank account with number %d", money,
						destinationAccountNumber));
		bank.get(destinationAccountNumber).getHistory()
				.add(String.format(
						"Received %d from bank account with number %d", money,
						originAccountNumber));

	}

	// TODO calculate_amount command
}
