/*
 * Create an array of Clothing objects, and print:
 * total quantity and cost of shirts
 * total quantity and cost of pants
 * Average waist and inseam of the pants
 * 
 * Kaylyn Phan
 * 17 Dec 2019
 */

package finalProgram;

public class Orders {
	
	public static int shirtQuantity(Clothing[] list) {
		int shirtQuantity = 0;
		for(int i = 0; i < list.length; i++) {
			if (list[i] instanceof Shirt) {
				shirtQuantity += list[i].getQuantity();
			}
		}
		return shirtQuantity;
	}
	
	public static double shirtTotalCost(Clothing[] list) {
		double shirtCost = 0;
		for(int i = 0; i < list.length; i++) {
			if (list[i] instanceof Shirt) {
				shirtCost += list[i].calculatePrice() * list[i].getQuantity();
			}
		}
		return shirtCost;
	}
	
	public static int pantsQuantity(Clothing[] list) {
		int pantsQuantity = 0;
		for(int i = 0; i < list.length; i++) {
			if (list[i] instanceof Pants) {
				pantsQuantity += list[i].getQuantity();
			}
		}
		return pantsQuantity;
	}
	
	public static double pantsTotalCost(Clothing[] list) {
		double pantsCost = 0;
		for(int i = 0; i < list.length; i++) {
			if (list[i] instanceof Pants) {
				pantsCost += list[i].calculatePrice() * list[i].getQuantity();
			}
		}
		return pantsCost;
	}
	
	public static double averageWaist(Clothing[] list) {
		double totalWaist = 0;
		for(int i = 0; i < list.length; i++) {
			if (list[i] instanceof Pants) {
				totalWaist += ((Pants) list[i]).getWaist() * list[i].getQuantity();
			}
		}
		return totalWaist / pantsQuantity(list);
	}
	
	public static double averageInseam(Clothing[] list) {
		double totalInseam = 0;
		for(int i = 0; i < list.length; i++) {
			if (list[i] instanceof Pants) {
				totalInseam += ((Pants) list[i]).getInseam() * list[i].getQuantity();
			}
		}
		return totalInseam / pantsQuantity(list);
	}
	
	public static void main(String[] args) {
		Clothing[] items = {
				new Shirt(8, "green", "XXL"),
				new Pants(7, "brown", 48, 30),
				new Shirt(2, "white", "M"),
				new Pants(4, "blue", 36, 34),
				new Pants(3, "black", 32, 31),
				new Shirt(5, "purple", "L")
		};	
				
		System.out.printf("Total number of shirts ordered: %d\n", shirtQuantity(items));
		System.out.printf("Total purchase price of shirts: $%.2f\n", shirtTotalCost(items));
		System.out.printf("Total number of pants ordered: %d\n", pantsQuantity(items));
		System.out.printf("Total purchase price of pants: $%.2f\n", pantsTotalCost(items));
		System.out.printf("Average waist size: %.1f\n", averageWaist(items));
		System.out.printf("Average inseam length: %.1f\n", averageInseam(items));		
	}
}
