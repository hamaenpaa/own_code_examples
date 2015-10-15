import java.io.*;

public class FormattedWriter extends PrintWriter
{
	public final static int LEFT_JUSTIFIED = 1;
	public final static int RIGHT_JUSTIFIED = 2;
	private int justification = RIGHT_JUSTIFIED;
	
	private int width = 0; // Field width required for output
	
	// Constructor with a specified field width, autoflush and justification
	public FormattedWriter(Writer output, boolean autoflush, int width,
		int justification)
	{
		super(output, autoflush); // Call PrintWriter constructor
		if (width > 0)
		{
			this.width = width; // Store the field width
		}
		if (justification == LEFT_JUSTIFIED || justification == RIGHT_JUSTIFIED)
		{
			this.justification = justification;
		}
	}
	
	// Constructor with a specified field width
	public FormattedWriter(Writer output, int width)
	{
		this(output, false, width, RIGHT_JUSTIFIED);
	}
	
	// Constructor with a specified field width and justification
	public FormattedWriter(Writer output, int width, int justification)
	{
		this(output, false, width, justification);
	}
	
	// Constructor with a specified field width and autoflush option
	public FormattedWriter(Writer output, boolean autoflush, int width)
	{
		this(output, autoflush, width, RIGHT_JUSTIFIED);
	}
	
	// Helper method to form a string
	private String pad(String str)
	{
		if (width == 0)
		{
			return str;
		}
		
		int blanks = width - str.length(); // Number of blanks needed
		StringBuffer result = new StringBuffer(); // Will hold the output
		
		if (blanks < 0) // Default does not fit
		{
			// So append X's
			for(int i = 0; i < width; i++)
			{
				result.append('X');
			}
			return result.toString(); // and return the result
		}
		
		if (blanks > 0)
		{
			for(int i = 0; i < blanks; i++) // append them
			{
				result.append(' '); 
			}
		}
		
		// Insert the value string at the beginning ot the end
		result.insert(justification == LEFT_JUSTIFIED ? 0 : result.length(),
			str);
		return result.toString();
	}
	
	// Output type long formatted in a given width
	public void print(long value)
	{
		super.print(pad(String.valueOf(value))); // Pad to width and output
	}
	
	// Output type double formatted in a given width
	public void print(double value)
	{
		super.print(pad(String.valueOf(value))); // Pad to width and output
	}

	// Output type string formatted in a given width
	public void print(String value, int width)
	{
		setWidth(width);
		super.print(pad(value)); // Pad to width and output
	}
	
	// Output type long formatted in a given width
	public void println(long value)
	{
		super.println(pad(String.valueOf(value))); // Pad to width and output
	}
	
	// Output type double formatted in a given width
	public void println(double value)
	{
		super.println(pad(String.valueOf(value))); // Pad to width and output
	}

	// Output type string formatted in a given width
	public void println(String value, int width)
	{
		setWidth(width);
		super.println(pad(String.valueOf(value))); // Pad to width and output
	}
	
	public void setWidth(int width)
	{
		if (width >= 0)
		{
			this.width = width;
		}
	}
}