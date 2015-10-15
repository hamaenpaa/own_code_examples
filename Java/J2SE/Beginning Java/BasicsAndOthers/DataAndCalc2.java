import java.io.IOException;

public class DataAndCalc2
{
	public static void main(String[] args)
	{
		// Declare and initialize three variables
		double numOranges = 50.0E-1;
		double numApples = 1.0E1;
		double averageFruit = 0.0;
		
		averageFruit = (numOranges + numApples) / 2.0;
		
		System.out.println("A fruity program");
		System.out.println("Average fruit is " + averageFruit);
		
		double fruitTypes = 0.0;
		averageFruit = (numOranges + numApples) / fruitTypes;
		
		System.out.println("Division by zero result: " + averageFruit);
		
		int three = 3, two = 2;
		double result = 1.5 + three / two;
		System.out.println("Integer division: " + result);
		
		result = 1.5 + (double)three / two;
		System.out.println("Double division: " + result);
		
		int a = 2, b = 4;
		
		result = 5.0;
		result /= a % b / (a + b);
		System.out.println(
			"Result, result = 5.0, result /= a % b / (a + b), result = " 
			+ result);
		
		double radius = 0.0;
		double circleArea = 100.0;
		int feet = 0;
		int inches = 0;
		radius = Math.sqrt(circleArea/Math.PI);
		feet = (int)Math.floor(radius);
		inches = (int)Math.round(12.0 * (radius - feet));
		
		System.out.println("The radius of a circle with area " + circleArea
		 + " square feet is\n" + feet + " feet " + inches + " inches.");
		 
		double sin30 = Math.sin(Math.PI/6);
		double sin45 = Math.sin(Math.PI/4);
		double sin60 = Math.sin(Math.PI/3);
		double sin90 = Math.sin(Math.PI/2);
		double sin120 = Math.sin(2*Math.PI/3);
		
		System.out.println("sin30 = " + sin30 + "\nsin60 = " + sin60 +
			"\nsin90 = " + sin90 + "\nsin120 = " + sin120);
		
		double cos30 = Math.cos(Math.PI/6);
		double cos45 = Math.cos(Math.PI/4);
		double cos60 = Math.cos(Math.PI/3);
		double cos90 = Math.cos(Math.PI/2);
		double cos120 = Math.cos(2*Math.PI/3);

		System.out.println("cos30 = " + cos30 + "\ncos60 = " + cos60 +
			"\ncos90 = " + cos90 + "\ncos120 = " + cos120);
		
		double tan30 = Math.tan(Math.PI/6);
		double tan45 = Math.tan(Math.PI/4);
		double tan60 = Math.tan(Math.PI/3);
		double tan90 = Math.tan(Math.PI/2);
		double tan120 = Math.tan(2*Math.PI/3);

		System.out.println("tan30 = " + tan30 + "\ntan60 = " + tan60 +
			"\ntan90 = " + tan90 + "\ntan120 = " + tan120);
			
		double exp9 = Math.exp(9);
		double log200 = Math.log(200);
		double pow2_5 = Math.pow(2.0,5.0);
		
		System.out.println("e^9 = " + exp9 + ", log200 = " + log200 +
		  "2^5 = " + pow2_5);
		  
		int indicators = 0xFF07;
		int thirdBit = indicators & 0x4;
		
		System.out.println("0xFF07 & 0x4 = " + thirdBit);
		
		indicators = 0xFF09;
		thirdBit = indicators & 0x4;
		System.out.println("0xFF09 & 0x4 = " + thirdBit);
		
		indicators |= 0x4;
		System.out.println("Set 3rd bit on indicators = 0xFF09, " +
			"indicators |= 0x4 -> indicators = " + indicators);
		
		indicators &= ~0x4;
		System.out.println("Set 3rd bit off indicators = 0xFF0D, " +
			"indicators &= ~0x4 -> indicators = " + indicators);

		a = 0xD00F; b = 0xABAD;
		System.out.println("a = " + a + ",b = " + b );
		a ^= b; b ^= a; a ^= b;
		System.out.println("After tricky exchange of integer values: a = " 
			+ a + ",b = " + b );
		
	    int c, d;
	    a = b = c = d = 1;
	    a += b = c += d = 10;
	    System.out.println("a=b=c=d=1, a += b = c += d = 10 -> a = " + a
	    	+ ",b = " + b + ",c = " + c + ",d = " + d);
		
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