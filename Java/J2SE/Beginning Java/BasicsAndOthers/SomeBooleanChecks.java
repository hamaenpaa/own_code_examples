
public class SomeBooleanChecks
{
	public static void main(String[] args)
	{
		int value = 10, count = 2, limit = 5;
		// Checking & and &&
		System.out.println("value = " + value + ",count = " + count +
			",limit = " + limit);
		if (++value%2 == 0 && ++count<limit)		
		{
			System.out.println("++value%2 == 0 && ++count<limit, value = " 
				+ value + ",count = " + count +	",limit = " + limit);
		}
		System.out.println("value = " + value + ",count = " + count +
			",limit = " + limit);
		if (++value%2 == 0 & ++count<limit)		
		{
			System.out.println("++value%2 == 0 & ++count<limit, value = " 
				+ value + ",count = " + count +	",limit = " + limit);
		}
		System.out.println("value = " + value + ",count = " + count +
			",limit = " + limit);
		// Checking | and ||
		if (++value%2 == 0 || ++count<limit)		
		{
			System.out.println("++value%2 == 0 || ++count<limit, value = " 
				+ value + ",count = " + count +	",limit = " + limit);
		}
		System.out.println("value = " + value + ",count = " + count +
			",limit = " + limit);
		if (++value%2 == 0 | ++count<limit)		
		{
			System.out.println("++value%2 == 0 | ++count<limit, value = " 
				+ value + ",count = " + count +	",limit = " + limit);
		}
		System.out.println("value = " + value + ",count = " + count +
			",limit = " + limit);
		// ! operator and combined && and ||
		int age = 15, height = 120;
		if (!(age >= 16 && age < 65))
		{
			System.out.println("Age <= 15 or age >= 65, Lower price");
		}
		if (age < 12 && height < 48 || age > 65 && height > 72)
		{
			System.out.println(
				"(age < 12 and height < 48) or (age > 65 and height > 72)"
				+ " && has higher precedence than ||");
		}
		// Character methods for testing letters
		char symbol = 'A';
		symbol = (char)(128.0*Math.random());
		if (Character.isUpperCase(symbol))
		{
			System.out.println("You have the capital letter " + symbol);
		}
		else if (Character.isLowerCase(symbol))
		{
			System.out.println("You have the small letter " + symbol);
		}
		else
		{
			System.out.println("The code is not a letter ");
		}
		// Conditional operator
		int nHats = 1;
		System.out.println("I have " + nHats + " hat" 
			+ (nHats == 1 ? "." : "s."));
		++nHats;	
		System.out.println("I have " + nHats + " hat" 
			+ (nHats == 1 ? "." : "s."));

	}
}