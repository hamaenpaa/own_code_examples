package example.ejb.entity;

import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;
import javax.ejb.CreateException;
import java.util.Date;

public abstract class ProductsToBuyFromCompaniesBean implements EntityBean 
{
	//--------------------------------------------
	// Begin abstract get/set methods
	//--------------------------------------------
	public abstract int getCompanyID();
	public abstract void setCompanyID(int newCompanyID);
	public abstract int getProdID();
	public abstract void setProdID(int newProdID);
	public abstract double getPrice();
	public abstract void setPrice(double newPrice);
	public abstract int getStock();
	public abstract void setStock(int newStock);
	public abstract Date getAvailableAt();
	public abstract void setAvailableAt(Date newAvailableAt);
	//--------------------------------------------
	// End abstract get/set methods
	//--------------------------------------------

	public void ejbCreate(int companyID, int prodID, int stock, double price, Date availableAt)
	 	throws CreateException
	{
		if (price<0)
		{
			throw new CreateException("price is not negative!");
		}
		if (stock<0)
		{
			throw new CreateException("stock is not negative!");
		}
		setCompanyID(companyID);
		setProdID(prodID);
		setPrice(price);
		setAvailableAt(availableAt);
		setStock(stock);
	}
	
	public void ejbPostCreate(int companyID, int prodID, int stock, double price, Date availableAt)
	{
		
	}
	
	public void setEntityContext(EntityContext ctx) 
	{
	}

	public void unsetEntityContext() 
	{
	}

	public void ejbRemove() throws RemoveException
	{
	}

	public void ejbActivate() 
	{
	}

	public void ejbPassivate() 
	{
	}

	public void ejbLoad() 
	{
	}

	public void ejbStore()  
	{
	}
}
