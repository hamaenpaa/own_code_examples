import java.util.StringTokenizer;

public class Ch4Ex3
{
	public static void main(String[] args)
	{
		// Text string to be analyzed
		String text = "To be or not to be, that is the question;"
			+ "Whether 'tis nobler in the mind to suffer"
			+ " the slings and arrows of outrageous fortune,"
			+ " or to take arms against a sea of troubles,"
			+ " and by opposing end them?";
			
		System.out.println("Text to be analyzed is: " + text);
		StringTokenizer st = new StringTokenizer(text); // Create a tokenizer for it
		String[] subStr = new String[st.countTokens()]; // Array to hold the tokens

		// Extract the tokens
		for(int i = 0; i < subStr.length; i++)		
		{
			subStr[i] = st.nextToken();
		}

		System.out.println("\nWords separated:");
		for(int i = 0; i < subStr.length; i++)
		{
			System.out.print("Word " + (i+1) + " is " + subStr[i] + " ");
		}
		System.out.println();

		// Sort words with bubblesort algorithm:
		boolean inOrder = false;
		while(!inOrder)					
		{
			inOrder = true;
			for(int i = 0; i < subStr.length-1; i++ )
			{
				if (subStr[i].compareTo(subStr[i+1]) > 0) 
				{
					inOrder = false;
					String strChange = subStr[i];
					subStr[i] = subStr[i+1];
					subStr[i+1] = strChange;
				}
			}
		}
		
		// Display the ordered words
		System.out.println("\nWords ordered:");
		for(int i = 0; i < subStr.length; i++)
		{
			System.out.print("Word " + (i+1) + " is " + subStr[i] + " ");
		}
		System.out.println();
	}
}