package example.ejb.entity;

import java.io.*;

public class ProductsToBuyFromCompaniesPK 
	implements Serializable
{
	public int companyID;
	public int prodID;
	
	public ProductsToBuyFromCompaniesPK()
	{
	}
	
	public int hashCode()
	{
		return companyID + 65000 * prodID;
	}
	
	public boolean equals(Object pk)
	{
		if (pk instanceof ProductsToBuyFromCompaniesPK)
		{
			ProductsToBuyFromCompaniesPK 
			   i = (ProductsToBuyFromCompaniesPK)pk;
			if ((i.companyID == companyID) &&
				(i.prodID == prodID))
			{
				return true;
			}
		}
		return false;
	}
}
