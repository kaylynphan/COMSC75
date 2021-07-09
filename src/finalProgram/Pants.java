/*
 * The Pants object extends from Clothing and also has properties waist and inseam
 * Write getters and setters for both properties and calculate price using waist and inseam
 * 
 * Kaylyn Phan
 * 17 Dec 2019
 */

package finalProgram;

public class Pants extends Clothing {
	private int waist;
	private int inseam;
	
	public Pants() {
		this.waist = 0;
		this.inseam = 0;
	}
	
	public Pants(int quantity, String color, int waist, int inseam) {
		super(quantity, color);
		this.waist = Math.abs(waist);
		this.inseam = Math.abs(inseam);
	}
	
	public int getWaist() {
		return waist;
	}
	
	public void setWaist(int waist) {
		this.waist = waist;
	}
	
	public int getInseam() {
		return inseam;
	}
	
	public void setInseam(int inseam) {
		this.inseam = inseam;
	}
	
	@Override
	public double calculatePrice() {
		double price = 50.00;
		if (waist > 46 || inseam > 36) {
			price = 65.50;
		}
		return price;
	}
}
