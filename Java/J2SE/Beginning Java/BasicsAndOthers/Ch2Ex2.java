

public class Ch2Ex2
{
	public static void main(String[] args)
	{
		double dValue = 134324.32432432;
		long integerPart = (long)dValue;
		short fourDecimals = (short)((dValue-integerPart)*10000);
		System.out.println("dValue = " + dValue + " as integers " 
			+ integerPart + "." + fourDecimals);
		return;
	}
}