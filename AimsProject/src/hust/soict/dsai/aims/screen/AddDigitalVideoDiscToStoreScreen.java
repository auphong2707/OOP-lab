package hust.soict.dsai.aims.screen;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen{

	static {
		TITLE = "Add Digital Video Disc";
		WIDTH = 410;
		HEIGHT = 230;
	}
	
	JPanel titleField;
	JPanel categoryField;
	JPanel directorField;
	JPanel lengthField;
	JPanel costField;
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
	}

	@Override
	JPanel buildCenter() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		titleField = inputField("Title");
		categoryField = inputField("Category");
		directorField = inputField("Director");
		lengthField = inputField("Length");
		costField = inputField("Cost");
		
		panel.add(titleField);
		panel.add(categoryField);
		panel.add(directorField);
		panel.add(lengthField);
		panel.add(costField);
		
		return panel;
	}

	@Override
	Media inputMedia() {
		DigitalVideoDisc inputMedia = null;
		
		String title = getContentFromPanel(titleField);
		String category = getContentFromPanel(categoryField);
		String director = getContentFromPanel(directorField);
		String length = getContentFromPanel(lengthField);
		String cost = getContentFromPanel(costField);
		
		if(!title.equals("")) {
			if (!category.equals("") && !cost.equals("")) {
				if(!director.equals("")) {
					if(!length.equals("")) 
						inputMedia = new DigitalVideoDisc(title, category, director, 
								Integer.parseInt(length), Float.parseFloat(cost));
					else
						inputMedia = new DigitalVideoDisc(title, category, director, Float.parseFloat(cost));
				}
				else inputMedia = new DigitalVideoDisc(title, category, Float.parseFloat(cost));
			}
			else inputMedia = new DigitalVideoDisc(title);
		}
		
		return inputMedia;
	}

	public static void main(String[] args) {
		Store store = new Store();
		new AddDigitalVideoDiscToStoreScreen(store);
	}
}
