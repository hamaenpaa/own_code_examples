import java.util.StringTokenizer;

public class Ch4Ex4
{
	public static void main(String[] args)	
	{
		String[] monthNames = { "January", "February", "March", "April", "May",
		    "Juny", "July", "August", "Septemper", "October", "Noverber",
		    "December"};
		
		String[] stringDates = { "10/29/99", "12/5/01", "2/28/04", 
			"3/5/03", "11/10/02", "7/30/97", "8/32/96", "4/30/01",
			"5/5/00", "9/30/01", "10/1/00", "5/2/03", "4/3/33" };
		
		String[] postFixes = { "st", "nd", "rd", "th" };

		// Extract the tokens
		for(int i = 0; i < stringDates.length; i++)		
		{
			System.out.println("Date " + stringDates[i] + " to be parsed");
			StringTokenizer st = new StringTokenizer(stringDates[i], "/"); // Create a tokenizer for it
			String[] subStr = new String[3]; // Array to hold the tokens	
			boolean allTokens = true;
			for(int j=0; j<3; j++)			
			{
				if (st.hasMoreTokens())
				{
					subStr[j] = st.nextToken();	
				}
				else
				{
					System.out.println("Date" + (i+1) + "=" + stringDates[i] 
						+ " does not contain all components"
						+ " (month/day of month/year)");					
					allTokens = false;
					break;
				}
			}
			if (allTokens)
			{
				Integer monthObject = new Integer(subStr[0]);
				int month = monthObject.intValue();
				if ((month > 0) && (month < 13))
				{
					Integer dayObject = new Integer(subStr[1]);
					int day = dayObject.intValue();
					if ((day > 0) && (day < 32))
					{
						boolean validDay = true;
						
						// Validate day
						if (month < 7 && month % 2 == 0)
						{
							if ((month == 2) && (day > 29))
							{
								validDay = false;
							}
							if (day > 30)
							{
								validDay = false;
							}
						}
						if (month > 8 && month % 2 == 1)
						{
							if (day > 30)
							{
								validDay = false;
							}
						}

						Integer yearObject = new Integer(subStr[2]);
						int year = yearObject.intValue();
						boolean validYear = true;
						if ((year < 5) && (year >= 0))
						{
							year = 2000 + year;
						}
						else if ((year > 4) && (year < 100))
						{
							year = 1900 + year;
						}
						else
						{
							System.out.println("Date" + (i+1) + "=" + stringDates[i] 
								+ " does not contain proper year");					
							validYear = false;
						}
						
						// If day, month and year are valid, choose correct postfix
						if (validDay && validYear)
						{
							System.out.print(subStr[1]);
							switch(day)
							{
								case 1 : System.out.print(postFixes[0]); break;
								case 2 : System.out.print(postFixes[1]); break;
								case 3 : System.out.print(postFixes[2]); break;
								default : System.out.print(postFixes[3]); break;
							}
							System.out.print(" " + monthNames[month-1] + " ");
						}
						else
						{
							System.out.println("Date" + (i+1) + "=" + stringDates[i] 
								+ " does not contain proper day of month");					
						}
						
						// If day, month and year are valid, display year
						if (validDay && validYear)
						{
							System.out.println(year);							
						}
					}					
					else
					{
						System.out.println("Date" + (i+1) + "=" + stringDates[i] 
							+ " does not contain proper day of month");					
					}
				}
				else
				{
					System.out.println("Date" + (i+1) + "=" + stringDates[i] 
						+ " does not contain proper month");					
				}
			}
		}
	}
}