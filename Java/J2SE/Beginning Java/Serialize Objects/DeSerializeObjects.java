import java.io.*;

public class DeSerializeObjects
{
	public static void main(String[] args)
	{
		ObjectInputStream objectsIn = null; // Stores the stream reference
		int objectCount = 0;                // Number of objects read
		Junk object = null;                 // Stores an object reference
		
		try
		{
			objectsIn = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("C:/Beg Java Stuff/JunkObjects.bin")));
				
			// Read from the stream until we hit the end
			while(true)
			{
				object = (Junk)objectsIn.readObject(); // Read an object
				objectCount++;                        // Increment the count
				System.out.println(object);           // Output the object
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		catch(EOFException e) // This will execute when we reach EOF
		{
			System.out.println("EOF reached. " + objectCount 
				+ " objects read.");
		}
		catch(IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);			
		}
		
		// Close the stream
		try
		{
			objectsIn.close(); 
		}
		catch(IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);			
		}
	}
}
