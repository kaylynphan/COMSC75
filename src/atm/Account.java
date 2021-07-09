package atm;
/* The account object has:
 * - acctNumber: int
 * - name: String
 * - balance: double
 * 
 * it has a constructor, a toString() method, and methods to deposit and withdraw
 * 
 * Kaylyn Phan
 * 10 December 2019
 */
public class Account {
	
	private int acctNumber;
	private String name;
	private double balance;
	
	public Account(int acctNumber, String name, double balance) {
		this.acctNumber = acctNumber;
		this.name = name;
		this.balance = balance;
	}
	
	public int getAcctNumber() {
		return acctNumber;
	}
	
	public String getName() {
		return name;
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
		if (amount >= 0 && amount <= balance) {
			balance = balance - amount;
		}
	}
	
	public String toString() {
		return acctNumber + ":" + name + ":" + balance;
	}

}
