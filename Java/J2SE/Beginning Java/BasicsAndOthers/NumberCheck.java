public class NumberCheck
{
	public static void main(String[] args)
	{
		int number = 0;
		number = 1 + (int)(Math.random());
		if (number % 2 == 0)
		{
			System.out.println("You have got an even number " + number);
			if (number < 50)
			{
				System.out.println("You have got an even number < 50");
			}
		}
		else
		{
			System.out.println("You have got an odd number " + number);			
		}
		if (number % 2 == 0)
			if ((number > 50) && (number < 100))
			{
				System.out.println("You have got an even number > 50 and < 100");
			}
			else
			{
				System.out.println("You have got an even number <= 50 or >= 100");
			};
		return;
	}	
}

