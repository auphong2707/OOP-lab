package hust.soict.dsai.lab01;

import java.util.Scanner;

public class MatrixSum {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter size of the matrix: ");
		int n = sc.nextInt(), m = sc.nextInt();
		
		System.out.println("Enter the first matrix:");
		double[][] arr1 = new double[n][m];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				arr1[i][j] = sc.nextDouble();
			}
		}
		
		System.out.println("Enter the second matrix:");
		double[][] arr2 = new double[n][m];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				arr2[i][j] = sc.nextDouble();
			}
		}
		
		
		double[][] arrRes = new double[n][m];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < m; j++)
			{
				arrRes[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
		
		System.out.println("The result matrix is:");
		for(double[] row : arrRes)
		{
			for(double element : row)
			{
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}
}
