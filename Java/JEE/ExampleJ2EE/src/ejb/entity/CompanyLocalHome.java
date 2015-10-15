package example.ejb.entity;

import javax.ejb.*;

public interface CompanyLocalHome extends EJBLocalHome{
	
	public CompanyLocal create(String name) throws CreateException;
	
	public CompanyLocal findByPrimaryKey(String companyID)
		throws FinderException;
}
