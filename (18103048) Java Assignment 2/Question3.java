import java.util.*;
import java.io.*;

public class Question3{

	public static boolean smaller(String str1, String str2)
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
				return true;
			}
			else // if unicode of character in string2 is smaller than unicode of character in string1
			{
				return false;
			}
		}

		if(str1.length() < str2.length())// if length of string1 is smaller than string2
		{
			return true;
		}
		else if(str1.length() > str2.length())// if length of string2 is smaller than string1
		{
			return false; 
		}

		return true;
	}

	// function for merging two sorted arrays (from 0 to mid and mid+1 to high)
	public static void merge(String array[], int low, int mid, int high)
	{	
		// i for traversing from low to mid
		// j for traversing from mid+1 to high
		// k for traversing the temporary array
		
		int i = low;
		int j = mid+1;
		int k = low;

		String temp[] = new String[array.length];

		while(i <= mid && j <= high)
		{
			if(smaller(array[i], array[j] ))
			{
				temp[k++] = array[i++];
			}
			else
			{
				temp[k++] = array[j++];
			}
		}
		
		// only one of these condition will execute
		for(; i <= mid; i++)
		{
			temp[k++] = array[i];
		}

		for(; j <= high; j++)
		{
			temp[k++] = array[j];
		}


		k = low;
		//copying the sorted elements back to the original array
		for(; k <= high; k++)
		{
			array[k] = temp[k];
		}


	}

	// recursive function for mergesort
	public static void MergeSort(String array[], int low, int high)
	{
		if(low >= high)
		{
			return;
		}

		int mid = low + (high - low)/2;

		MergeSort(array,low,mid);
		MergeSort(array,mid+1,high);
		merge(array,low,mid,high);

	}

	public static void main(String [] args)
	{	
		System.out.print("Enter the size of the array: ");
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		String array[] = new String[n];

		System.out.println("Enter the strings into the array: ");

		for(int i = 0; i < n; i++)
		{
			array[i] = sc.nextLine();
		}

		int low = 0;
		int high = n-1;

		MergeSort(array,low,high);

		System.out.println("Array after sorting is: ");

		for(int i = 0; i < n; i++)
		{
			System.out.println(array[i]);
		}



	}
}
