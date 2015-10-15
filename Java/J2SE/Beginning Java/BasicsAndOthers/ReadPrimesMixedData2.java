import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class ReadPrimesMixedData2
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
			ByteBuffer buf = ByteBuffer.allocateDirect(1024);
			// Set the position for the loop operation
			buf.position(buf.limit()); 
			
			// Stores the string length
			int strLength = 0; 
			// A reference to an array to hold the string
			byte[] strChars = null;
			
			while(true)
			{
				// Verify enough bytes for string length
				if (buf.remaining() < 8) 
				{
					// If not, replenish the buffer
					if (replenish(inChannel, buf) == -1)
					{
						break; // Exit loop on EOF
					}
					else
					{
						buf.flip();
					}
				}
				
				// Extract the length and convert to int
				strLength = (int)buf.getDouble();

				// Verify enough bytes for complete string
				if (buf.remaining() < strLength)
				{
					// If not, replenish the buffer
					if (replenish(inChannel, buf) == -1)
					{
						assert false; // We should never arrive here
					}
					else
					{
						buf.flip();
					}
				}

				System.out.println("String length: " + strChars.length 
					+ "  String: " + new String(strChars) 
					+ "  Binary value: " + buf.getLong());
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
	
	public static int replenish(FileChannel channel, ByteBuffer buf)
		throws IOException
	{
		// Number of bytes left in file
		long bytesLeft = channel.size() - channel.position();
		if (bytesLeft == 0L)
		{
			return -1; // If there are none, we have reached the end
		}
		
		buf.compact().limit(buf.position() +
			(bytesLeft < buf.remaining() ? (int)bytesLeft : buf.remaining()));
		return channel.read(buf);
	}
}
