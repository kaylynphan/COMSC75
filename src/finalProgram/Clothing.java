/*
 * The Clothing object has the properties: quantity (int), color (string)
 * Write getters and setters for both properties and a method calculatePrice() that returns zero.
 * 
 * Kaylyn Phan
 * 17 Dec 2019
 */

package finalProgram;

public class Clothing {
		
	private int quantity;
	private String color;
		
	public Clothing() {
		quantity = 0;
		color = "";
	}
		
	public Clothing(int quantity, String color) {
		this.quantity = Math.abs(quantity);
		this.color = color;
	}
		
	public int getQuantity() {
		return quantity;
	}
		
	public void setQuantity(int quantity) {
		this.quantity = Math.abs(quantity);
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double calculatePrice() {
		return 0.0;
	}
}
