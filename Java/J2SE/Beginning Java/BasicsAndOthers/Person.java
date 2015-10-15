public class Person
{
	// Constructor
	public Person(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String toString()
	{
		return firstName + " " + lastName;
	}
	
	private String firstName; // First name of person
	private String lastName;  // Last name of person
}