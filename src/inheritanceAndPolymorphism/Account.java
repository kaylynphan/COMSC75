/*
 * Create a class that describes an Account that has an account and balance.
 * Add getters for both account # and balance but only balance can be changed.
 * Include a method to deposit, withdraw, and a toString method.
 * 
 * Kaylyn Phan
 * 27 Nov 2019
 * 
 */

package inheritanceAndPolymorphism;

public class Account {
	
	private long number;
	private double balance;
	
	public Account() {
		number = 0L;
		balance = 0.0;
	}
	
	public Account(long number, double balance) {
		this.number = number;
		this.balance = balance;
	}
	
	public long getNumber() {
		return number;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		if (amount >= 0) {
			balance = balance + amount;
		}
	}
	
	public void withdraw(double amount) {
		if (amount >= 0 && amount < balance);
			balance = balance - amount;
	}
	
	public String toString() {
		String result = String.format("Account number: %d\nBalance: $%.2f\n", number, balance);
		return result;
	}
}
