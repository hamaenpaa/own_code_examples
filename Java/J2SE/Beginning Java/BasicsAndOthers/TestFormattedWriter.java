import java.io.*;

public class TestFormattedWriter
{
	public static void main(String[] args)
	{
		// Some arbitary data to output
		int[] numbers = { 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377 };
		
		double[] values = { 1.0, 1.0, 1.414, 1.732, 2.236, 2.828, 3.606, 4.582,
			5.831, -123456789.23456	};
			
		String[] strings = { "one", "two", "three", "four", "five", "eight",
			"thirteen" };
			
		// Create a formatted writer for a buffered output to the command line
		FormattedWriter out = new FormattedWriter(new BufferedWriter(
			new OutputStreamWriter(System.out)), 12, 
			FormattedWriter.RIGHT_JUSTIFIED);
			
		for(int i = 0; i < numbers.length; i++)
		{
			if (i % 6 == 0) // New line before each line of five values
			{
				out.println();
			}
			out.print((long)numbers[i]);
		}
		
		out.setWidth(10);
		for(int i = 0; i < values.length; i++)
		{
			if (i % 5 == 0) // New line before each line of four values
			{
				out.println();
			}
			out.print(values[i]);
		}
		
		for(int i = 0; i < strings.length; i++)
		{
			if (i % 4 == 0)
			{
				out.println(); // New line before each line of three values
			}
			out.print(strings[i], 14); // Override width
		}
	}
}