import java.io.*;
import java.nio.*;
import java.nio.channels.*; // For FileChannel and FileLock

public class LockingPrimesRead
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
			int primesRead = 0;
			FileLock inLock = null;
			while(true)
			{
				int tryLockCount = 0;
				
				// Get a lock on the file region we want to read
				while(true)
				{
					inLock = inChannel.tryLock(inChannel.position(), 
						buf.remaining(), false);
						
					if (inLock == null)
					{
						if (++tryLockCount < 100)
						{
							try
							{
								Thread.sleep(200);
							}
							catch(InterruptedException e)
							{
								e.printStackTrace(System.err);
							}
							continue;
						}
						else
						{
							System.out.println("Failed to acquire lock after "
								+ tryLockCount + " tries. Terminating...");
							System.exit(1);
						}
					}
					else
					{
						System.out.println("Acquired file lock.");
						break;
					}
				}
				
				// Now read the file
				if (inChannel.read(buf) == -1)
				{
					break;
				}
				inLock.release();
				System.out.println("Released file lock.");
				
				LongBuffer longBuf = ((ByteBuffer)(buf.flip())).asLongBuffer();
				primesRead = longBuf.remaining();
				longBuf.get(primes, 0, longBuf.remaining());
				
				StringBuffer str = null;
				for(int i = 0; i < primesRead; i++)
				{
					if (i%6 == 0)
					{
						System.out.println();
					}
					str = new StringBuffer("           ").append(primes[i]);
					System.out.println(str.substring(str.length()-12));
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
