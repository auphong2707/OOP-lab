package hust.soict.dsai.aims.media;

import java.util.Objects;

public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	private int length;
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(nbMedia++, title, category, director, length, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this(title, category, director, 0, cost);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		this(title, category, null, 0, cost);
	}
	
	public DigitalVideoDisc(String title) {
		this(title, null, null, 0, 0.0f);
	}
	
	
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCategory(), getCost(), director, length, getTitle());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DigitalVideoDisc other = (DigitalVideoDisc) obj;
		return Objects.equals(getCategory(), other.getCategory())
				&& Float.floatToIntBits(getCost()) == Float.floatToIntBits(other.getCost())
				&& Objects.equals(director, other.director) && length == other.length
				&& Objects.equals(getTitle(), other.getTitle());
	}

	@Override
	public String toString() {
		return "DVD " + " - ID: " + getId() + " - Title: " + getTitle() + " - Category: " + getCategory() + " - Director: " 
				+ director + " - Length: " + length + ": " + getCost() + " $";
	}
	
	public boolean isMatching(String title) {
		return this.getTitle().equals(title);
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
}
