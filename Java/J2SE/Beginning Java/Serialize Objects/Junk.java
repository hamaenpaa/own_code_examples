import java.io.Serializable;

public class Junk implements Serializable
{
	private static java.util.Random generator = new java.util.Random();
	private int answer;       // The answer
	private double[] numbers; // Valuable data
	private String thought;   // A unique thought
	
	public Junk(String thought)
	{
		this.thought = thought;
		answer = 42;
		
		numbers = new double[3+generator.nextInt(4)]; // Array size 3 to 6
		for(int i = 0; i < numbers.length; i++) // Populate with random values
		{
			numbers[i] = generator.nextDouble();
		}
	}
	
	public String toString()
	{
		StringBuffer strBuf = new StringBuffer(thought);
		strBuf.append('\n').append(String.valueOf(answer));
		for(int i = 0; i < numbers.length; i++)
		{
			strBuf.append("\nnumbers[").append(String.valueOf(i))
				.append("] = ").append(numbers[i]);
		}
		return strBuf.toString();
	}
}
