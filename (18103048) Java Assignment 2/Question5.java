import java.util.*;
import java.io.*;

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




        // performing operation using Sets class

	}
}