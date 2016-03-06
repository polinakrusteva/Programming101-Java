package friday;

@SuppressWarnings("serial")
public class NonExistingBankAccountException extends Exception {

	public NonExistingBankAccountException() {

	}

	public NonExistingBankAccountException(String message) {
		super(message);
	}

}
