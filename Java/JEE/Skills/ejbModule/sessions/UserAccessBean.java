package sessions;

import javax.ejb.Stateful;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.*;

import entity.User;
import javax.inject.Named;

/**
 * Session Bean implementation class useraccess
 */

@Named("useraccess")
@Stateful
public class UserAccessBean implements UserAccess {

	private String username;
	private String password;
	
	@PersistenceContext(unitName="Skills")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public UserAccessBean() {
        
    }
    
    public void setUsername(String username)
    {
    	this.username = username;
    }
    
    public String getUsername() { return this.username; }
    
    public void setPassword(String password) 
    {
    	this.password = password;
    	
    }
    
    public User login()
    {
       Query q = em.createNamedQuery("checklogin");
       q.setParameter("username", this.username);
       q.setParameter("password", this.password);
       List<User> users = (List<User>)q.getResultList();
       if (users.size() == 1) return users.get(0);
       return null;
    }
}

