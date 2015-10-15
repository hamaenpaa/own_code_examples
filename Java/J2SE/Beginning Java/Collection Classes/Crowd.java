import java.util.*;

public class Crowd
{
	// Constructor
	public Crowd()
	{
		// Create default Vector object to hold people
		people = new Vector();
	}
	
	public Crowd(int numPersons)
	{
		// Create Vector object to hold people with given capacity
		people = new Vector(numPersons);
	}
	
	// Add a person to the crowd
	public boolean add(Person someone)
	{
		return people.add(someone); // Use the Vector method to add
	}
	
	// Geta person at a given index
	public Person get(int index)
	{
		return (Person)people.get(index);
	}
	
	// Get number of persons in crowd
	public int size()
	{
		return people.size();
	}
	
	// Get people store capacity
	public int capacity()
	{
		return people.capacity();
	}
	
	// Get an iterator for the crowd
	public Iterator iterator()
	{
		return people.iterator();
	}
	
	// Person store - only accessible through methods of this class
	private Vector people;
}