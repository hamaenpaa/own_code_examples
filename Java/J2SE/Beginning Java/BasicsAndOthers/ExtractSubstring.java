public class ExtractSubstring
{
	public static void main(String[] args)
	{
		String text = "To be or not to be"; // String to be segmented
		int count = 0;                      // Number of substrings
		char separator = ' ';               // Substring separator
		
		// Determine the number of substrings
		int index = 0;
		do
		{
			++count;
			++index;
			index = text.indexOf(separator, index);
		} while (index != -1);
		
		// Extract the substring into an array
		String[] subStr = new String[count];
		index = 0;
		int endIndex = 0;
		for(int i = 0; i < count; i++)
		{
			endIndex = text.indexOf(separator, index); // Find next separator
			
			if (endIndex == -1)
			{
				subStr[i] = text.substring(index); // extract to the end
			}
			else
			{
				// Otherwise extract to the end index
				subStr[i] = text.substring(index, endIndex); 
			}
			
			index = endIndex + 1;
		}
		
		// Display the substrings
		for(int i = 0; i < count; i++)
		{
			System.out.println(subStr[i]);
		}
	}
}