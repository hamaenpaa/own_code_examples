package com.ibm.bankjsf.actions;

/** Import statements **/
import java.util.Map;
import javax.faces.context.*;

/**
 * @version 	1.0
 * @author
 */
public class LogoutAction
{
	protected FacesContext facesContext;
	protected Map sessionScope;

	private static final String CUSTOMERSSN_KEY = "customerSSN";
	private static final String SESSION_SCOPE = "#{sessionScope}";
	private static final String OUTCOME_LOGOUT = "logout";
	
    /**
     * Constructor
     */
    public LogoutAction() {

    }

    public String logout() 
    {
    	facesContext = FacesContext.getCurrentInstance();
    	sessionScope = (Map) facesContext.getApplication()
    	.createValueBinding(SESSION_SCOPE)
    	.getValue(facesContext);
    	if (sessionScope.containsKey(CUSTOMERSSN_KEY))
    	{
    		sessionScope.remove(CUSTOMERSSN_KEY);
    	}
    	return OUTCOME_LOGOUT;
    }
}
