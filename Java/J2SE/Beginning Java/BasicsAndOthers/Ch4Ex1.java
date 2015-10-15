public class Ch4Ex1
{
	public static void main(String[] args)
	{
		String[] monthNames = { "January", "February", "March", "April", "May",
		    "Juny", "July", "August", "Septemper", "October", "Noverber",
		    "December"};
		double[] decimalNumbers = new double[12];
		
		int intNumberUsedAsRandom;
		for(int i=0; i<12; i++)
		{
			intNumberUsedAsRandom = (int)(1000 * Math.random());
			decimalNumbers[i] = (double)intNumberUsedAsRandom / 10;
		}
		
		// Calculate sum and average of decimal numbers
		double sum = 0.0;
		for(int i=0; i<12; i++)
		{
			sum += decimalNumbers[i];
		}
		double avg = sum / 12;
		
		// Display the month names and the decimal numbers
		for(int i=0; i<12; i++)
		{
			System.out.println("Month: " + monthNames[i] + " has number " + 
				decimalNumbers[i] );
		}
		
		// Display the average of decimal numbers
		System.out.println("The average of numbers is  " + avg );
	}

}