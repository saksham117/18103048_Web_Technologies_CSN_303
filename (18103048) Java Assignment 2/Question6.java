import java.io.*;
import java.util.*;

public class Question6{

	public static void hailstone(int n)
	{	if(n == 1)
		{
			System.out.println(1);
			return;
		}

		System.out.print(n + " ");
		if(n%2 == 0)
		{
			hailstone(n/2);
		}
		else
		{
			long temp = 3 * (long)n + 1;
			if(temp > Integer.MAX_VALUE)
			{	
				System.out.println();
				System.out.println("Number on multiplication by 3 results in number going out of range of integer data type.");
				return;
			}
			else
			{
				hailstone(3*n + 1);
			}

		}
	}

	public static void main(String []args)
	{
		System.out.print("Enter a positive integer: ");

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if(n <= 0)
		{
			System.out.println("Please enter a positive integer.");
		}
		else
		{
			hailstone(n);
		}
	}
}