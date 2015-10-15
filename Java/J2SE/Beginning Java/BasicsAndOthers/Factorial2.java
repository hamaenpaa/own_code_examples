public class Factorial2
{
	public static void main(String[] args)
	{
		long limit = 20;
		long factorial = 1;
		for (int i = 1; i <= limit; i++)
		{
			factorial = 1;
			int factor = 2;
			while (factor <= i)
			{
				factorial *= factor++;
			}
			System.out.println(i + "!" + " is " + factorial);
		}
	}
}