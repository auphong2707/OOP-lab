package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
	
	private List<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if(itemsInStore.contains(media)) {
			System.out.println("The item is already in the Store!");
		}
		else {
			itemsInStore.add(media);
			System.out.println("Added successfully!");
		}
	}
	
	public void removeMedia(Media media) {
		if(!itemsInStore.contains(media)) {
			System.out.println("The item is not in the Store!");
		}
		else {
			itemsInStore.remove(media);
			System.out.println("Removed successfully!");
		}
	}
	
	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Store list:");
		for(int i = 0; i < qtyStore; ++i) {
			DigitalVideoDisc disc = itemsInStore[i];
			System.out.println((i + 1) + ". " + disc);
		}
		System.out.println("****************************************************");
	}
}
