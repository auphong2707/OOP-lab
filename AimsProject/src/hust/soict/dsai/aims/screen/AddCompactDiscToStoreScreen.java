package hust.soict.dsai.aims.screen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

	static {
		TITLE = "Add Compact Disc";
		WIDTH = 410;
		HEIGHT = 450;
	}
	
	private JPanel titleField;
	private JPanel categoryField;
	private JPanel directorField;
	private JPanel lengthField;
	private JPanel costField;
	private JPanel artistField;
	
	private JPanel[] trackTitleField;
	private JPanel[] trackLengthField;
	
	int nbTrack = 0;
	
	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}

	@Override
	JPanel buildCenter() {
		trackTitleField = new JPanel[3];
		trackLengthField = new JPanel[3];
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		titleField = inputField("Title");
		categoryField = inputField("Category");
		directorField = inputField("Director");
		lengthField = inputField("Length");
		costField = inputField("Cost");
		artistField = inputField("Artist");
		
		panel.add(titleField);
		panel.add(categoryField);
		panel.add(directorField);
		panel.add(lengthField);
		panel.add(costField);
		panel.add(artistField);
		
		for(int i = 0; i < 3; ++i)
		{
			panel.add(trackField(i));
		}
		
		return panel;
	}

	@Override
	Media inputMedia() {
		String title = getContentFromPanel(titleField);
		String category = getContentFromPanel(categoryField);
		String director = getContentFromPanel(directorField);
		int length = Integer.parseInt(getContentFromPanel(lengthField));
		float cost = Float.parseFloat(getContentFromPanel(costField));
		String artist = getContentFromPanel(artistField);
		
		List<Track> tracks = new ArrayList<Track>();
		for(int i = 0; i < 3; ++i) {
			String trackTitle = getContentFromPanel(trackTitleField[i]);
			String trackLength = getContentFromPanel(trackLengthField[i]);
			
			if(trackTitle.equals("") || trackLength.equals("")) continue;
			tracks.add(new Track(trackTitle, Integer.parseInt(trackLength)));
		}
		
		CompactDisc inputMedia = new CompactDisc(title, category, director, length, cost, artist, tracks);
		
		return inputMedia;
	}
	
	JPanel trackField(int i) {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel lb = new JLabel("Track " + i + ": ");
		
		trackTitleField[i] = inputField("Title");
		trackLengthField[i] = inputField("Length");
		panel.add(trackTitleField[i], BorderLayout.CENTER);
		panel.add(trackLengthField[i], BorderLayout.SOUTH);
		
		panel.add(lb, BorderLayout.NORTH);
		
		return panel;
	}
	
	public static void main(String[] args) {
		Store store = new Store();
		new AddCompactDiscToStoreScreen(store);
	}
}
