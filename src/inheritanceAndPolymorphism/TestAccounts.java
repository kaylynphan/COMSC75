/*
 * Test Accounts and its subclasses
 * 
 * Kaylyn Phan
 * 27 Nov 2019
 */

package inheritanceAndPolymorphism;

public class TestAccounts {

	public static void main(String[] args) {
		Account[] accounts = new Account[5];
		
		accounts[0] = new Account(1066, 7500.00);
		accounts[1] = new SavingsAccount(30507, 4500.00, 0.015);
		accounts[2] = new CreditCardAccount(51782737, 7000.00, 0.08, 1000.00);
		accounts[3] = new CreditCardAccount(629553328, 1500.00, 0.075, 5000.00);
		accounts[4] = new CreditCardAccount(4977201043L, -5000.00, 0.07, 10000.00);
		
		
		for (int i = 0; i < 5; i++) {
			accounts[i].deposit(2134.00);
			accounts[i].withdraw(4782.00);
			if (accounts[i] instanceof SavingsAccount) {
				System.out.print(((SavingsAccount) accounts[i]).toString());
			} else if (accounts[i] instanceof CreditCardAccount) {
				System.out.print(((CreditCardAccount) accounts[i]).toString());
			} else if (accounts[i] instanceof Account) {
				System.out.print(accounts[i].toString());
			}
			System.out.println();
		}

	}

}
