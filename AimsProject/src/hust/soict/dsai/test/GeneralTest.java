package hust.soict.dsai.test;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class GeneralTest {
	public static void main(String[] args) {
		List<Track> testTracks = new ArrayList<Track>();
		Track track1 = new Track("Monster", 3);
		Track track2 = new Track("Idol", 4);
		Track track3 = new Track("Heart Beat", 6);
		testTracks.add(track1);
		testTracks.add(track2);
		testTracks.add(track3);
		
		CompactDisc cd = new CompactDisc(0, "Test CD", "Pop", "Yoasobi", 3, 5, "Yoasobi", testTracks);
		DigitalVideoDisc dvd = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
		Book book = new Book(0, "Book 1", "Pop", 15);
		
		List<Media> mediae = new ArrayList<Media>();
		
		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);
		
		for(Media m : mediae) {
			System.out.println(m.toString());
			System.out.println("------------------------------------------------------------");
		}
	}

}
