package example.ejb.entity;

import javax.ejb.*;

public interface CompanyLocal extends EJBLocalObject 
{
	public int getCompanyID();
	public String getName();
	public void setName(String newName);
	public String getEmail();
	public void setEmail(String newEmail);
	public String getWebsite();
	public void setWebsite(String newWebsite);
	public String getPhone();
	public void setPhone(String newPhone);
	public String getAddress();
	public void setAddress(String newAddress);
}
