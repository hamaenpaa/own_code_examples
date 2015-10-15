import java.io.Serializable;

public class ListItem implements Serializable
{
	public ListItem(Object item)
	{
		this.item = item; // Store the item
		next = null;	  // Set next as end point
	}
	
	// Return class name & object
	public String toString()
	{
		return "ListItem " + item;
	}
	
	ListItem next;  // Refers to next item in the list
	Object item;    // The item for this ListItem
}