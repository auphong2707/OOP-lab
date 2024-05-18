package hust.soict.dsai.aims.media;

import java.util.Objects;

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
	public void play() {
		System.out.println("Playing DVD: " + this.title);
		System.out.println("DVD length: " + this.length);
	}
}
