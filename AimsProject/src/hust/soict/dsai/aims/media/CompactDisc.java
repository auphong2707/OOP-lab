package hust.soict.dsai.aims.media;

import java.util.Iterator;
import java.util.List;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{

	private String artist;
	private List<Track> tracks;
	
	public CompactDisc(String title, String category, String director, int length, float cost, String artist,
			List<Track> tracks) {
		super(nbMedia++, title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
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

	@Override
	public String play() throws PlayerException{
		if(this.getLength() > 0) {
			StringBuilder resBuilder = new StringBuilder();
			
			for(int i = 0; i < tracks.size(); ++i) {
				resBuilder.append("Track " + i + ": " + '\n');
				try {
					resBuilder.append(tracks.get(i).play());
				} catch(PlayerException e) {
					throw e;
				}
			}
			
			return resBuilder.toString();
		} else {
			throw new PlayerException("ERROR: CD length is non-positive!");
		}
		
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("CD - " + "ID: " + getId() + " - Title: " + getTitle() + " - Category: " + getCategory() + ": " + getCost() + " $");
		
		for(Track track : tracks) {
			sb.append("\n\t" + track.toString());
		}
		
		return sb.toString();
	}
	
	
}
