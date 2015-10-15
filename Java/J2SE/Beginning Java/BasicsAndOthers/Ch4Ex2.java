public class Ch4Ex2
{
	// The size of the multiplication table to be created, calculated and 
	// displayed
	public static final int TABLE_SIZE = 12;
	
	public static void main(String[] args)
	{
		// Build the multiplication table and calculate multiplication results
		int[][] multiplyTable = new int[TABLE_SIZE][TABLE_SIZE];
		for(int i=1; i< TABLE_SIZE+1; i++)
		{
			for(int j=1; j<TABLE_SIZE+1; j++)
			{
				multiplyTable[i-1][j-1] = i * j;
			}
		}
		
		// Find in which column there should be room for 3 digits
		int iBiggerColumn = TABLE_SIZE+2;
		for(int iColumn=1; iColumn < TABLE_SIZE+1; iColumn++)
		{
			if (iColumn* (TABLE_SIZE) > 99) 
			{
				iBiggerColumn = iColumn;
				break;
			}
		}
		
		// Display the first ( header ) row:
		System.out.print("  ");
		if (TABLE_SIZE > 9) System.out.print(" "); 
		for(int i=1; i< TABLE_SIZE+1; i++)
		{
			if (i >= iBiggerColumn && i < 10) System.out.print(" ");
			System.out.print(" " + i + " ");
		}
		System.out.println();

		// Display the result rows:		
		for(int i=1; i<TABLE_SIZE+1; i++)
		{
			if (i<10 && TABLE_SIZE > 9) System.out.print(" ");
			System.out.print(i + " ");
			for(int j=1; j<TABLE_SIZE+1; j++)
			{
				int iOut = multiplyTable[i-1][j-1];
				if (iOut < 10) System.out.print(" ");
				if (j >= iBiggerColumn && iOut < 100) System.out.print(" ");
				System.out.print( iOut + " " );
			}
			System.out.println();
		}
	}
}