public class Ch3Ex1
{
	public static void main(String[] args)
	{
		// Do this without arrays
		String firstChoise = "scrambled eggs";
		String secondChoise = "waffles";
		String thirdChoise = "fruit";
		String fourthChoise = "cereal";
		String fifthChoise = "toast";
		String sixthChoise = "yogurt";
		
		String strChoise = "";
		int choise = 1 + (int)(5*Math.random());
		switch(choise)
		{
			case 1 : strChoise = firstChoise; break;
			case 2 : strChoise = secondChoise; break;
			case 3 : strChoise = thirdChoise; break;
			case 4 : strChoise = fourthChoise; break;
			case 5 : strChoise = fifthChoise; break;
			case 6 : strChoise = sixthChoise; break;
			default : strChoise = "Not a choise"; break;
		}
		System.out.println("Your choise for breakfast was " + strChoise);
	}
}