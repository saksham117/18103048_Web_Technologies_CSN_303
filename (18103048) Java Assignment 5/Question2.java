// package assignment_5;

import java.util.*;

public class Question2 {
	// the maximum number of integers that can be tested
	private final static int maximum = 100000;
	
	//The largest number of divisors found so far.
	private volatile static int maxNumDivisor = 0;
	
	// number with the highest count of divisors
	private volatile static int numWithMaxDivisorCount;
	
	
	//compares the maximum generated by each thread with the global maximum divisor count
	synchronized private static void report(int maxCountFromThread, int numWithMaxFromThread) 
	{
		if (maxCountFromThread > maxNumDivisor) 
		{
			maxNumDivisor = maxCountFromThread;
		    numWithMaxDivisorCount = numWithMaxFromThread;
		}
	}
	
	//function to calculate number of divisors of a number
	public static int countDivisors(int n)
	{
		int count = 0;
	    for (int i = 1; i <= n ; i++) 
	    {
	    	if ( n % i == 0 )
	    	{
	    		count ++;
	    	}
	            
	    }
	    return count;
	    
	}
	
	
	 // A thread belonging to this class counts the number of divisors for all
     // the integers in an assigned range of integers.  It then reports its answer via report method.
	private static class CountDivisorsThread extends Thread 
	{
		int start, end;
	      public CountDivisorsThread(int start, int end) {
	         this.start = start;
	         this.end = end;
	      }
	      public void run() {

	         int maxDivisors = 0;
	         int integer = 0;
	         
	         for (int i = start; i < end; i++) {
	            int divisors = countDivisors(i);
	            if (divisors > maxDivisors) {
	               maxDivisors = divisors;
	               integer = i;
	            }
	         }

	         report(maxDivisors,integer);
	      }
	}
	
	// function which makes use of CountDivisorsThread class number to find the number which has the largest number of 
	// divisors, dividing the work among a specified number of threads.
	private static void countDivisorsUsingThread(int numThreads)
	{	
		// initializing the time to calculate elapsed time
		long startTime = System.currentTimeMillis();
		
		//creating an array of type CountDivisorThread class
		// whose size is equal to the number of threads
		
		CountDivisorsThread[] array = new CountDivisorsThread[numThreads];
		int numbersPerThread = maximum/numThreads; 
		
	      int start = 1;  // Starting point of the range of integers for first thread.
	      int end = start + numbersPerThread - 1;   // End point of the range of integers.
	      
	      // assigning start index and end index to each thread
	      for (int i = 0; i < numThreads; i++) 
	      {
	         if (i == numThreads - 1) 
	         {	
	        	// if it is the last thread
	            end = maximum;
	         }
	         
	         // calling the constructor of CountDivisorsThread class
	         array[i] = new CountDivisorsThread( start, end );
	         start = end+1;    // Determine the range of integers for the NEXT thread.
	         end = start + numbersPerThread - 1;
	      }
	      
	      maxNumDivisor = 0;
	      
	      // starting each of the threads
	      for (int i = 0; i < numThreads; i++)
	      {
	    	  array[i].start();
	      }
	      
	         
	      for (int i = 0; i < numThreads; i++)
	      {
	         // Wait for each thread to fully complete, because the results
	         // are not complete until all threads have been completed and
	         // their outputs need to be compared
	         while (array[i].isAlive()) 
	         {
	            try 
	            {
	               array[i].join();
	            }
	            catch (InterruptedException e) 
	            {
	            }
	         }
	      }
	      
	      long elapsedTime = System.currentTimeMillis() - startTime;
	      
	      System.out.println("\nThe largest number of divisors " + 
	            "for numbers between 1 and " + maximum + " is " + maxNumDivisor);
	      System.out.println("The integer with that many divisors is " + 
	            numWithMaxDivisorCount);
	      System.out.println("Total elapsed time:  " + 
	            (elapsedTime/1000.0) + " seconds.\n");
	      
	   }
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		int numThreads = 0;
		
		// asking the user to enter the number of threads he wants
		while(numThreads < 1 || numThreads > 10)
		{
			System.out.print("Enter the number of threads you want to use(1 to 10): ");
			numThreads = in.nextInt();
			
			if(numThreads < 1 || numThreads > 10)
			{
				System.out.println("Please enter a number between 1-10");
			}
		}
		
		in.close();
		countDivisorsUsingThread(numThreads);
		
		
		
		
	}

}
