package bank_system;

public class BankSystem {
	public BankAccount createAccount(String accountNumber) {
		return new BankAccount(accountNumber);
	}
	
	public boolean closeAccount(BankAccount account) {
		account.setStatus(false);
		return true;
	}
	
	public double getAccountBalance(BankAccount account) {
		return account.getBalance();
	}
	
}
