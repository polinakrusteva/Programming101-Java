package friday;

import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args)
			throws InsufficientFundsException, Exception {
		CLI cli = new CLI();
		Set<String> commands = cli.prepareCommands();
		Scanner scanner = new Scanner(System.in);
		String line;

		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (!commands.contains(line)) {
				switch (line) {
				case "create_bank_account":
					cli.createBankAccount();
					break;
				case "add_money":
					cli.addMoney();
					break;
				case "withdraw_money":
					cli.withdrawMoney();
					break;
				case "transfer_money":
					cli.transferMoney();
					break;
				case "show_history":
					cli.showHistory();
					break;
				case "commands_list":
					System.out.println(commands);
					break;
				case "exit":
					return;
				}
			}
		}
		scanner.close();
	}
}
