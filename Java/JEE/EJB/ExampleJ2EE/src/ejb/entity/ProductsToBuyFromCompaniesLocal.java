package example.ejb.entity;

import java.util.Date;

import javax.ejb.*;

public interface ProductsToBuyFromCompaniesLocal extends EJBLocalObject
{
	public int getCompanyID();
	public void setCompanyID(int newCompanyID);
	public int getProdID();
	public void setProdID(int newProdID);
	public double getPrice();
	public void setPrice(double newPrice);
	public int getStock();
	public void setStock(int newStock);
	public Date getAvailableAt();
	public void setAvailableAt(Date newAvailableAt);
}
