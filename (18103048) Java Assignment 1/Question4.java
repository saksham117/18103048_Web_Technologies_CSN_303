// for taking user defuned input
import java.util.Scanner;

import java.io.*; 
import java.util.*;

public class Question4{

	static boolean areAnagram(char  s1 [], char s2[])
	{	
		// assuming all characters lie in this range
		int count[] = new int[256];

		for (int i = 0; i < s1.length && i < s2.length;  i++) 
		{ 
            count[s1[i]]++; 
            count[s2[i]]--; 
        }

        // if arrays are of different lenght, return false
        if (s1.length != s2.length) 
        {
            return false;  
        }

        // if even one character is non zero, then strings are not anagram of each other
        for(int i = 0; i < 256; i++)
        {
        	if(count[i] != 0)
        	{
        		return false;
        	}
        }

        return true;
	}


	public static void main(String []args)
	{
		// Using Scanner for Getting Input from User 

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String s1 = input.nextLine(); 

        System.out.print("Enter the second string: ");
        String s2 = input.nextLine(); 

        System.out.println();

        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();



        boolean ans = areAnagram(str1,str2);


        if(ans == true)
        {
        	System.out.println("The two strings are anagram of each other."); 
        }
        else
        {
            System.out.println("The two strings are not anagram of each other.");
        }
        

	}
}