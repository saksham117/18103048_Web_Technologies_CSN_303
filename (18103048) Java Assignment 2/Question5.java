import java.util.*;
import java.io.*;
import java.time.*;

public class Question5{

	public static void main(String[] args)
	{
		// universe is elements 0 to 10;

		int setA [] = new int[11];
		int setB [] = new int[11];

		Set<Integer> setC = new HashSet<Integer>();  
        Set<Integer> setD = new HashSet<Integer>();

        String s1 = "Yes";
        String s2 = "Yes";

        // adding elements to the two sets.

        while(!s1.equals("No"))
        {
        	System.out.println("Enter elements in the first set: ");
        	Scanner sc = new Scanner(System.in);

        	int n = sc.nextInt();

        	setA[n] = 1;
        	setC.add(n);

      		System.out.println("Do you want to add another element (Yes/No): ");
      		s1 = sc.nextLine();
      		s1 = sc.nextLine();
        }

        System.out.println();

        while(!s2.equals("No"))
        {
        	System.out.println("Enter elements in the second set: ");
        	Scanner sc = new Scanner(System.in);

        	int n = sc.nextInt();

        	setB[n] = 1;
        	setD.add(n);

      		System.out.println("Do you want to add another element (Yes/No): ");
      		s2 = sc.nextLine();
      		s2 = sc.nextLine();
        }

        System.out.println();


        Instant start1 = Instant.now();
        // performing operation using sets as arrays

        // union
        Vector union_a = new Vector();

        for(int i = 0; i < 11; i++)
        {
        	if(setA[i] == 1 && setB[i] == 1)
        	{
        		union_a.add(i);
        	}
        	else if(setA[i] == 1)
        	{
        		union_a.add(i);
        	}
        	else if(setB[i] == 1)
        	{
        		union_a.add(i);
        	}
        }

        // intersection
        Vector intersection_a = new Vector();

        for(int i = 0; i < 11; i++)
        {
        	if(setA[i] == 1 && setB[i] == 1)
        	{
        		intersection_a.add(i);
        	}
        }
        // complement
        Vector complement_a_A = new Vector();
        Vector complement_a_B = new Vector();

        for(int i = 0; i < 11; i++)
       	{
        	if(setA[i] == 0)
        	{
        		complement_a_A.add(i);
        	}

        	if(setB[i] == 0)
        	{
        		complement_a_B.add(i);
        	}
        }

        //printing
        System.out.println("The union of the two sets is " + union_a);
        System.out.println("The intersection of the two sets is " + intersection_a);
        System.out.println("The compliment of set A is " + complement_a_A);
        System.out.println("The compliment of set B is " + complement_a_B);


        System.out.println();

        Instant end1 = Instant.now();

        Duration timeElapsed1 = Duration.between(start1, end1);

        // performing operation using Sets class

        Instant start2 = Instant.now();
        //union
        Set<Integer> union = new HashSet<Integer>(setC);  
        union.addAll(setD);  
  
        //intersection  
        Set<Integer> intersection = new HashSet<Integer>(setC);  
        intersection.retainAll(setD);  

        //complement
        Set<Integer> complement_C = new HashSet<Integer>();  
        complement_C.addAll(Arrays.asList(new Integer[] {0,1,2,3,4,5,6,7,8,9,10})); 


        Set<Integer> complement_D = new HashSet<Integer>();  
        complement_D.addAll(Arrays.asList(new Integer[] {0,1,2,3,4,5,6,7,8,9,10}));


        complement_C.removeAll(setC);
        complement_D.removeAll(setD); 


        System.out.println("The union of the two sets is " + union);
        System.out.println("The intersection of the two sets is " + intersection);
        System.out.println("The compliment of set A is " + complement_C);
        System.out.println("The compliment of set B is " + complement_D);
        System.out.println();

        Instant end2 = Instant.now();

        Duration timeElapsed2 = Duration.between(start2, end2);


        System.out.println("The time taken in ths first approach is:" + timeElapsed1);
        System.out.println("The time taken in ths second approach is:" + timeElapsed2);

	}
}
