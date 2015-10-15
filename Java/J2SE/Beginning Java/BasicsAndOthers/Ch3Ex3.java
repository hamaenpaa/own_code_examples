public class Ch3Ex3
{
	public static void main(String[] args)
	{
		// Calculate five rows
		// Not using arrays, so six separate variables...
		int first, second, third, fourth, fifth, sixth;
		first = second = third = fourth = fifth = sixth = 1;
		for(int row=1; row <= 5; row++)
		{
			for(int iNumber=1; iNumber <=6;)
			{
				int number = 1+(int)(Math.random()*48);
				if (iNumber == 1)
				{
					first = number;
				}
				else if (iNumber == 2)
				{
					if (number != first)
					{
						second = number;
					}
					else
					{
						continue;
					}
				}
				else if (iNumber == 3)
				{
					if (number != first && number != second)
					{
						third = number;
					}
					else
					{
						continue;
					}
				}
				else if (iNumber == 4)
				{
					if (number != first && number != second && number != third)
					{
						fourth = number;
					}
					else
					{
						continue;
					}
				}
				else if (iNumber == 5)
				{
					if (number != first && number != second && number != third
						&& number != fourth)
					{
						fifth = number;
					}
					else
					{
						continue;
					}
				}
				else if (iNumber == 6)
				{
					if (number != first && number != second && number != third
						&& number != fourth && number != fifth)
					{
						sixth = number;
					}
					else
					{
						continue;
					}
				}					
				iNumber++;
			}
			System.out.println("Row " + row + " is " + first + "," 
				+ second + "," + third + "," + fourth + "," + fifth +
				"," + sixth);
		}
	}
}