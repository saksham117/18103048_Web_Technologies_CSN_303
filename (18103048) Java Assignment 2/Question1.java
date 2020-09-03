import java.io.*;
import java.util.*;

public class Question1{

	public static void compare(String str1, String str2)
	{
		for(int i = 0; i < str1.length() && i < str2.length(); i++)
		{	
			// if both have same characters
			if( (int)str1.charAt(i) == (int)str2.charAt(i) )
			{
				continue;
			}
			else if((int)str1.charAt(i) < (int)str2.charAt(i)) // if unicode of character in string1 is smaller than unicode of character in string2
			{
				System.out.println("String 1: " + str1 + " appears before String 2: " + str2 + " in lexicographic order.");
				return;
			}
			else // if unicode of character in string2 is smaller than unicode of character in string1
			{
				System.out.println("String 2: " + str2 + " appears before String 1: " + str1 + " in lexicographic order.");
				return;
			}
		}

		if(str1.length() < str2.length())// if length of string1 is smaller than string2
		{
			System.out.println("String 1: " + str1 + " appears before String 2: " + str2 + " in lexicographic order.");
			return;
		}
		else if(str1.length() > str2.length())// if length of string2 is smaller than string1
		{
			System.out.println("String 2: " + str2 + " appears before String 1: " + str1 + " in lexicographic order.");
			return;
		}

		System.out.println("Both strings are equal to each other.");
	}

	public static void main(String []args)
	{
		Scanner sc = new Scanner(System.in);
		// input the first string from the user
		System.out.print("Enter the first string: ");
		String str1 = sc.nextLine();
		// input the second string from the user
		System.out.print("Enter the second string: ");
		String str2 = sc.nextLine();

		System.out.println();
		// make a call to the function compare
		compare(str1,str2);
	}
}
