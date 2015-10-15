import java.io.IOException;

public class DataAndCalc
{
	public static void main(String[] args)
	{
		// Declare and initialize three variables
		int numOranges = 5;
		int numApples = 10;
		int numFruit = 0;
		
		double sunDistance = 1.496E8;
		float electronMass = 9E-28F;
		float hisWeight = 185.2F, herWeight = 108.5F;
		
		// two calculations
		int calc1 = 20 - 3*3 - 9/3;
		int calc2 = (20-3)*(3-9)/3;
		
		// Calculate the total fruit count
		numFruit = numOranges + numApples;
		
		// Display the result
		System.out.println("A fruity program");
		System.out.println("Total fruit is " + numFruit);

		int numFruitEach = 0;
		numFruitEach = numFruit / 4;
		int remainder;
		remainder = numFruit % 4;
		
		System.out.println("Fruits to one child amoung 4 children is " 
			+ numFruitEach);
		System.out.println("Remainder after division: " + remainder);
		
		System.out.println("(press Enter to exit)");
		try
		{
			System.in.read();
		}
		catch (IOException e)
		{
			return;
		}
	}
}