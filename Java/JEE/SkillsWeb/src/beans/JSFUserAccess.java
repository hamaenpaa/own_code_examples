package beans;

import javax.ejb.EJB;
import javax.faces.context.FacesContext;

import sessions.UserAccess;
import entity.User;

public class JSFUserAccess {

	private String username;
	private String password;
	
	@EJB 
	private static UserAccess ua;
	
	public JSFUserAccess() {
		// TODO Auto-generated constructor stub
	}
	
	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUsername()
	{
		return this.username;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getPassword()
	{
		return this.password;
	}
	
	public String login()
	{
		User u = ua.login(this.username, this.password);
		if (u != null) 
		{
			
			return "welcome";
		}
		else return "invalidaccess";
	}
	
}
