package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
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
	
	public Media search(int id) {
		for(int i = 0; i < itemsOrdered.size(); ++i) {
			Media media = itemsOrdered.get(i);
			if(media.getId() == id) {
				System.out.println("Found in cart: " + media);
				return media;
			}
		}
		System.out.println("Not found!");
		return null;
	}
	
	public Media search(String title) {
		for(int i = 0; i < itemsOrdered.size(); ++i) {
			Media media = itemsOrdered.get(i);
			if(media.getTitle().equals(title)) {
				System.out.println("Found in cart: " + media);
				return media;
			}
		}
		System.out.println("Not found!");
		return null;
	}
	
	public void emptyCart() {
		itemsOrdered.clear();
	}
	
	public void sortCart(int choice) {
		if (choice == 0) {
			itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
			System.out.println("Cart sorted !!!");
		}
		else if (choice == 1) {
			itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
			System.out.println("Cart sorted!!!");
		}
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	@Override
	public String toString() {
		StringBuilder resBuilder = new StringBuilder();
		resBuilder.append("**********************************************\n");
		resBuilder.append("Ordered Items:\n");
		for(int i = 0; i < itemsOrdered.size(); ++i) {
			Media disc = itemsOrdered.get(i);
			resBuilder.append((i + 1) + ". " + disc + '\n');
		}
		resBuilder.append("Total cost: " + totalCost() + '\n');
		resBuilder.append("**********************************************\n");
		
		return resBuilder.toString();
	}
	
	
}
