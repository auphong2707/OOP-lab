package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	
	public float totalCost() {
		float result = 0f;
		for(DigitalVideoDisc item : itemsOrdered) {
			if (item == null) break;
			result += item.getCost();
		}
		
		return result;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < qtyOrdered; ++i) {
			DigitalVideoDisc disc = itemsOrdered[i];
			System.out.println((i + 1) + ". " + disc);
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public boolean search(int id) {
		for(int i = 0; i < qtyOrdered; ++i) {
			DigitalVideoDisc disc = itemsOrdered[i];
			if(disc.getId() == id) {
				System.out.println("Found in cart: " + disc);
				return true;
			}
		}
		System.out.println("Not found!");
		return false;
	}
	
	public boolean search(String title) {
		for(int i = 0; i < qtyOrdered; ++i) {
			DigitalVideoDisc disc = itemsOrdered[i];
			if(disc.isMatching(title)) {
				System.out.println("Found in cart: " + disc);
				return true;
			}
		}
		System.out.println("Not found!");
		return false;
	}
}
