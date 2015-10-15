import java.util.StringTokenizer;

public class Ch4Ex5
{
	public static void main(String[] args)
	{
		String text = "To be or not to be";
		StringTokenizer st = new StringTokenizer(text); // Create a tokenizer for it
		String[] subStr = new String[st.countTokens()]; // Array to hold the tokens
		
		// Extract the tokens
		for(int i = 0; i < subStr.length; i++)		
		{
			subStr[i] = st.nextToken();
		}
		
		StringBuffer buf = new StringBuffer("");
		for(int i = 0; i < subStr.length; i++)
		{
			StringBuffer app = new StringBuffer(subStr[i]);
			app.reverse();
			buf.append(app);
			if (i < subStr.length -1)
			{
				buf.append(" ");
			}
		}
		System.out.println("Result: " + buf.toString());
	}
}