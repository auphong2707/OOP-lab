package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is almost full" );
			return;
		}
		
		itemsOrdered.add(media);
		System.out.println("The item has been added");
	}
	
	public void addMedia(Media... mediaList) {
		for(Media media : mediaList) {
			addMedia(media);
		}
	}
	
	public void removeMedia(Media media) {
		if (!itemsOrdered.contains(media)) {
			System.out.println("The item is not in the cart");
			return;
		}
		
		itemsOrdered.remove(media);
		System.out.println("The item has been removed successfully");
	}
	
	public float totalCost() {
		float result = 0f;
		for(Media item : itemsOrdered) {
			if (item == null) break;
			result += item.getCost();
		}
		
		return result;
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for(int i = 0; i < itemsOrdered.size(); ++i) {
			Media disc = itemsOrdered.get(i);
			System.out.println((i + 1) + ". " + disc);
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}
	
	public boolean search(int id) {
		for(int i = 0; i < itemsOrdered.size(); ++i) {
			Media disc = itemsOrdered.get(i);
			if(disc.getId() == id) {
				System.out.println("Found in cart: " + disc);
				return true;
			}
		}
		System.out.println("Not found!");
		return false;
	}
	
	public boolean search(String title) {
		for(int i = 0; i < itemsOrdered.size(); ++i) {
			Media disc = itemsOrdered.get(i);
			if(disc.getTitle().equals(title)) {
				System.out.println("Found in cart: " + disc);
				return true;
			}
		}
		System.out.println("Not found!");
		return false;
	}
}
