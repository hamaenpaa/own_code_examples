import java.io.*;

public class TestData
{
	public static void main(String[] args)
	{
		Data data = new Data(1);
		try
		{
			// Create the object output stream
			ObjectOutputStream objectOut = 
				new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream("C:/Beg Java Stuff/dataObjects.bin")));
				
			// Write three variants of the object to the file
			objectOut.writeObject(data); // Write object
			System.out.println("1st Object written has value: " 
				+ data.getValue());
			data.setValue(2);            // Modify the object
			objectOut.writeObject(data); // and write it again
			System.out.println("2nd Object written has value: " 
				+ data.getValue());
			data.setValue(2);            // Modify the object
			objectOut.writeObject(data); // and write it again
			System.out.println("3rd Object written has value: " 
				+ data.getValue());
			objectOut.close();           // Close the output stream
		}
		catch(IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		
		// Read the three objects back from the file
		System.out.println("\nReading objects from the file: ");
		try
		{
			// Create the object input stream
			ObjectInputStream objectIn = 
				new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("C:/Beg Java Stuff/dataObjects.bin")));
				
			Data data1 = (Data)objectIn.readObject();
			Data data2 = (Data)objectIn.readObject();
			Data data3 = (Data)objectIn.readObject();
			
			System.out.println("1st object is " + 
				(data1.equals(data2) ? "" : "not ") + " equal to 2nd object");
			System.out.println("2nd object is " + 
				(data2.equals(data3) ? "" : "not ") + " equal to 3rd object");
				
			// Display object values:
			System.out.println("data1 = " + data1.getValue() 
				+ "data2 = " + data2.getValue() 
				+ "data3 = " + data3.getValue());
			objectIn.close();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		catch(IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
	}
}