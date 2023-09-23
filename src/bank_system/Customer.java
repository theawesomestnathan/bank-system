package bank_system;

import java.util.List;
import java.util.ArrayList;

public class Customer {
	private String customerID;
	private String name;
	private String address;
	private List<BankAccount> accounts = new ArrayList<BankAccount>();
	
	Customer(String customerID, String name, String address) {
		setCustomerID(customerID);
		setName(name);
		setAddress(address);
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}
	
}
