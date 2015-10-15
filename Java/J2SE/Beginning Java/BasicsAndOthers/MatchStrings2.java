public class MatchStrings2
{
	public static void main(String[] args)
	{
		String string1 = "Too many ";
		String string2 = "cooks";
		String string3 = "Too many cooks";
		
		// Make string1 and string3 refer to separate strings that are identical
		string1 += string2;
		
		// Display the contents of the strings
		System.out.println("Test1");
		System.out.println("string3 is now: " + string3);
		System.out.println("string1 is now: " + string1);
		
		if (string1.equals(string3))
		{
			System.out.println("string1.equals(string3) is true." +
				" So strings are equal.");
		}
		else
		{
			System.out.println("string1.equals(string3) is false." +
				" So strings are not equal.");
		}
		
		// Now make string1 and string3 refer to strings differing in case
		string3 = "TOO many cooks";
		
		// Display the contents of the strings
		System.out.println("\n\nTest2");
		System.out.println("string3 is now: " + string3);
		System.out.println("string1 is now: " + string1);

		if (string1.equals(string3))
		{
			System.out.println("string1.equals(string3) is true." +
				" So strings are equal.");
		}
		else
		{
			System.out.println("string1.equals(string3) is false." +
				" So strings are not equal.");
		}
		
		if (string1.equalsIgnoreCase(string3))
		{
			System.out.println("string1.equalsIgnoreCase(string3) is true." +
				" So strings are equal ignoring case.");
		}
		else
		{
			System.out.println("string1.equalsIgnoreCase(string3) is false." +
				" So strings are not equal ignoring case.");
		}
	}
}