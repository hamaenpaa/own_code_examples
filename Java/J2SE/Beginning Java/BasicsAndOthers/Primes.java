public class Primes
{
	public static void main(String[] args)
	{
		int nValues = 50;
		boolean isPrime = true;
		for (int i=2; i<= nValues; i++)
		{
			isPrime = true;
			for(int j=2; j < i; j++)
			{
				if (i % j == 0)
				{
					isPrime = false;
					break;
				}
			}
			if (isPrime)
			{
				System.out.println(i);
			}
		}
	}
}