package assignment_4;
import java.util.*;

public class question1 {
	
	private static int N = 0; // number of rows
	private static int M = 0; // number of columns
	private static int minimumReplantations = Integer.MAX_VALUE;
//	the string of alphabets to be used for replacement
	private static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	
//	to check if the index we are going to is valid or not
	public static boolean isValid(int x, int y)
	{
		if(x >= 0 && x < N && y >= 0 && y < M)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
//	function for making a replacement at the current index x,y
	public static void change(String[] crops, int x, int y, int changes)
	{	
//		if I cannot find any character that can be placed at that location, I will return
		int characterIndex = -1;
		
		for(int i = 0; i < 26; i++)
		{
//			finding a character to replace with which does not match any of its 4 adjacent characters
//			checking first top, then bottom, then left and then right
			if((isValid(x-1,y) && crops[x-1].charAt(y) == alphabets.charAt(i)) ||isValid(x+1,y) && crops[x+1].charAt(y) == alphabets.charAt(i) ||isValid(x,y-1) && crops[x].charAt(y-1) == alphabets.charAt(i)
					||isValid(x,y+1) && crops[x].charAt(y+1) == alphabets.charAt(i))
			{
				continue;
			}
			
			characterIndex = i;
			break;
		}
		
		if(characterIndex == -1)
		{
			return;
		}
		
//		the new string which is formed by replacing the original string by the new character
		String newString = crops[x].substring(0,y) + alphabets.charAt(characterIndex) + crops[x].substring(y+1);
//		Storing the original string for backtracking
		String originalString = crops[x];
		
//		make the changes and increment the change by one
		crops[x] = newString;
		advance(crops,x,y+1,changes + 1); // Recursive step
		crops[x] = originalString; // Backtracking step
	}
	
	
	
	public static void advance(String[] crops, int x, int y, int changes)
	{
		if(!isValid(x,y))
		{	
			// this step because we are only incrementing y(columns) and not x
			y = 0;
			x+=1;
			
//			Now if on incrementing x, we exceed N, then we know we have reached end of 2d matrix
			if(!isValid(x,y))
			{
				minimumReplantations = Math.min(changes, minimumReplantations);
				return;
			}
		}
		
//		just checking in the top direction and left direction because we are gong to the next row
//		in the base condition if else and we are going right if the crops are correctly placed
		if((isValid(x-1,y) && crops[x].charAt(y) == crops[x-1].charAt(y)) || (isValid(x,y-1) && crops[x].charAt(y) == crops[x].charAt(y-1)))
		{	
//			there is a conflict
			change(crops,x,y,changes);
		}
		else
		{	
//			current crop is in no conflict
			advance(crops,x,y+1,changes);
		}
		
		
		
	}
	
	public static int replant(String[] crops)
	{
		// Write your code here
		// Return the number of replanted crops
		// x = 0, y = 0, changes = 0
		advance(crops, 0 ,0, 0);
		
		return minimumReplantations;
		

		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n,m;
		
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		in.nextLine();
		
		
		String []crops = new String[n];
		
		for(int i = 0; i < n; i++)
		{
			crops[i] = in.nextLine().trim();
		}
		
		N = n;
		M = m;
		
		System.out.println(replant(crops));
		
		in.close();
	
	}

}
