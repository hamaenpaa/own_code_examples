public class FindPrimes
{
	public static void main(String[] args)
	{
		int nPrimes = 50;
		
		OuterLoop:
		for(int i=2; ;i++)
		{
			// Try dividing by all integers from 2 to i-1
			for (int j=2; j < i; j++)
			{
				if (i % j == 0)
				{
					continue OuterLoop;
				}
			}
			// We only get here if we have a prime
			System.out.println(i); // so output the value
			if (--nPrimes == 0)  // Decrement the prime count
			{
				break OuterLoop; // If the prime count gets zero, we have all of them
			}
		}
	}
}

