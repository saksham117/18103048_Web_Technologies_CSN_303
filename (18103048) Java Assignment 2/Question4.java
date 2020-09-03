public class Question4{

	public static void main(String []args)
	{
		// to hold the minimum value satisfying the above condition
		int minimum = Integer.MAX_VALUE;

		// i will vary from 1 to n, where n goes till INT_MAX
		for(int i = 1; i < Integer.MAX_VALUE; i++)
		{	
			long sum = 0;
			long square = 1;
			int flag = 0; // to check if it is called for all i, where 1 <= i <= n
			
			// checking for all j, where 1 <= j <= i
			for(long j = 1; j <= i && sum < Integer.MAX_VALUE ; j++)
			{
				sum = sum + j;
				square = j*j;

				if(sum != square)
				{
					flag = 1;
					break;
				}

			}

			// if sum becomes greater than INT_MAX, set flag to 1
			if(sum > Integer.MAX_VALUE)
			{
				flag = 1;
			}

			// if flag is not set and the index is less than the minimum value
			if(flag == 0 && i < minimum)
			{
				minimum = i;
			}
		}

		System.out.println("The smallest element which satisfies the condition, \u03A3i = i2 where 1 \u003C\u003D i \u003C\u003D n is: " + minimum);

	}
}
