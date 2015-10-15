import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class AvoidOverwritingFile
{
	public static void main(String[] args)
	{
		String filepath = "C:/Beg Java Stuff/myFile.txt";
		File aFile = new File(filepath);
		FileOutputStream outputFile = null;
		if (aFile.isFile())
		{
			File newFile = aFile;
			
			// We will append "_old" to the file
			// name repeatedly until it is unique
			do
			{
				// Get the name of the file
				String name = newFile.getName();
				// Find the separator for the extension
				int period = name.indexOf('.');
				newFile = new File(newFile.getParent(),
					name.substring(0, period) + "_old"
					+ name.substring(period));
			}
			while (!aFile.renameTo(newFile)); // Stop when renaming works
		}
		
		// Now we can create the new file
		try
		{
			// Create the stream opened to append data
			outputFile = new FileOutputStream(aFile);
			System.out.println("myFile.txt output stream created");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace(System.err);
		}
	}
}