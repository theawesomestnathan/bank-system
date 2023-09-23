package bank_system;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<Customer>();
		List<BankAccount> accounts = new ArrayList<BankAccount>();
		
		Scanner sc = new Scanner(System.in);
		
		String username, address;
		
		boolean isBankOpen = false;
		
		int index = -1, option;
		
		while (true) {
			System.out.println("Actions");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Open Bank");
			System.out.println("4. Log Out");
			
			option = sc.nextInt();
			
			switch(option) {
				case 1:
					if (customers.isEmpty()) {
						System.out.println("no accounts. srry");
						break;
					}
					
					System.out.println("Options");
					for (Customer customer : customers) {
						System.out.println((customers.indexOf(customer) + 1) + ". " + customer.getCustomerID());
					}
										
					System.out.print("Username: ");
					username = sc.next();
					
					System.out.print("Address: ");
					address = sc.next();
					
					System.out.print("Option: ");
					option = sc.nextInt() - 1;
					
					if (!username.equals(customers.get(option).getName()) && !address.equals(customers.get(option).getAddress())) {
						index = -1;
						System.out.println("wrong");
						break;
					}
										
					index = option;
					
					break;
				case 2:
					createCustomer(customers);
					break;
				case 3:
					if (index == -1) {
						System.out.println("No.");
						break;
					}
					
					isBankOpen = true;
					
					break;
				case 4: 
					if (index == -1) {
						System.out.println("No.");
						break;
					}
					isBankOpen = false;
					index = -1;
					
					break;
					
				default:
					System.out.println("thats not an option");
	
			}
			
			if (!isBankOpen) {
				continue;
			}
			
			System.out.println("Actions");
			System.out.println("1. Create customer");
			System.out.println("2. Enter bank");
			
			option = sc.nextInt();
			
			switch (option) {
				case 1:
					createCustomer(customers);
					break;
				case 2:
					System.out.println("Actions");
					System.out.println("Create account");
					System.out.println("Close account");
					System.out.println("Deposit");
					System.out.println("Withdraw");
					System.out.println("Check Balance");
					
					option = sc.nextInt();
					
					switch(option) {
						case 1:
							createAccount(accounts);
							break;
						case 2:
							closeAccount(accounts);
							break;
						case 3:
							deposit(accounts);
							break;
						case 4:
							withdraw(accounts);
							break;
						case 5:
							checkBalance(accounts);
							break;
						default:
							System.out.println("nah bro");	
					}
					
					break;
				default:
					System.out.println("Invalid option. Try again with a valid one.");
			}		
			
		}
						
	}
	
	public static void createCustomer(List<Customer> customers){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Name: ");
		String name = sc.nextLine();
		
		System.out.println("Address: ");
		String address = sc.nextLine();
		
		Random random = new Random();
				
		Customer customer = new Customer(Integer.toString(random.nextInt(1000)), name, address);
		
		System.out.println("Created new customer with ID " + customer.getCustomerID());
		
		customers.add(customer);
	}
	
	public static void createAccount(List<BankAccount> accounts) {
		Random random = new Random();
		
		BankSystem bankSystem = new BankSystem();
		
		BankAccount bankAccount = bankSystem.createAccount(Integer.toString(random.nextInt(1000)));
		
		System.out.println("Created new account with ID " + (bankAccount.getAccountNumber()));
		
		accounts.add(bankAccount);
	}
	
	public static void closeAccount(List<BankAccount> accounts) {
		if (accounts.isEmpty()) {
			System.out.println("No accounts. Please create an account ");
			return;
		}
		
		System.out.println("Options");
		
		for (BankAccount account : accounts) {
			System.out.println(account.getAccountNumber());
		}
		
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		
		accounts.remove(option - 1);
	}
	
	public static void deposit(List<BankAccount> accounts) {
		if (accounts.isEmpty()) {
			System.out.println("No accounts. Please create an account ");
			return;
		}
		
		System.out.println("Options");
		
		for (BankAccount account : accounts) {
			System.out.println(account.getAccountNumber());
		}	
		
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		
		System.out.println("Enter amount to be deposited");
		
		int amount = sc.nextInt();
		
		accounts.get(option - 1).deposit(amount);
		
	}
	
	public static void withdraw(List<BankAccount> accounts) {
		if (accounts.isEmpty()) {
			System.out.println("No accounts. Please create an account ");
			return;
		}
		
		System.out.println("Options");
		
		for (BankAccount account : accounts) {
			System.out.println(account.getAccountNumber());
		}	
		
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		
		System.out.println("Enter amount to be withdrawed");
		
		int amount = sc.nextInt();
		
		accounts.get(option - 1).withdraw(amount);
		
	}
	
	public static void checkBalance(List<BankAccount> accounts) {
		System.out.println("Options");
		
		if (accounts.isEmpty()) {
			System.out.println("naw jit trippin");
			return;
		}
		
		for (BankAccount account : accounts) {
			System.out.println(account.getAccountNumber());
		}	
		
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();	
		
		System.out.println(accounts.get(option - 1).getBalance());
		
	}

}
