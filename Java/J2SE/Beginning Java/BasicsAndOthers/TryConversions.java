public class TryConversions implements ConversionFactors, Conversions
{
	public double wattsToHP(double watts)
	{
		return watts * WATT_TO_HP;
	}
	
	public double hpToWatts(double hp)
	{
		return hp * HP_TO_WATT;
	}
	
	public double ouncesToGrams(double ounces)
	{
		return ounces * OUNCE_TO_GRAM;
	}

	public double poundsToGrams(double pounds)
	{
		return pounds * POUND_TO_GRAM;
	}

	public double inchesToMillimeters(double inches)
	{
		return inches * INCH_TO_MM;
	}
	
	public static void main(String[] args)
	{
		int myWeightInPounds = 180;
		int myHeightInInches = 75;
		
		TryConversions converter = new TryConversions();
		System.out.println("My weight in pounds: " + myWeightInPounds
			+ " \t-in grams: " 
			+ (int)converter.poundsToGrams(myWeightInPounds));
		System.out.println("My height in inches: " + myHeightInInches
			+ " \t-in millimeters: " 
			+ (int)converter.inchesToMillimeters(myHeightInInches));
	}
}