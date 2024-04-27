package hust.soict.dsai.lab01;

import java.util.Scanner;

public class DoubleCalculator {
	
	public final static double ep = 1e-9;
	
	public static boolean isZero(double value)
	{
		return Math.abs(value) < ep;
	}
	
	public static double sum(double firstValue, double secondValue)
	{
		return firstValue + secondValue;
	}
	
	public static double difference(double firstValue, double secondValue)
	{
		return firstValue - secondValue;
	}
	
	public static double product(double firstValue, double secondValue)
	{
		return firstValue * secondValue;
	}
	
	public static double quotient(double firstValue, double secondValue)
	{
		if (isZero(secondValue))
		{
			throw new ArithmeticException();
		}
		
		return firstValue / secondValue;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the first number: ");
		String strNum1 = sc.next();
		
		System.out.print("Enter the second number: ");
		String strNum2 = sc.next();
		
		System.out.println();
		
		sc.close();
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		System.out.println(String.format("Sum of the two numbers is: %f", sum(num1, num2)));
		System.out.println(String.format("Difference of the two numbers is: %f", difference(num1, num2)));
		System.out.println(String.format("Product of the two numbers is: %f", product(num1, num2)));
		
		try
		{
			System.out.println(String.format("Quotient of the two numbers is: %f", quotient(num1, num2)));
		}
		catch(ArithmeticException e)
		{
			System.out.println("The divisor is zero");
		}
		
	}
}
