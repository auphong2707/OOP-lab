package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame{
	private Cart cart;
	
	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					Scene rootScene = new Scene(root);
					
					fxPanel.setScene(rootScene);
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	public static void main(String[] args) {
		DigitalVideoDisc dvd = new DigitalVideoDisc("Jujutsu Kaisen");
		Book book = new Book("Gun and Chocolate", "Slice of Life", 12);
		
		List<Track> testTracks = new ArrayList<Track>();
		Track track1 = new Track("Monster", 3);
		Track track2 = new Track("Idol", 4);
		Track track3 = new Track("Heart Beat", 6);
		testTracks.add(track1);
		testTracks.add(track2);
		testTracks.add(track3);
		CompactDisc cd = new CompactDisc("Test CD", "Pop", "Yoasobi", 3, 5, "Yoasobi", testTracks);
		
		
		Cart cart = new Cart();
		cart.addMedia(dvd);
		cart.addMedia(book);
		cart.addMedia(cd);
		
		new CartScreen(cart);
	}
}
