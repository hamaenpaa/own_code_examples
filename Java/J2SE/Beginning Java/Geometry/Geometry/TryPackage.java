package Geometry;
import Geometry.*;

public class TryPackage
{
	public static void main(String[] args)
	{
		double[][] coords = { {1.0, 0.0}, {6.0, 0.0}, {6.0, 10.0},
			{10.0, 10.0}, {10.0, -14.0}, {8.0, -14.0} };
			
		// Create an array of points and fill it with Point objects
		Point[] points = new Point[coords.length];
		for(int i = 0; i < coords.length; i++)	
		{
			points[i] = new Point(coords[i][0], coords[i][1]);
		}
		
		// Create an array of lines and fill it using Point pairs
		Line[] lines = new Line[points.length - 1];
		double totalLength = 0.0;
		for(int i = 0; i < points.length - 1; i++)
		{
			lines[i] = new Line(points[i], points[i+1]);
			totalLength += lines[i].length();
			System.out.println("Line " + (i+1) + ' ' + lines[i] +
				"  length is " + lines[i].length());
		}
		
		Point l1p1 = new Point(0.0, 3.0);
		Point l1p2 = new Point(2.0, 0.0);
		Line line1 = new Line(l1p1,l1p2);
		
		Point l2p1 = new Point(2.0,3.0);
		Point l2p2 = new Point(0.0,4.0);
		Line line2 = new Line(l2p1,l2p2);
		
		Point intersectpoint = line1.intersects(line2);
		System.out.println("Line1 " + line1 + " intersects with line2 " + 
				line2 + " at point " + intersectpoint);
		
		
		
		// Output the total length
		System.out.println("\nTotal line length = " + totalLength);
	}
}