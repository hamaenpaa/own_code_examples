import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class PrimesToFile3
{
	public static void main(String[] args)
	{
		int primesRequired = 100; // Default prime count
		if (args.length > 0)
		{
			try 
			{
				primesRequired = Integer.valueOf(args[0]).intValue();
			}
			catch (NumberFormatException e)
			{
				System.out.println("Prime count value invalid. Using defautl of "
					+ primesRequired);
			}
		}
		
		// Code to generate the primes
		long[] primes = new long[primesRequired]; // Array to store primes
		primes[0] = 2;							  // Seed the first prime
		primes[1] = 3;                            // and the second
		// Count of primes found - up to now, which is also the array index
		int count = 2;
		// Next integer to be tested
		long number = 5;
		
		outer:
		for(; count < primesRequired; number += 2)
		{
			// The maximum divisor we need to try is square root of number
			long limit = (long)Math.ceil(Math.sqrt((double)number));
			
			// Divide by all the primes we have up to limit
			for(int i = 1; i < count && primes[i] <= limit; i++)
			{
				if (number % primes[i] == 0) // Is that exact divisor?
				{
					continue outer; // Yes, try the next number
				}
			}
			
			primes[count++] = number; // We got one!
		}
		
		// Code to write the file
		File aFile = new File("C:/Beg Java Stuff/primes.txt");
		FileOutputStream outputFile = null;
		try
		{
			outputFile = new FileOutputStream(aFile);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		FileChannel file = outputFile.getChannel();
		final int BUFFER_SIZE = 1024; // Byte buffer size
		ByteBuffer buf = ByteBuffer.allocate(BUFFER_SIZE);
		String primeStr = null;
		
		// Count of primes written to file
		int primesWritten = 0;

		while(primesWritten < primes.length)
		{
			while (primesWritten < primes.length)
			{
				// Create the string				
				primeStr = "Prime = " + primes[primesWritten]; 
				
				if ((buf.position() + 2 * primeStr.length() + 16) > buf.limit())
				{
					break;
				}
				
				buf.asDoubleBuffer().put(0, (double)primeStr.length());
				buf.position(buf.position() + 8);
				buf.position(buf.position() 
					+ 2 * buf.asCharBuffer().put(primeStr).position());
				buf.asLongBuffer().put(primes[primesWritten++]);
				buf.position(buf.position() + 8);
			}
		}
		buf.flip();
			
		try
		{
			file.write(buf); // Write the buffer as before
		}
		catch(IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		try
		{
			System.out.println("File written is " + file.size() + " bytes.");
			outputFile.close(); // Close the file and its channel
		}
		catch (IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
}