/*
 * The CreditCardAccount has everything an Account has plus:
 * an annual interest rate (apr)
 * a credit limit
 * 
 * Override the withdraw method to allow negative balances
 * Add a method to calculate monthly payment using balance and apr
 * Override toString to display all properties
 * 
 * Kaylyn Phan
 * 27 Nov 2019
 * 
 */

package inheritanceAndPolymorphism;

public class CreditCardAccount extends Account {
	
	private double apr;
	private double creditLimit;
	
	public CreditCardAccount(long number, double balance, double apr, double creditLimit) {
		super(number, balance);
		this.apr = apr;
		this.creditLimit = creditLimit;
	}
	
	public CreditCardAccount() {
		this(0, 0.0, 0.0, 0.0);
	}
	
	public double getApr() {
		return apr;
	}
	
	public void setApr(double apr) {
		this.apr = apr;
	}
	
	public double getCreditLimit() {
		return creditLimit;
	}
		
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount <= getBalance() + creditLimit) {
			setBalance(getBalance() - amount);
		}
	}
	
	public double calculatePayment() {
		double payment = 0.0;
		if (getBalance() < 0) {
			payment = Math.min(20.0, apr * getBalance() * -1 /  12.0);
		}
		return payment;
	}
	
	@Override
	public String toString() {
		String result = String.format(super.toString() + "Interest Rate: %.2f%%\nCredit Limit: $%.2f\nMonthly Payment: $%.2f\n",
				 apr * 100, creditLimit, calculatePayment());
		return result;
	}


}
