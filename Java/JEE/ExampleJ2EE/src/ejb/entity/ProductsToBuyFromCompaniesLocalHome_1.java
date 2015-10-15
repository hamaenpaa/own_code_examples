
package ejb.entity;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for ProductsToBuyFromCompanies enterprise bean.
 */
public interface ProductsToBuyFromCompaniesLocalHome_1 extends EJBLocalHome {
    
    ProductsToBuyFromCompaniesLocal_1 findByPrimaryKey(Integer key)  throws FinderException;
    
    ProductsToBuyFromCompaniesLocal_1 create(Integer key)  throws CreateException;
    
    
}
