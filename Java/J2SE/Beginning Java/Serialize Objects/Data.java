import java.io.Serializable;

public class Data implements Serializable
{
	private int value;
	
	public Data(int init)	
	{
		value = init;
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof Data && ((Data)obj).value == value)
		{
			return true;
		}
		return false;
	}
	
	public void setValue(int val)
	{
		value = val;
	}
	
	public int getValue()
	{
		return value;	
	}
}
