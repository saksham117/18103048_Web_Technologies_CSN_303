// package assignment_5;

//inheriting from thread class
class Counter extends Thread
{
	public void run()
	{	
		try
		{	
			for(int i = 1; i <= 100; i++)
			{
				System.out.println(i);
				
				// printing a statement after every 10 numbers
				if(i%10 == 0)
				{
					System.out.println("10 numbers have been printed");
				}
				
				// to pause for 1 second between each number
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			Thread.currentThread().interrupt();
		}
				
	}
}
public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating an object of counter class
		Counter count_100 = new Counter();
		
		// calling the start method of Thread class
		count_100.start();
		
	}

}
