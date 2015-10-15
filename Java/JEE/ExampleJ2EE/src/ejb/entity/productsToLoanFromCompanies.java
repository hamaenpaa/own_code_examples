package example.ejb.entity;

import java.rmi.RemoteException;
import java.util.Date;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

public abstract class productsToLoanFromCompanies implements EntityBean 
{
	//--------------------------------------------
	// Begin abstract get/set methods
	//--------------------------------------------
	public abstract int getCompanyID();
	public abstract void setCompanyID(int newCompanyID);
	public abstract int getProdID();
	public abstract void setProdID(int newProdID);
	public abstract int getStock();
	public abstract void setStock(int newStock);
	public abstract Date getAvailableAt();
	public abstract void setAvailableAt(Date newAvailableAt);
	//--------------------------------------------
	// End abstract get/set methods
	//--------------------------------------------
	
	public void setEntityContext(EntityContext ctx)  
	{
	}

	public void unsetEntityContext() 
	{
	}

	public void ejbCreate(int companyID, int prodID, int stock, Date availableAt)
 	throws CreateException
	{
		if (stock<0)
		{
			throw new CreateException("stock is not negative!");
		}
		setCompanyID(companyID);
		setProdID(prodID);
		setAvailableAt(availableAt);
		setStock(stock);
	}
	
	public void ejbPostCreate(int companyID, int prodID, int stock, Date availableAt)
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
