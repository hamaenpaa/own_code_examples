public class FindCharacters
{
	public static void main(String[] args)
	{
		// Text string to be analyzed
		String text = "To be or not to be, that is the question;"
			+ "Whether 'tis nobler in the mind to suffer"
			+ " the slings and arrows of outrageous fortune,"
			+ " or to take arms against a sea of troubles,"
			+ " and by opposing end them?";

		int andCount = 0; // Number of ands
		int theCount = 0; // Number of thes
		
		int index = -1;   // Current index position
		
		String andStr = "and"; // Search substring
		String theStr = "the"; // Search substring
		
		// Search forwards for "and"
		index = text.indexOf(andStr);
		while(index >= 0)
		{
			++andCount;
			index += andStr.length(); // Step position after last 'and'
			index = text.indexOf(andStr, index);
		}
		
		// Search backwards for "the"
		index = text.lastIndexOf(theStr); // Find last 'the'
		while (index >= 0)
		{
			++theCount;
			index -= theStr.length(); // Step to position before last 'the'
			index = text.lastIndexOf(theStr, index); 
		}
		
		System.out.println("The text contains " + andCount + " ands\n"
			+ "The text contains " + theCount + " thes");
	}
}