
public class DoWhileLoop
{
	public static void main(String[] args)
	{
		int limit = 20;
		int sum = 0;
		int i = 1;
		
		do { 
			sum += i; i++;
		} while (i <= limit);
		
		System.out.println("sum = " + sum);
	}
}