
package ejb.entity;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;


/**
 * This is the local-home interface for Company enterprise bean.
 */
public interface CompanyLocalHome extends EJBLocalHome {
    
    CompanyLocal findByPrimaryKey(int key)  throws FinderException;
    
    CompanyLocal create(int key)  throws CreateException;
    
    
}
