class TryInitialization
{
	static int[] values = new int[10];  // Static array member
	
	// Initialization block
	static
	{
		System.out.println("Running initialization block.");
		for(int i=0; i<values.length; i++)
		{
			values[i] = (int)(100.0*Math.random());
		}
	}
	
	// list values in the array of the object
	void listValues()
	{
		System.out.println(); 				     // Start a new line
		for(int i=0; i<values.length; i++)
		{
			System.out.println(" " + values[i]); // Display values
		}
		System.out.println(); 				     // Start a new line		
	}
	
	public static void main(String[] args)
	{
		TryInitialization example = new TryInitialization();
		System.out.println("\nFirst object");
		example.listValues();
		
		example = new TryInitialization();		
		System.out.println("\nSecond object");
		example.listValues();
	}
}