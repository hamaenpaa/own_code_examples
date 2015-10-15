package Geometry;

public class Point
{
	// Coordinates of a point
	private double x;
	private double y;
	
	// Create a point from coordinates
	public Point(double xVal, double yVal)
	{
		x = xVal;
		y = yVal;
	}
	
	// Create a point from another Point object
	public Point(final Point oldPoint)
	{
		x = oldPoint.x; // Copy x coordinate
		y = oldPoint.y; // Copy y coordinate
	}
	
	// Move a point
	public void move(double xDelta, double yDelta)
	{
		// Parameter values are increments to the current coordinates
		x += xDelta;
		y += yDelta;
	}
	
	// Calculate the distance to another point
	public double distance(final Point aPoint)
	{
		return Math.sqrt((x-aPoint.x)*(x-aPoint.x)+(y-aPoint.y)*(y-aPoint.y));
	}
	
	// Convert a point to a string
	public String toString()
	{
		return Double.toString(x) + ", " + y; // As "x, y"
	}
	
	// Retrieve the x coordinate
	public double getX()
	{
		return x;
	}
	
	// Retrieve the y coordinate
	public double getY()
	{
		return y;
	}

	// Set the x coordinate
	public void setX(double inputX)
	{
		x = inputX;
	}
	
	// Set the y coordinate
	public void setY(double inputY)
	{
		y = inputY;
	}
}