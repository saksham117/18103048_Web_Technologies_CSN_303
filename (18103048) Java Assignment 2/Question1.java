import java.io.*;
import java.util.*;

public class Question1{

	public static void compare(String str1, String str2)
	{
		for(int i = 0; i < str1.length() && i < str2.length(); i++)
		{
			if( (int)str1.charAt(i) == (int)str2.charAt(i) )
			{
				continue;
			}
			else if((int)str1.charAt(i) < (int)str2.charAt(i))
			{
				System.out.println("String 1: " + str1 + " appears before String 2: " + str2 + " in lexicographic order.");
				return;
			}
			else
			{
				System.out.println("String 2: " + str2 + " appears before String 1: " + str1 + " in lexicographic order.");
				return;
			}
		}

		if(str1.length() < str2.length())
		{
			System.out.println("String 1: " + str1 + " appears before String 2: " + str2 + " in lexicographic order.");
			return;
		}
		else if(str1.length() > str2.length())
		{
			System.out.println("String 2: " + str2 + " appears before String 1: " + str1 + " in lexicographic order.");
			return;
		}

		System.out.println("Both strings are equal to each other.");
	}

	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the first string: ");
		String str1 = sc.nextLine();

		System.out.print("Enter the second string: ");
		String str2 = sc.nextLine();

		System.out.println();
		compare(str1,str2);
	}
}
