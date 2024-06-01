package hust.soict.dsai.aims.screen;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	static {
		TITLE = "Add Book";
		WIDTH = 410;
		HEIGHT = 180;
	}
	
	JPanel titleField;
	JPanel categoryField;
	JPanel costField;
	
	public AddBookToStoreScreen(Store store) {
		super(store);
	}

	@Override
	JPanel buildCenter() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		titleField = inputField("Title");
		categoryField = inputField("Category");
		costField = inputField("Cost");
		
		panel.add(titleField);
		panel.add(categoryField);
		panel.add(costField);
		
		return panel;
	}

	@Override
	Media inputMedia() {
		String title = getContentFromPanel(titleField);
		String category = getContentFromPanel(categoryField);
		float cost = Float.parseFloat(getContentFromPanel(costField));
		
		return new Book(title, category, cost);
	}

	
	public static void main(String[] args) {
		Store store = new Store();
		new AddBookToStoreScreen(store);
	}
}
