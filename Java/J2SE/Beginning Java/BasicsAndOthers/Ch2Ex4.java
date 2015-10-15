public class Ch2Ex4
{
	public static void main(String[] args)
	{
		double sunDiameterMiles = 865000.0;
		double earthDiameterMiles = 7600.0;
		double volumeOfEarthCubicMiles = 
			4*Math.PI/3*Math.pow(earthDiameterMiles/2,3);
		double volumeOfSunCubicMiles = 4*Math.PI/3*Math.pow(sunDiameterMiles/2,3);
		double volumeRatio = volumeOfSunCubicMiles / volumeOfEarthCubicMiles;
		System.out.println("Diameter of sun in miles = " +  sunDiameterMiles + 
		"\nDiameter of earth in miles = " + earthDiameterMiles + 
		"\nVolume of earth in cubic miles = " + volumeOfEarthCubicMiles + 
		"\nVolume of sun in cubic miles = " + volumeOfSunCubicMiles + "\n");
		System.out.println("Ratio of sun volume and earth volume = " +
			volumeRatio );
		return;
	}
}