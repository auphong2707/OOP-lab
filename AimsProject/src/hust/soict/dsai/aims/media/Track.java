package hust.soict.dsai.aims.media;

import java.util.Objects;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{

	private String title;
	private int length;
	
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "Track - " + "Title: " + title + " - Length: " + length;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Track other = (Track) obj;
		return length == other.length && Objects.equals(title, other.title);
	}

	@Override
	public String play() throws PlayerException{
		if (this.getLength() > 0) {
			StringBuilder resBuilder = new StringBuilder();
			resBuilder.append("Playing DVD: " + this.title + '\n');
			resBuilder.append("DVD length: " + this.length + '\n');
			
			return resBuilder.toString();
		} else {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
	}
}
