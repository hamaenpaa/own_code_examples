import java.io.*;

public class TryPolyLine
{
	public static void main(String[] args)
	{
		// Create an array of coordinate pairs
		double[][] coords = { {1. , 1.}, {1. , 2.},
		{ 2., 3. }, { -3., 5. }, { -5., 1. }, { 0., 0. } };
		
		// Create a polyline from the coordinates and display it
		PolyLine polygon = new PolyLine(coords);
		System.out.println(polygon);
		
		// Add a point and display the polyline again
		polygon.addPoint(10., 10.);
		System.out.println(polygon);
		
		// Create Point objects from the coordinate array
		Point[] points = new Point[coords.length];
		for(int i = 0; i < points.length; i++)
		{
			points[i] = new Point(coords[i][0], coords[i][1]);
		}
		
		// Use the points to create a new polyline and display it
		PolyLine newPoly = new PolyLine(points);
		System.out.println(newPoly);
		
		// Write both polyline objects to the file
		try
		{
			// Create the object output stream
			ObjectOutputStream objectOut = 
				new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream("C:/Beg Java Stuff/Polygons.bin")));
				
			objectOut.writeObject(polygon); // Write the first object
			objectOut.writeObject(newPoly); // Write the second object
			objectOut.close();              // Close the output stream
		}
		catch(IOException e)
		{
			e.printStackTrace(System.err);
			System.exit(1);
		}
		
		// Read objects back from the file
		System.out.println("\nReading objects from the file: ");
		try
		{
			// Create the object input stream
			ObjectInputStream objectIn = 
				new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("C:/Beg Java Stuff/Polygons.bin")));
				
			PolyLine theLine = (PolyLine)objectIn.readObject();
			System.out.println(theLine); // Display the first object
			theLine = (PolyLine)objectIn.readObject();
			System.out.println(theLine); // Display the second object
			objectIn.close(); // Close the input stream
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