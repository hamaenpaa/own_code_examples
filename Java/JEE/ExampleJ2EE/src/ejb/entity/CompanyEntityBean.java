package example.ejb.entity;

import javax.ejb.CreateException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import javax.ejb.RemoveException;

public abstract class CompanyEntityBean implements EntityBean 
{
	//--------------------------------------------
	// Begin abstract get/set methods
	//--------------------------------------------
	public abstract int getCompanyID();
	public abstract String getName();
	public abstract void setName(String newName);
	public abstract String getEmail();
	public abstract void setEmail(String newEmail);
	public abstract String getWebsite();
	public abstract void setWebsite(String newWebsite);
	public abstract String getPhone();
	public abstract void setPhone(String newPhone);
	public abstract String getAddress();
	public abstract void setAddress(String newAddress);
	//--------------------------------------------
	// End abstract get/set methods
	//--------------------------------------------

	public void ejbCreate(String name) throws CreateException
	{
		setName(name);
	}
	
	public void ejbPostcreate(String name)
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
