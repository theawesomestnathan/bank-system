package bank_system;

public class BankAccount {
	private String accountNumber;
	private double balance;
	private boolean status;
	
	BankAccount(String accountNumber) {
		setAccountNumber(accountNumber);
	}
	
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}
	
	public void withdraw(double amount) {
		if (getBalance() - amount < 0) {
			return;
		}
		setBalance(getBalance() - amount);
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
