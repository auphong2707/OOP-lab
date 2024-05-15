package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;

public class Store {
	
	private List<Media> itemsInStore = new ArrayList<Media>();
	
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
