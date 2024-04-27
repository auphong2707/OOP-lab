package hust.soict.dsai.lab01;

import java.util.Scanner;

public class TriangleDisplay {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter number of row: n = ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int numberOfStars = 2*i + 1;
			int numberOfSpaces = 2*(n - 1) + 1 - numberOfStars;
			
			String line = " ".repeat(numberOfSpaces / 2) + "*".repeat(numberOfStars) + " ".repeat(numberOfSpaces / 2);
			System.out.println(line);
		}
	}
}
