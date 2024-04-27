package hust.soict.dsai.lab01;
	
import java.util.Scanner;

public class NumberOfMonthDisplayer {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static boolean isCheck(int year) 
	{
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		return false;
	}
	
	private static int getIndexOf(String[] s, String value)
	{
		for(int i = 0; i < s.length; i++)
		{
			if (value.equals(s[i]))
				return i;
		}
		
		return -1;
	}
	
	public static int strToMonth(String s)
	{
		String[] arr3 = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String[] arrNum = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		String[] arrAbb = new String[] {"Jan.", "Feb.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.", "Nov.", "Dec."};
		String[] arrFull = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		String[][] arrMonth = new String[][] {arr3, arrNum, arrAbb, arrFull};
		
		for(String[] arr : arrMonth)
		{
			int value = getIndexOf(arr, s) + 1;
			if (value == 0) continue;
			
			return value;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		int month, year;
		while(true)
		{
			System.out.print("Enter Month: ");
			String input = sc.next();
			
			month = strToMonth(input);
			if (month != 0) break;
			
			System.out.println("Invalid, please enter again!");
		}
		
		while(true)
		{
			System.out.print("Enter Year: ");
			
			try
			{
				year = Integer.parseInt(sc.next());
				if (year < 0)
					System.out.println("Invalid, please enter again!");
				else break;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid, please enter again!");
			}
		}
		
		int numberOfDay = -1;
		switch (month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numberOfDay = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numberOfDay = 30;
			break;
		case 2:
			if (isCheck(year))
				numberOfDay = 29;
			else
				numberOfDay = 28;
			break;
		default:
			System.out.println("Error");
			return;
		}
		
		System.out.println("Number of days is: " + numberOfDay);
	}
}
