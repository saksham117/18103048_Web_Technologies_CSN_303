package assignment_4;

import java.util.*;
public class question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter any integer value: ");
		
		Scanner in = new Scanner(System.in);
		
//		taking integer as input
		int n = in.nextInt();
		
//		converting integer to byte
		byte b = (byte)n;
		
//		converting byte to character
		char c = (char)b;
		
//		converting character back to integer
		int m = (int)c;
		
		
		System.out.println("The integer before typecasting was: " + n);
		System.out.println("The integer after typecasting is: " + m);
		
		
		// closing the in Scanner class
		in.close();
		
		
		

	}

}
