package hust.soict.dsai.lab01;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySolver {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.print("Enter number of elements of the array: ");
		int n = sc.nextInt();
		
		System.out.print("Enter the array: ");
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i)
		{
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		double average = 0, sum = 0;
		for(int i = 0; i < n; ++i)
		{
			sum += arr[i];
		}
		average = sum / n;
		
		System.out.print("Sorted array is: ");
		for(int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
		System.out.println();
		
		System.out.println("Sum of the array is: " + sum);
		System.out.println("Avarage of the array is: " + average);
	}
}
