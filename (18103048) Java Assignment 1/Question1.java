import java.util.*;
import java.io.*;


public class Question1{

	static int count(char text[], char patt[], int n, int m)
	{	
		// to maintain the number of anagrams
		int count = 0;

		// i goes from 0 to n - m 
		for(int i = 0; i <= (n-m); i++)
		{
			// is used if string mismatch occurs
			int flag = 0;

			// everytime we create a temporay array of size m and fill it with values from text and then sort it
			char temp[] = new char[m];

			for(int j = i, k = 0; j < i + m && k < m; j++, k++)
			{
				temp[k] = text[j];
			}

			//sorting temp
			Arrays.sort(temp,0,m);

			//comparing the strings
			for(int j = 0; j < m; j++)
			{
				if(temp[j] != patt[j])
				{	// if false, set flag to 1
					flag = 1;
					break;
				}
			}

			// only if flag = 0, increase the count
			if(flag == 0)
			{
				count +=1;
			}

		}


		return count;

	}

	public static void main(String[] args) 
	{
		
		// Using Scanner for Getting Input from User 

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String text = input.nextLine(); 
        int n = text.length();

        System.out.print("Enter the substring: ");
        String patt = input.nextLine(); 
        int m = patt.length();


        System.out.println();

        char t[] = text.toCharArray();
        char p[] = patt.toCharArray();

        //sorting the pattern
        Arrays.sort(p);

        int ans = count(t,p,n,m);

        System.out.println("The number of times the given substring appears in the string is: " + ans);




	}
}