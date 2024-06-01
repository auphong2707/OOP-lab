package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.StoreScreen;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		
		//store.addMedia(new DigitalVideoDisc("Mashle"));
		//store.addMedia(new DigitalVideoDisc("Re:zero"));
		//store.addMedia(new DigitalVideoDisc("AoT"));
		//store.addMedia(new DigitalVideoDisc("Naruto"));
		//store.addMedia(new DigitalVideoDisc("Boruto"));
		//store.addMedia(new DigitalVideoDisc("Jujutsu Kaisen"));
		//store.addMedia(new DigitalVideoDisc("Dungeon Meshi"));
		//store.addMedia(new DigitalVideoDisc("Honkai"));
		//store.addMedia(new Book("Genshin", "Action", 12));
		//store.addMedia(new DigitalVideoDisc("Mashle 2"));
		
		new StoreScreen(store, cart);
	}
}
