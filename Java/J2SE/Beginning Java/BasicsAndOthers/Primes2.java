public class Primes2
{
	public static void main(String[] args)
	{
		int nValues = 50;
		
		OuterLoop:
		for(int i=2; i <= nValues; i++)
		{
			// Try dividing all integers from 2 to i-1
			for(int j=2; j<i; j++)
			{
				if (i % j == 0)	
				{
					continue OuterLoop;
					// This is true if j divides exactly, so exit the loop
				}
			}
			// We only get here with a prime
			System.out.println(i);
		}
	}
}