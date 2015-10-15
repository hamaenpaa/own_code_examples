import java.io.*;

public class FormattedInput
{
	// Method to read an int value
/*	public int readInt()
	{
		for(int i = 0; i < 5; i++)
		{
			if (readToken() == tokenizer.TT_NUMBER)
			{
				return (int)tokenizer.nval; // Value is numeric, so return as int
			}
			else
			{
				System.out.println("Incorrect input: " + tokenizer.sval 
					+ " Re-enter an integer"); 
				continue; // Retry the read operation
			}
		}
		System.out.println("Five failure reading as int value"
			+ " - program terminated");
		System.exit(1);
		return 0;
	}*/
	
	public int readInt() throws InvalidUserInputException
	{
		if (readToken() != tokenizer.TT_NUMBER)
		{
			throw new InvalidUserInputException(" readInt() failed. " 
				+ "Input data not numeric");
		}
		
		if (tokenizer.nval > (double)Integer.MAX_VALUE
			|| tokenizer.nval < (double)Integer.MIN_VALUE)
		{
			throw new InvalidUserInputException(" readInt() failed. " 
				+ "Input outside int range");
		}

		if (tokenizer.nval != (double)(int)tokenizer.nval)
		{
			throw new InvalidUserInputException(" readInt() failed. " 
				+ "Input not an integer");
		}
		
		return (int)tokenizer.nval; // Value is numeric, so return as int
	}
	
	// Method to read a double value
	public double readDouble() throws InvalidUserInputException
	{
		if (readToken() != tokenizer.TT_NUMBER)
		{
			throw new InvalidUserInputException(" readDouble() failed. " 
				+ "Input data not numeric");
		}
		
		return tokenizer.nval; // Value is numeric, so return it		
	}
	
	// Plus methods to read various other data types
	public String readString() throws InvalidUserInputException
	{
		if (readToken() == tokenizer.TT_WORD || ttype == '\"' || 
			ttype == '\'')
		{
			return tokenizer.sval;
		}
		else
		{
			throw new InvalidUserInputException(" readString() failed. " 
				+ "Input data is not a string");
		}
	}	
	
	// Helper method to read the next token
	private int readToken()
	{
		try
		{
			ttype = tokenizer.nextToken();
			return ttype;
		}
		catch (IOException e) // Error reading in nextToken()
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		return 0;
	}
	
	// Object to tokenize input from the standard input stream
	private StreamTokenizer tokenizer = new StreamTokenizer(
		new BufferedReader(new InputStreamReader(System.in)));
	
	private int ttype; // Stores the token type code
}