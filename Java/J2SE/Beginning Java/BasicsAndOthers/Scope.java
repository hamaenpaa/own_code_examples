
public class Scope
{
	public static void main(String[] args)
	{
		int outer = 1; // Exists througout the method
		
		{
			// System.out.println("inner = " + inner); // Undocument this for an error
			int inner = 2;
			System.out.println("inner = " + inner);
			System.out.println("outer = " + outer);
			
			// All variable defined in the enclosing outer block still exist
			// so you cannot redefine them here
			// int outer = 5; // Undocument this for an error
		}
		
		// Any variables declared in the previous inner block no longer exist
		// so you cannot refer to them here
		// System.out.println("inner = " + inner ); // Undocument this for an error
		
		// The previous variable, inner, does not exist so you can define a new one
		int inner = 3;
		System.out.println("inner = " + inner); // .. and output its value
		System.out.println("outer = " + outer); // outer is still around
	}
}