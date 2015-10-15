public class SumExceptMultiplesOfThree
{
	public static void main(String[] args)
	{
		int limit = 20;
		int sum = 0;
		for(int i=1; i<=limit; i++)
		{
			if (i % 3 == 0)
			{
				continue;
			}
			sum += i;
		}
		System.out.println("Sum of integers from 1 to " + limit +
		 " except for those multiples of three is " + sum);
	}
}