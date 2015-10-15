public class StringCharacters
{
	public static void main(String[] args)
	{
		// Text string to be analyzed
		String text = "To be or not to be, that is the question;"
			+ "Whether 'tis nobler in the mind to suffer"
			+ " the slings and arrows of outrageous fortune,"
			+ " or to take arms against a sea of troubles,"
			+ " and by opposing end them?";
		
		int spaces = 0,       // Count of spaces
			vowels = 0,       // Count of vowels
			letters = 0;      // Count of letters
		
		// Analyze all characters in the string
		int textLength = text.length(); // Get string length
			
		for(int i = 0; i < textLength; i++)
		{
			char ch = Character.toLowerCase(text.charAt(i));
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			{
				vowels++;
			}
			
			// Check for letters
			if (Character.isLetter(ch))
			{
				letters++;
			}
			
			// Check for spaces
			if (Character.isWhitespace(ch))
			{
				spaces++;
			}
		}
	
		System.out.println("The text contained vowels: " + vowels + "\n"
			+ "       consonants: " + (letters - vowels) + "\n"
			+ "       spaces:     " + spaces);
	}
}