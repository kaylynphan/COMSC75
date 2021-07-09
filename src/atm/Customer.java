package atm;
/* read account.dat, build an ArrayList of each line
 * given an accountNumber, return the index of the account
 * greet customer and ask if they want to deposit, withdraw, or finish
 * 
 * Kaylyn Phan
 * 10 December 2019
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.lang.NumberFormatException;
import java.io.FileNotFoundException;

public class Customer {
	
	public static void showBalance(Account acct) {
		System.out.printf("Your current balance is $%.2f\n", acct.getBalance());
	}

	public static void doDeposit(Account acct, String s) {
		try {
			double amount = Double.parseDouble(s);
			if (amount < 0) {
				System.out.println("You cannot deposit a negative amount.");
			} else {
				acct.deposit(amount);
				showBalance(acct);
			}
		}
		catch (NumberFormatException ex) {
			System.out.println("Invalid deposit amount. ");
		}
	}
	
	public static void doWithdrawal(Account acct, String s) {
		try {
			double amount = Double.parseDouble(s);
			if (amount < 0) {
				System.out.println("You cannot withdraw a negative amount.");
			} else if (amount > acct.getBalance()) {
				System.out.println("Withdraw amount is greater than available balance.");
			} else {
				acct.withdraw(amount);
				showBalance(acct);	
			}
		}
		catch (NumberFormatException ex) {
			System.out.println("Invalid withdrawal amount. ");
		}
	}
	
	public static ArrayList<Account> readAccounts(Scanner fileInput) {
		ArrayList<Account> accountList = new ArrayList<>();
		try {
			while (fileInput.hasNext()) {
				String oneLine = fileInput.nextLine();
				//System.out.println("Processing: " + oneLine);
				String[] items = oneLine.split(":");
				int acctNumber = Integer.parseInt(items[0]);
				String name = items[1];
				double balance = Double.parseDouble(items[2]);
				accountList.add(new Account(acctNumber, name, balance));
			}
			fileInput.close();
		}
		catch (NumberFormatException ex) {
			System.out.println("Invalid number. " + ex.getMessage());
			accountList = new ArrayList<>();
		}
		return accountList;
	}
	
	public static void writeAccounts(ArrayList<Account> accountList) {
		try{ 
			PrintWriter output = new PrintWriter("accounts.dat");
			for (Account acct: accountList) {
				output.println(acct.toString());
			}
			output.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static int findIndex(ArrayList<Account> accountList, int accountNumber) {
		int result = -1;
		for (Account acct: accountList) {
			if (acct.getAcctNumber() == accountNumber) {
				result = accountList.indexOf(acct);
			}	
		}
		return result;
	}
	
	public static int getAccountIndex(ArrayList<Account> accountList, String s) {
		int index = -1;
		try {
			int acctNumber = Integer.parseInt(s);
			index = findIndex(accountList, acctNumber);
		}
		catch (NumberFormatException ex) {
			System.out.println(s + " is not a number. ");
		}
		return index;
	}
	
	public static void doTransactions(Account acct, Scanner input) {
		System.out.print("D)eposit, W)ithdraw, or F)inish? ");
		String response = input.nextLine().toLowerCase();
		while (!response.contentEquals("f")) {
			switch (response) {
				case "d":
					System.out.print("Enter amount to deposit: $");
					doDeposit(acct, input.nextLine());
					break;
				case "w":
					System.out.print("Enter amount to withdraw: $");
					doWithdrawal(acct, input.nextLine());
					break;
				default:
					System.out.println(response + " is not a valid command.");
					break;	
			}
			System.out.print("D)eposit, W)ithdraw, or F)inish? ");
			response = input.nextLine().toLowerCase();	
		}
	}
	
	public static void main(String[] args) {
		File OpenFile = new File ("accounts.dat");
		try {
			Scanner inputFile = new Scanner(OpenFile);
			ArrayList<Account> accountList = readAccounts(inputFile);
			if (accountList.size() > 0) {
				Scanner input = new Scanner(System.in);
				System.out.print("Enter your account number: ");
				String response = input.nextLine();
				while (!response.contentEquals("")) {
					int index = getAccountIndex(accountList, response);
					if (index != -1) {
						Account customerAccount = accountList.get(index);
						System.out.println("Hello, " + customerAccount.getName() + "!");
						showBalance(customerAccount);
						doTransactions(customerAccount, input);
						writeAccounts(accountList);
						System.out.println("Goodbye, " + customerAccount.getName() + "!\n");
					} else {
						System.out.println("Account could not be found.");
					}
					System.out.print("Enter your account number: ");
					response = input.nextLine();
				}
				System.out.println("ATM program concludes.");	
			}
			
		}
		catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}	
	}
}
