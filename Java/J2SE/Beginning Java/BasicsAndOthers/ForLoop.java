
public class ForLoop
{
	public static void main(String[] args)
	{
		int limit = 20;
		int sum = 0;
		for( int i = 1; i <= limit; i++)
		{
			sum += i;
		}
		// System.out.println("Final value of i = " + i ); // Won't compile
		System.out.println("Sum of integer numbers from 1 to " + limit + 
			" is " + sum );
		// Other variables with commas
		sum = 0;
		for( int i = 1, j = 0; i <= limit; i++)
		{
			sum += i * j++;
		}
		System.out.println("Sum of squares of integer numbers from 1 to " + limit + 
			" is " + sum );
		sum = 0;
		for( int i = 1, j = 1; i <= limit; i++, j++)
		{
			sum += i * j;
		}
		System.out.println("Sum of squares of integer numbers from 1 to " + limit + 
			" is " + sum );
		for(double radius = 1.0; radius <= 2.0; radius += 0.2)
		{
			System.out.println("Radius = " + radius + " area = " + 
			Math.PI*radius*radius);
		}
		// BE WARNED - THIS LOOP DOES NOT END
		// never use tests that depend on an exact value for a floating point
		// variable to control a loop
/*		for(double radius = 1.0; radius != 2.0; radius += 0.2)
		{
			System.out.println("Radius = " + radius + " area = " + 
			Math.PI*radius*radius);
		}*/
			
			
	}
}