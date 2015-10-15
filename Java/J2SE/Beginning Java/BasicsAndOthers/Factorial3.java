public class Factorial3
{
	public static void main(String[] args)
	{
		long limit = 20;
		long factorial = 1;
		
		OuterLoop:
		for(int i=1; i <= limit; i++)
		{
			factorial = 1;
			for(int j=2; j<=i; j++)
			{
				if (i > 10 && i % 2 == 1)
				{
					continue OuterLoop;
				}
				factorial *= j;
			}
			System.out.println(i + "!" + " is " + factorial);
		}
	}
}