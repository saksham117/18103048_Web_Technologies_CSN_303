public class Question4{

	public static void main(String []args)
	{
		// long sum = 0;
		int minimum = Integer.MAX_VALUE;

		for(int i = 1; i < Integer.MAX_VALUE; i++)
		{	
			long sum = 0;
			long square = 1;
			int flag = 0; // to check if it is calid for all i, where 1 <= i <= n
			

			for(int j = 1; j <= i && sum < Integer.MAX_VALUE ; j++)
			{
				sum = sum + j;
				square = j*j;

				if(sum != square)
				{
					flag = 1;
					break;
				}

			}

			if(sum > Integer.MAX_VALUE)
			{
				flag = 1;
			}

			if(flag == 0 && i < minimum)
			{
				minimum = i;
			}
		}

		System.out.println("The smallest element which satisfies the condition is: " + minimum);

	}
}