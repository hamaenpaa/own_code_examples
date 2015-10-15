import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class FileCopy
{
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.out.println("No file to copy. Application usage is:\n"
				+ "java -classpath . FileCopy \"filepath\"");
			System.exit(1);
		}
		File fromFile = new File(args[0]);
		
		if (!fromFile.exists())
		{
			System.out.println("File to copy, " + fromFile.getAbsolutePath()
				+ ", does not exist.");
			System.exit(1);				
		}
		
		File toFile = createBackupFile(fromFile);
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		try
		{
			inFile = new FileInputStream(fromFile);
			outFile = new FileOutputStream(toFile);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace(System.err);
			assert false;
		}
		
		FileChannel inChannel = inFile.getChannel();
		FileChannel outChannel = outFile.getChannel();
		
		try
		{
			int bytesWritten = 0;
			long byteCount = inChannel.size();
			while(bytesWritten < byteCount)
			{
				bytesWritten += inChannel.transferTo(bytesWritten,
					byteCount-bytesWritten, outChannel);
			}
			
			System.out.println("File copy complete. " + byteCount
				+ " bytes copied to " + toFile.getAbsolutePath());
				
			inFile.close();
			outFile.close();
		}
		catch(IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
	
	// Method to create a unique backup File object
	public static File createBackupFile(File aFile)
	{
		// Ensure we have an absolute path
		aFile = aFile.getAbsoluteFile();
		// Get the parent directory
		File parentDir = new File(aFile.getParent());
		// Get the file name
		String name = aFile.getName();
		// Find the extension separator
		int period = name.indexOf('.');
		if (period == -1)
		{
			// If there isn't one, set it to the end of the string
			period = name.length();
		}
		
		// String to be appended
		String nameAdd = "_backup";
		
		// Create a File object that is unique
		File backup = new File(name.substring(0, period) + nameAdd 
			+ name.substring(period));		
		
		while(backup.exists()) // If the name already exists
		{
			name = backup.getName(); // Get current name of the file
			period += nameAdd.length(); // Increment separator index
			backup = new File(parentDir, name.substring(0,period)
				+ nameAdd + name.substring(period)); // Add backup again
		}
		
		return backup;
	}
}
