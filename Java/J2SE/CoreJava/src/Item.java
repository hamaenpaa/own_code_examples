
public class Item implements Comparable<Item>
{
	private int partNumber;
	private String description;
	
	public Item(String aDescription,int aPartNumber)
	{
		this.description = aDescription;
		this.partNumber = aPartNumber;
	}

	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String newDescription)
	{
		this.description = newDescription;
	}
	
    public int compareTo(Item other)
    {
    	return partNumber - other.partNumber; 
    }
    
    public boolean equals(Object otherObject)
    {
    	if (this == otherObject) return true;
    	if (otherObject == null) return false;
    	if (getClass() != otherObject.getClass()) return false;
    	Item other = (Item)otherObject;
    	return description.equals(other.description) && 
    	    partNumber == other.partNumber;
    }
    
    public String toString()
    {
    	return "[description="+description+
    	       ",partNumber="+partNumber+"]";
    }
    
    public int hashCode()
    {
    	return 13 * description.hashCode() + 17 * partNumber;
    }
}
