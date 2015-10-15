public class Ch3Ex4
{
	public static void main(String[] args)
	{
		int nOfChoises = 'Z' - 'B';
		long length = (long)(Math.random() * 200 /*Long.MAX_VALUE*/);
		char symbol;
		for(int i=0; i < length;)
		{
			symbol = (char)('B' + nOfChoises * Math.random());
			if ((symbol != 'E') && (symbol != 'I') && (symbol != 'O') &&
			 	(symbol != 'U') && (symbol != 'Y'))
			{
				System.out.print(symbol);
				i++;
			}
		}
	}
}