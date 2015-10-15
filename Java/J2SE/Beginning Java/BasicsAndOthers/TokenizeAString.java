import java.util.StringTokenizer; // Import the tokenizer class

public class TokenizeAString
{
	public static void main(String[] args)
	{
		String text = "To be or not to be"; // String to be segmented
		StringTokenizer st = new StringTokenizer(text); // Create a tokenizer for it
		String[] subStr = new String[st.countTokens()]; // Array to hold the tokens
		
		// Extract the tokens
		for(int i = 0; i < subStr.length; i++)		
		{
			subStr[i] = st.nextToken();
		}
		
		// Display the substrings
		for(int i = 0; i < subStr.length; i++)
		{
			System.out.println(subStr[i]);
		}
	}
}