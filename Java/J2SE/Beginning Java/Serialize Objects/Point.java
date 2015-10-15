import java.io.Serializable;

public class Point implements Serializable
{
	// Coordinates of a point
	double x;
	double y;
	
	// Create a point from coordinates
	Point(double xVal, double yVal)
	{
		x = xVal;
		y = yVal;
	}
	
	// Create a point from another Point object
	Point(final Point oldPoint)
	{
		x = oldPoint.x; // Copy x coordinate
		y = oldPoint.y; // Copy y coordinate
	}
	
	// Move a point
	void move(double xDelta, double yDelta)
	{
		// Parameter values are increments to the current coordinates
		x += xDelta;
		y += yDelta;
	}
	
	// Calculate the distance to another point
	double distance(final Point aPoint)
	{
		return Math.sqrt((x-aPoint.x)*(x-aPoint.x)+(y-aPoint.y)*(y-aPoint.y));
	}
	
	// Convert a point to a string
	public String toString()
	{
		return Double.toString(x) + ", " + y; // As "x, y"
	}
}