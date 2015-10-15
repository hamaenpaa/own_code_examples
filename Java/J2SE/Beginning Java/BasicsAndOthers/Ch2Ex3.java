public class Ch2Ex3
{
	public static void main(String[] args)
	{
		double income = 2455.75;
		double tax = 35.0;
		double taxAmount = tax/100*income;
		int integerPart = (int)taxAmount;
		int cents = (int)((taxAmount-integerPart)*100);
		System.out.println("income = " + income + " tax = " + tax + 
		" tax amount as integers, " + integerPart + " dollars " + 
			+ cents + " cents");
		return;
	}
}