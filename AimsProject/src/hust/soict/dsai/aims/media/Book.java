package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title, String category, float cost) {
		super(nbMedia++, title, category, cost);
		// TODO Auto-generated constructor stub
	}
	
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("Already contained");
		}
		else {
			authors.add(authorName);
			System.out.println("Added successfully!");
		}
	}
	
	public void removeAuthor(String anotherName) {
		if(!authors.contains(anotherName)) {
			System.out.println("There is no author " + anotherName + " in the list!");
		}
		else {
			authors.remove(anotherName);
			System.out.println("Removed successfully!");
		}
	}

	@Override
	public String toString() {
		return "Book" + " - Id: " + getId() + " - Title: " + getTitle() + " - Category: "
				+ getCategory() + ": " + getCost() + " $";
	}
	
}
