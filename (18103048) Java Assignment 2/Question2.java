import java.io.*;
import java.util.*;

public class Question2{

	public static void countSort(int arr [], int n)
	{
		int temp [] = new int[n];
		int count [] = new int[21];


    	// Storing the count of each element
		for (int i = 0; i < n; i++) 
		{
      		count[arr[i]] += 1;
    		}

    	// Storing the cummulative count in the array
    	for (int i = 1; i <= 20; i++) 
    	{
      		count[i] += count[i - 1];
    	} 

    	// Find the index of each element of the original array in count array, and place the elements in temp array
    	for (int i = n - 1; i >= 0; i--) 
    	{
      		temp[count[arr[i]] - 1] = arr[i];
      		count[arr[i]] -= 1;
    	}

    	// Copy the sorted elements back into original array
    	for (int i = 0; i < n; i++) 
    	{
      		arr[i] = temp[i];
    	}

  	}


	

	public static void main(String []args)
	{
		
		System.out.print("Enter the size of the array: ");
		Scanner sc = new Scanner(System.in);
		// n stores the size of the input array
		int n = sc.nextInt();
		System.out.println();


		int arr [] = new int[n];
		System.out.println("Enter the elements into the array (from 0 to 20): ");
		// entering the elements into the array
		for(int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println();

		//calling the countsort function
		countSort(arr,n);

		System.out.println("The array after sorting is: ");
		// the array after sorting is
		for(int i = 0; i < n; i++)
		{
			System.out.print(arr[i] + " ");
		}

		System.out.println();

	}	

}
