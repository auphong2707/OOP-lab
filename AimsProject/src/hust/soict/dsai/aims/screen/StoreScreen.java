package hust.soict.dsai.aims.screen;

import java.lang.Math;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

import javax.swing.BorderFactory;
import javax.swing.Box;

public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	
	public StoreScreen(Store store, Cart cart)
	{
		this.store = store;
		this.cart = cart;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
		
		setLocationRelativeTo(null);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(new JMenuItem("Add Book"));
		smUpdateStore.add(new JMenuItem("Add CD"));
		smUpdateStore.add(new JMenuItem("Add DVD"));
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for(int i = 0; i < Math.min(9, mediaInStore.size()); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));;
			center.add(cell);
		}
		
		return center;
	}
	
	public class MediaStore extends JPanel {
		private Media media;
		public MediaStore(Media media) {
			this.media = media;
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			
			JLabel title = new JLabel(media.getTitle());
			title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
			title.setAlignmentX(CENTER_ALIGNMENT);
			
			JLabel cost = new JLabel("" + media.getCost() + '$');
			cost.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.CENTER));
			
			JButton addToCartButton = new JButton("Add to Cart");
			AddToCartButtonListener addToCartListener = new AddToCartButtonListener(media);
			addToCartButton.addActionListener(addToCartListener);
			
			container.add(addToCartButton);
			if(media instanceof Playable) {
				JButton playButton = new JButton("Play");
				PlayButtonListener playButtonListener = new PlayButtonListener((Playable) media);
				
				playButton.addActionListener(playButtonListener);
				container.add(playButton);
			}
			
			this.add(Box.createVerticalGlue());
			this.add(title);
			this.add(cost);
			this.add(Box.createVerticalGlue());
			this.add(container);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
	}
	
	private class PlayButtonListener implements ActionListener {
		private Playable playableMedia;
		
		public PlayButtonListener(Playable playableMedia) {
			this.playableMedia = playableMedia;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog playDialog = new JDialog();
			playDialog.setSize(400, 200);
			playDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			playDialog.setLayout(new BorderLayout());
			playDialog.setLocationRelativeTo(null);
			
			String htmlText = "<html>" + playableMedia.play().replace("\n", "<br>") + "</html>";
			JLabel content = new JLabel(htmlText, SwingConstants.CENTER);
			content.setFont(content.getFont().deriveFont(content.getFont().getSize() + 5.0f));
			
			playDialog.add(content, BorderLayout.CENTER);
			System.out.println(playableMedia.play());
			
			playDialog.setVisible(true);
		}
	}
	
	private class AddToCartButtonListener implements ActionListener {
		private Media media;

		public AddToCartButtonListener(Media media) {
			this.media = media;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			cart.addMedia(media);
			JDialog addToCartDialog = new JDialog();
			addToCartDialog.setSize(400, 200);
			addToCartDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			addToCartDialog.setLayout(new BorderLayout());
			addToCartDialog.setLocationRelativeTo(null);
			
			JLabel content = new JLabel("Added " + media.getTitle() + " to cart!", SwingConstants.CENTER);
			content.setFont(content.getFont().deriveFont(content.getFont().getSize() + 5.0f));
			addToCartDialog.add(content, BorderLayout.CENTER);
			
			addToCartDialog.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		Cart cart = new Cart();
		
		store.addMedia(new DigitalVideoDisc("Mashle"));
		store.addMedia(new DigitalVideoDisc("Re:zero"));
		store.addMedia(new DigitalVideoDisc("AoT"));
		store.addMedia(new DigitalVideoDisc("Naruto"));
		store.addMedia(new DigitalVideoDisc("Boruto"));
		store.addMedia(new DigitalVideoDisc("Jujutsu Kaisen"));
		store.addMedia(new DigitalVideoDisc("Dungeon Meshi"));
		store.addMedia(new DigitalVideoDisc("Honkai"));
		store.addMedia(new Book("Genshin", "Action", 12));
		store.addMedia(new DigitalVideoDisc("Mashle 2"));
		
		new StoreScreen(store, cart);
	}
}
