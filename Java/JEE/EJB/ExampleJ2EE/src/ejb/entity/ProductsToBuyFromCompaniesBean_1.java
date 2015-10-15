package ejb.entity;

import javax.ejb.*;
import java.util.Date;

/**
 * This is the bean class for the ProductsToBuyFromCompaniesBean enterprise bean.
 * Created 22.5.2006 16:27:04
 * @author Harri M‰enp‰‰
 */
public abstract class ProductsToBuyFromCompaniesBean_1 implements EntityBean, ProductsToBuyFromCompaniesLocalBusiness {
    private EntityContext context;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click on the + sign on the left to edit the code.">
    // TODO Consider creating Transfer Object to encapsulate data
    // TODO Review finder methods
    /**
     * @see javax.ejb.EntityBean#setEntityContext(javax.ejb.EntityContext)
     */
    public void setEntityContext(EntityContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbActivate()
     */
    public void ejbActivate() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbPassivate()
     */
    public void ejbPassivate() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbRemove()
     */
    public void ejbRemove() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#unsetEntityContext()
     */
    public void unsetEntityContext() {
        context = null;
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbLoad()
     */
    public void ejbLoad() {
        
    }
    
    /**
     * @see javax.ejb.EntityBean#ejbStore()
     */
    public void ejbStore() {
        
    }
    // </editor-fold>
    
    
    public abstract int getCompanyID();
    public abstract void setCompanyID(int companyID);
    public abstract int getProdID();
    public abstract void setProdID(int prodID);
    public abstract double getPrice();
    public abstract void setPrice(double prodID);
    public abstract int getStock();
    public abstract void setStock(int prodID);
    public abstract Date getAvailableAt();
    public abstract void setAvailableAt(Date prodID);
    
    public ProductsToBuyFromCompaniesPK ejbCreate(int companyID, int prodID, int stock, 
                Date availableAt, double price)  throws CreateException {
        if (stock < 0 ) {
            throw new CreateException("The field stock must not be negative");
        }
        if (price < 0 ) {
            throw new CreateException("The field price must not be negative");
        }
        
        // TODO add additional validation code, throw CreateException if data is not valid
        setCompanyID(companyID);
        setProdID(companyID);
        setStock(stock);
        setPrice(stock);
        setAvailableAt(availableAt);
        
        return null;
    }
    
    public void ejbPostCreate(int companyID, int prodID, int stock, 
                Date availableAt, double price) {
        // TODO populate relationships here if appropriate
    }
}
