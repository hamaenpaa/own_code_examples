public class Cat extends Animal
{
	public Cat(String aName)
	{
		super("Cat");		// Call the base constructor
		name = aName;		// Supplied name
		breed = "Unknown";  // Default breed value
	}
	
	public Cat(String aName, String aBreed)
	{
		super("Cat");		// Call the base constructor
		name = aName;		// Supplied name
		breed = aBreed;     // Default breed value
	}
	
	public String toString()
	{
		return super.toString() + "\nIt's " + name + " the " + breed;
	}
	
	// A miaowing method
	public void sound()
	{
		System.out.println("Miiaooww");
	}
	
	private String name;	// Name of a cat
	private String breed;	// Cat breed
}
