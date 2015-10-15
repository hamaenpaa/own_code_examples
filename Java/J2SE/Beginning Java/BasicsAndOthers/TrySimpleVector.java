import java.util.*;

public class TrySimpleVector
{
	public static void main(String[] args)
	{
		Vector names = new Vector();
		String[] firstNames = { "Jack", "Jill", "John",
			"Joan", "Jeremiah", "Josephine"	};
			
		for(int i = 0; i < firstNames.length; i++)
		{
			names.add(firstNames[i]);
		}
		
		for(int i = 0; i < names.size(); i++)
		{
			System.out.println((String)names.get(i));
		}
	}
}