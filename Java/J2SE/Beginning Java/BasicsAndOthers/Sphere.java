public class Sphere
{
	static final double PI = 3.14; // Class variable that has a fixed value
	static int count = 0;          // Class variable to count objects
	
	// Instance variables
	double radius = 5.0;           // Radius of a sphere
	
	double xCenter = 10.0;         // 3D coordinates
	double yCenter = 10.0;         // of the center
	double zCenter = 10.0;         // of a sphere
	
	// Class constructor
	Sphere() // Default constructor
	{
		// Set the coordinates of the center
		xCenter = 0.0;  
		yCenter = 0.0;
		zCenter = 0.0;
		radius = 1.0;       // Set the radius
		++count;            // Update object count of Sphere class
	}
	
	Sphere(double x, double y, double z)
	{
		this(); // Calls default constructor and sets radius = 1.0 there
		// radius = 1.0; // Set the radius
		
		// Set the coordinates of the center
		xCenter = x;
		yCenter = y;
		zCenter = z;
		// Default constructor updates object count of Sphere class
		// ++count;	  	    // Update object count of Sphere class
	}
	
	Sphere(double theRadius, double x, double y, double z)
	{
		this(x, y, z); // Calls the constructor before
		radius = theRadius; // Set the radius, must be set after call
		// to constructor to be left as final value
		
		// Coordinates are set by the constructor before
		// Set the coordinates of the center
		// xCenter = x;
		// yCenter = y;
		// zCenter = z;
		// constructor before and default constructor there 
		// updates object count of Sphere class
		// ++count;	  	    // Update object count of Sphere class
	}
	
	Sphere(final Sphere oldSphere)
	{
		// Copy the values from the other Sphere object
		radius = oldSphere.radius;
		xCenter = oldSphere.xCenter;
		yCenter = oldSphere.yCenter;
		zCenter = oldSphere.zCenter;
	}
	
	// Static method to report the number of objects created
	static int getCount() 
	{
		return count;			   // Return current object count
	}
	
	// Instance method to calculate volume
	double volume()
	{
		return 4.0/3.0*PI*radius*radius*radius;
	}
	
	
}