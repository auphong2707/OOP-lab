package hust.soict.dsai.lab01;

import java.util.Scanner;

public class EquationSolver {
	static final Scanner scan = new Scanner(System.in);
	static final double ep = 1e-5;
	
	private static boolean isZero(double value)
	{
		return Math.abs(value) < ep;
	}
	
	public static void solveFirstDegreeEquation(double a, double b)
	{	
		if (a == 0)
		{
			if (b == 0)
				System.out.println("The equation has infinite solutions");
			else
				System.out.println("The equation has no solution");
				
		}
		else
		{
			double solution = -b / a;
			System.out.println(String.format("The solution of the equation is: %f", solution));
		}
	}
	
	public static void solveSystemOfFirstEquation(double a11, double a12, double b1, double a21, double a22, double b2)
	{
		double d = a11 * a22 - a12 * a21;
		double dx = b1 * a22 - a12 * b2;
		double dy =  a11 * b2 - b1 * a21;
		
		if (isZero(d))
		{
			if (isZero(dx) || isZero(dy))
			{
				System.out.println("The system has infinite solutions");
			}
			else
			{
				System.out.println("The system has no solution");
			}
		}
		else
		{
			double x1 = dx / d;
			double x2 = dy / d;
			System.out.println(String.format("The solution of the system are: x1 = %f, x2 = %f", x1, x2));
		}
		
	}
	
	public static void solveSecondDegreeEquation(double a, double b, double c)
	{
		if (a == 0)
		{
			solveFirstDegreeEquation(b, c);
		}
		else
		{
			double delta = b * b - 4 * a * c;
			if (delta < 0)
			{
				System.out.println("The equation has no solution");
			}
			else if (delta == 0)
			{
				double solution = -b / (2 * a);
				System.out.println(String.format("The equation has 1 solution: %f", solution));
			}
			else
			{
				double solution1 = (-b  + Math.sqrt(delta)) / (2 * a);
				double solution2 = (-b - Math.sqrt(delta)) / (2 * a);
				
				System.out.println(String.format("The equation has 2 solution: %f and %f", solution1, solution2));
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Enter type of the equations \n"
				+ " (1 - First-degree equation)"
				+ " (2 - System of first degree equation)"
				+ " (3 - Second-degree equation)");
		
		int type = scan.nextInt();
		
		if (type == 1) {
			// Input
			System.out.println("Enter coefficients (a, b):");
			double a = Double.parseDouble(scan.next());
			double b = Double.parseDouble(scan.next());
			
			// Solve
			solveFirstDegreeEquation(a, b);
		}
		else if (type == 2)
		{
			System.out.println("Enter coefficients (a11, a12, b1, a21, a22, b2):");
			double a11 = Double.parseDouble(scan.next());
			double a12 = Double.parseDouble(scan.next());
			double b1 = Double.parseDouble(scan.next());
			double a21 = Double.parseDouble(scan.next());
			double a22 = Double.parseDouble(scan.next());
			double b2 = Double.parseDouble(scan.next());
			
			solveSystemOfFirstEquation(a11, a12, b1, a21, a22, b2);
		}
		else if (type == 3)
		{
			// Input
			System.out.println("Enter coefficients (a, b, c):");
			double a = Double.parseDouble(scan.next());
			double b = Double.parseDouble(scan.next());
			double c = Double.parseDouble(scan.next());
			
			solveSecondDegreeEquation(a, b, c);
				
		}
		else
		{
			System.out.println("Invalid type");
		}
	}
}
