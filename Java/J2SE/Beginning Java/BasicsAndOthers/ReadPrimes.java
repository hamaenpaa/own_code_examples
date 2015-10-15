import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class ReadPrimes
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
		final int PRIMECOUNT = 6;
		ByteBuffer buf = ByteBuffer.allocate(8*PRIMECOUNT);
		long[] primes = new long[PRIMECOUNT];
		try
		{
			while(inChannel.read(buf) != -1)
			{
				((ByteBuffer)(buf.flip())).asLongBuffer().get(primes);
				
				System.out.println();
				for(int i = 0; i < primes.length; i++)
				{
					System.out.println("   " + primes[i]);
				}
				
				buf.clear(); // Clear the buffer for the next read
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