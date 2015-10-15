
public class SwitchEx
{
	public static void main(String[] args)
	{
		int wash = 1;
		switch (wash)		
		{
			case 1 : System.out.println("Cotton = 1 selected"); break;
			case 2 : System.out.println("Linen = 2 selected"); break;
			case 3 : System.out.println("Wool = 3 selected"); break;
			default : System.out.println("Selection error"); break;
		}
		char yesNo = 'N';
		switch (yesNo)		
		{
			case 'n' : 
			case 'N' : System.out.println("No selected"); break;
			case 'y' : 
			case 'Y' : System.out.println("Yes selected"); break;
			default : System.out.println("Selection error"); break;
		}
	}	
}

