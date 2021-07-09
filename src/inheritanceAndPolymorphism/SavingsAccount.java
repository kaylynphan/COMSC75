/*
 * The SavingsAccount has everything an Account has plus:
 * an annual interest rate (apr)
 * 
 * Add a method to calculate interest based on balance and apr
 * Override toString to display apr
 * 
 * Kaylyn Phan
 * 27 Nov 2019
 * 
 */

package inheritanceAndPolymorphism;

public class SavingsAccount extends Account {
	
	private double apr;

	public SavingsAccount(long number, double balance, double apr) {
		super(number, balance);
		this.apr = apr;
	}
	
	public SavingsAccount() {
		this(0L, 0.0, 0.0);
	}
	
	
	public double getApr() {
		return apr;
	}
	
	public void setApr(double apr) {
		if (apr > 0) {
			this.apr = apr;
		}
	}
	
	public double calculateInterest() {
		return getBalance() * apr;
	}
	
	@Override
	public String toString() {
		String result = String.format(super.toString() + "Interest Rate: %.2f%%\nAnnual Interest: $%.2f\n",
				apr * 100, calculateInterest());
		return result;
	}
}

