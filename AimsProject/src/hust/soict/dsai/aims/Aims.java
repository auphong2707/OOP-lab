package hust.soict.dsai.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class Aims {
	private static Cart cart = new Cart();
	private static Store store = new Store();
	private static Scanner scanner = new Scanner(System.in);
	private static Runnable lastRunnable;
	
	private static String getAttribute(String thing) {
		System.out.print(thing + ": ");
		return scanner.nextLine();
	}
	
	public static int makeChoice(int numberOfChoices) {
		int command = 0;
		while(true) {
			command = Integer.parseInt(scanner.nextLine());
			if (command >= 0 && command < numberOfChoices) break;
			else System.out.println("Invalid");
		}
		return command;
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		
		Runnable[] choices = new Runnable[] {
				()-> System.exit(0),
				Aims::storeMenu,
				Aims::updateStore,
				Aims::cartMenu
		};
		
		int command = makeChoice(4);
		lastRunnable = Aims::showMenu;
		choices[command].run();
	}
	
	public static void updateStore() {
		store.print();
		
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add media to store");
		System.out.println("2. Remove media from store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		int command = makeChoice(3);
		
		if (command == 0) lastRunnable.run();
		else if (command == 1) {
			System.out.println("0 - Book or 1 - CD or 2 - DVD");
			command = makeChoice(3);
			
			if (command == 0) {
				String title = getAttribute("Title");
				String category = getAttribute("Category");
				float cost = Float.parseFloat(getAttribute("Cost"));
				
				store.addMedia(new Book(title, category, cost));
			}
			else if(command == 1) {
				String title = getAttribute("Title");
				String category = getAttribute("Category");
				String director = getAttribute("Director");
				int length = Integer.parseInt(getAttribute("Length"));
				float cost = Float.parseFloat(getAttribute("Cost"));
				String artist = getAttribute("Artist");
				
				int nbTrack = Integer.parseInt(getAttribute("Number of tracks"));
				List<Track> tracks = new ArrayList<Track>();
				for(int i = 0; i <= nbTrack; ++i) {
					String trackTitle = getAttribute("Track " + i + " title");
					int trackLength = Integer.parseInt(getAttribute("Track " + i + " length"));
					tracks.add(new Track(trackTitle, trackLength));
				}
				
				store.addMedia(new CompactDisc(title, category, director, length, cost, artist, tracks));
			}
			else if(command == 2) {
				System.out.println("0: title");
				System.out.println("1: title, category, cost");
				System.out.println("2: title, category, director, cost");
				System.out.println("3: title, category, director, length, cost");
				command = makeChoice(4);
				
				String title = getAttribute("Title");
				if (command == 0) store.addMedia(new DigitalVideoDisc(title));
				else {
					String category = getAttribute("Category");
					float cost = Float.parseFloat(getAttribute("Cost"));
					if (command == 1) store.addMedia(new DigitalVideoDisc(title, category, cost));
					else {
						String director = getAttribute("Director");
						if(command == 2) store.addMedia(new DigitalVideoDisc(title, category, director, cost));
						else {
							int length = Integer.parseInt(getAttribute("Length"));
							store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
						}
					}
				}
			}
			
		}
		else if (command == 2) {
			System.out.println("0 - By title or 1 - By ID");
			command = makeChoice(2);
			if(command == 0) {
				System.out.print("Title: ");
				String title = scanner.nextLine();
				Media media = store.search(title);
				if(media != null) store.removeMedia(media);
			}
			else if (command == 1) {
				System.out.println("ID: ");
				int id = scanner.nextInt();
				Media media = store.search(id);
				if(media != null) store.removeMedia(media);
			}
		}
		
		updateStore();
	}
	
	public static void storeMenu() {
		store.print();
		
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		
		int command = makeChoice(5);
	
		if (command == 4) {
			lastRunnable = Aims::storeMenu;
			cartMenu();
		}
		else if (command == 0) showMenu();
		else {
			Media chosenMedia = null;
			while(true) {
				System.out.print("Title: ");
				String title = scanner.nextLine();
				
				chosenMedia = store.search(title);
				if(chosenMedia != null) break;
				else System.out.println("Invalid");
			}
			
			if (command == 1) mediaDetailsMenu(chosenMedia);
			else if(command == 2) cart.addMedia(chosenMedia);
			else if(command == 3) {
				if(chosenMedia instanceof Playable) ((Playable) chosenMedia).play();
				else System.out.println("Can't play this media");
			}
			
			storeMenu();
		}
	}
	
	public static void mediaDetailsMenu(Media media) {
		while(true) {
			System.out.println(media);
			System.out.println();
			
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number 0-1-2");
			
			int command = makeChoice(3);
			
			if (command == 1) cart.addMedia(media);
			else if(command == 2) {
				if(media instanceof Playable) ((Playable) media).play();
				else System.out.println("Can't play this media");
			}
			else storeMenu();
		}
	}
	
	public static void cartMenu() {
		cart.print();
		
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		
		int command = makeChoice(6);
		
		if (command == 0) lastRunnable.run();
		else if (command == 1) {
			System.out.println("[0 - By ID] or [1 - By title]");
			command = makeChoice(2);
			if(command == 0) {
				System.out.println("ID: ");
				int id = scanner.nextInt();
				cart.search(id);
			}
			else {
				System.out.println("Title: ");
				String title = scanner.nextLine();
				cart.search(title);
			}
		}
		else if (command == 2) {
			System.out.println("[0 - By title] or [1 - By cost]");
			command = makeChoice(2);
			if (command == 0) cart.sortCart(command);
		}
		else if (command == 3) {
			System.out.print("Title: ");
			String title = scanner.nextLine();
			
			Media chosenMedia = cart.search(title);
			if(chosenMedia != null) cart.removeMedia(chosenMedia);
		}
		else if (command == 4) {
			System.out.print("Title: ");
			String title = scanner.nextLine();
			
			Media chosenMedia = cart.search(title);
			if(chosenMedia instanceof Playable) ((Playable) chosenMedia).play();
			else System.out.println("Can't play this media");
		}
		else if (command == 5){
			System.out.println("Your order is placed");
			cart.emptyCart();
		}
		
		cartMenu();
	}
	
	public static void main(String[] args) {
		store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
		store.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f));
		store.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));
		showMenu();
	}
}
