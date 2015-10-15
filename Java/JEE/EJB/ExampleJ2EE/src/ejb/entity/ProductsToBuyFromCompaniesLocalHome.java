package example.ejb.entity;

import javax.ejb.*;

public interface ProductsToBuyFromCompaniesLocalHome extends EJBLocalHome
{
	public ProductsToBuyFromCompaniesLocal create(String name) throws CreateException;
	
	public ProductsToBuyFromCompaniesLocal findByPrimaryKey(ProductsToBuyFromCompaniesPK pk)
		throws FinderException;
}
