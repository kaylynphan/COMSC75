/*
 * The Shirt object extends from Clothing and also has a size property (string)
 * Write getters and setters for size and calculate price based on size
 * 
 * Kaylyn Phan
 * 17 Dec 2019
 */

package finalProgram;

public class Shirt extends Clothing {
	
	private String size;
	
	public Shirt() {
		size = "";
	}
	
	public Shirt(int quantity, String color, String size) {
		super(quantity, color);
		this.size = size;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public double calculatePrice() {
		double price = 0;
		if (size.contentEquals("S")) {
			price = 11.00;
		} 
		if (size.contentEquals("M")) {
			price = 12.50;
		} 
		if (size.contentEquals("L")) {
			price = 15.00;
		} 
		if (size.contentEquals("XL")) {
			price = 16.50;
		} 
		if (size.contentEquals("XXL")) {
			price = 18.50;
		} 
		return price;
	}
}
