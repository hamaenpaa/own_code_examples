public class TestFormattedInput
{
	public static void main(String[] args)
	{
		FormattedInput kb = new FormattedInput();
		for(int i = 0; i < 5; i++)
		{
			try
			{
				System.out.println("Enter an integer: ");
				System.out.println("Integer read: " + kb.readInt());
				System.out.println("Enter a double value: ");
				System.out.println("Double value read: " + kb.readDouble());
				System.out.println("Enter a string: ");
				System.out.println("String read: " + kb.readString());
			}
			catch (InvalidUserInputException e)
			{
				System.out.println("InvalidUserInputException thrown.\n" 
					+ e.getMessage());
			}
		}
	}
}