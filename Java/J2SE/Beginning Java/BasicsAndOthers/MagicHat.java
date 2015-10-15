import java.util.Random; // Import Random class

public class MagicHat
{
	static int maxRabbits = 5;
	static Random select = new Random();
	
	// Constructor for a hat
	public MagicHat(String hatName)
	{
		this.hatName = hatName; // Store the hat name
		rabbits = new Rabbit[1+select.nextInt(maxRabbits)]; 
		// Random rabbits
		
		for(int i = 0; i < rabbits.length; i++)
		{
			rabbits[i] = new Rabbit();  // Create the rabbits
		}
	}
	
	// String representation of a hat
	public String toString()
	{
		// Hat name first...
		String hatString = "\n" + hatName + " contains:\n";
		
		for(int i = 0; i < rabbits.length; i++)
		{
			hatString += "\t" + rabbits[i] + " ";
			// Add the rabbits strings
		}
		
		return hatString;
	}
	
	private String hatName;   // Name of the hat
	private Rabbit rabbits[]; // Rabbits in the hat
	
	// Nested class to define a rabbit
	static class Rabbit
	{
		// A name is a rabbit name from rabbitNames followed by an integer
		static private String[] rabbitNames = 
			{ "Floppsy", "Moppsy", "Gnasher", "Thumper"	};
		static private int[] rabbitNamesCount =
			new int[rabbitNames.length]; 
		private String name; // Name of the rabbit
		
		// Constructor for a Rabbit
		public Rabbit()
		{
			int index = select.nextInt(rabbitNames.length);
			// Get random name index
			name = rabbitNames[index] + (++rabbitNamesCount[index]);
		}
		
		// String representation of a rabbit
		public String toString() 
		{
			return name;
		}
	}
}

