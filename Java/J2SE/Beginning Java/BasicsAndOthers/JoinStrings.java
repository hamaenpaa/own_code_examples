public class JoinStrings
{
	public static void main(String[] args)
	{
		String firstString = "Many ";
		String secondString = "hands ";
		String thirdString = "make light work";
		
		String myString; // Variable to store results
		
		// Join three strings and store the result
		myString = firstString + secondString + thirdString;
		System.out.println(myString);
		
		// Convert an integer to String and join with two other integers
		int numHands = 99;
		myString = numHands + " " + secondString + thirdString;
		System.out.println(myString);
		
		// Combining a string and integers
		myString = "fifty five is " + 5 + 5;
		System.out.println(myString);
		
		// Combining integers and string
		myString = 5 + 5 + " is ten";
		System.out.println(myString);
	}
}