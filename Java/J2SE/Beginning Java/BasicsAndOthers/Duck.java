public class Duck extends Animal
{
	public Duck(String aName)
	{
		super("Duck");		// Call the base constructor
		name = aName;		// Supplied name
		breed = "Unknown";  // Default breed value
	}
	
	public Duck(String aName, String aBreed)
	{
		super("Duck");		// Call the base constructor
		name = aName;		// Supplied name
		breed = aBreed;     // Default breed value
	}
	
	// Return a String full of duck's details
	public String toString()
	{
		return super.toString() + "\nIt's " + name + " the " + breed;
	}
	
	// A quacking method
	public void sound()
	{
		System.out.println("Quack Quack Quack");
	}	
	
	private String name;	// Name of a duck
	private String breed;	// Duck breed
}