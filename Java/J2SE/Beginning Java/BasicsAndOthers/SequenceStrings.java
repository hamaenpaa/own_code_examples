public class SequenceStrings
{
	public static void main(String[] args)
	{
		// Strings to be compared
		String string1 = "A";
		String string2 = "To";
		String string3 = "Z";
		
		// Strings for use in output
		String string1out = "\"" + string1 + "\"";
		String string2out = "\"" + string2 + "\"";
		String string3out = "\"" + string3 + "\"";
		
		// Compare string1 with string3
		if (string1.compareTo(string3) < 0)
		{
			System.out.println(string1out + " is less than " + string3out);
		}
		else
		{
			if (string1.compareTo(string3) > 0)
			{
				System.out.println(string1out + " is greater than " + string3out);
			}
			else
			{
				System.out.println(string1out + " is equal to " + string3out);
			}
		}

		// Compare string1 with string2
		if (string1.compareTo(string2) < 0)
		{
			System.out.println(string1out + " is less than " + string2out);
		}
		else
		{
			if (string1.compareTo(string2) > 0)
			{
				System.out.println(string1out + " is greater than " + string2out);
			}
			else
			{
				System.out.println(string1out + " is equal to " + string2out);
			}
		}
	}
}