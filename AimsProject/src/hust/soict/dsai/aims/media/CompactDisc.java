package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc{

	private String artist;
	private List<Track> tracks;
	
	public CompactDisc(int id, String title, String category, String director, int length, float cost, String artist,
			List<Track> tracks) {
		super(id, title, category, director, length, cost);
		this.artist = artist;
		this.tracks = new ArrayList<Track>();
	}

	public String getArtist() {
		return artist;
	}
	
	public void addTrack(Track newTrack) {
		if (tracks.contains(newTrack)) {
			System.out.println("The track is already on the list");
		}
		else {
			tracks.add(newTrack);
			System.out.println("New track added successfully!");
		}
	}
	
	public void removeTrack(Track otherTrack) {
		if(!tracks.contains(otherTrack)) {
			System.out.println("The track is not on the list");
		}
		else {
			tracks.remove(otherTrack);
		}
	}
	
	@Override
	public int getLength() {
		int result = 0;
		for(Track track : tracks) {
			result += track.getLength();
		}
		
		return result;
	}
}
