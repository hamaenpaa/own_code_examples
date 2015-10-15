import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class ReadPrimesMixedData
{
	public static void main(String[] args)
	{
		File aFile = new File("C:/Beg Java Stuff/primes.bin");
		FileInputStream inFile = null;
		
		try
		{
			inFile = new FileInputStream(aFile);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		
		FileChannel inChannel = inFile.getChannel();
		
		try
		{
			ByteBuffer lengthBuf = ByteBuffer.allocate(8);
			
			// Stores the string length
			int strLength = 0; 
			// Stores a reference to the second byte buffer
			ByteBuffer buf = null; 
			// A reference to an array to hold the string
			byte[] strChars = null;
			
			while(true)
			{
				if (inChannel.read(lengthBuf) == -1) // Read the string length
				{
					break; // If its EOF exit the loop
				}
				
				lengthBuf.flip(); 
				
				// Extract the length and convert to int
				strLength = (int)lengthBuf.getDouble();
				
				// Read the string & binary prime value
				if (inChannel.read(buf) == -1) 
				{
					assert false; // Should not get here!
					break;
				}
				buf.flip();
				
				// Create the array for the string
				strChars = new byte[strLength]; 
				// Extract string & binary prime value
				buf.get(strChars);
				
				System.out.println("String length: " + strChars.length 
					+ "  String: " + new String(strChars) 
					+ "  Binary value: " + buf.getLong());
					
				// Clear the buffer for the next read
				lengthBuf.clear();
			}
			
			System.out.println("\nEOF reached");
			inFile.close(); // Close the file and the channel
		}
		catch(IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
}
