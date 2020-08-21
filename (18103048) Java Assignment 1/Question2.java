import java.util.*;
import java.io.*;


public class Question2{

	public static void main(String[] args) {

		System.out.println("Enter the paragraph: ");

		Scanner input = new Scanner(System.in);

		String paragraph = input.nextLine();

		System.out.println();

		String option = "Yes";

		while(option.compareTo("No") != 0 ) 
		{
			System.out.print("Add a word to the vector: ");
			String s1 = input.nextLine();


			String replace = String.valueOf(s1.charAt(0));

			for(int i = 0; i < s1.length() - 1; i++)
			{
		   		replace = replace + '*';
			}

			paragraph = paragraph.replaceAll(s1,replace);

			System.out.print("Do you want to add another word (Yes/No):");
			option = input.nextLine();
		}



		System.out.println(paragraph);

	}
}