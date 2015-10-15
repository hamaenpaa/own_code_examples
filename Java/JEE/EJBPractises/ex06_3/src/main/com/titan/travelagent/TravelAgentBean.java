package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.titan.domain.Customer; 
import com.titan.domain.CustomerPK; 

@Stateless
public class TravelAgentBean implements TravelAgentRemote
{
    @PersistenceContext(unitName="titan") private EntityManager manager;
    
    public void createCustomer(Customer cust)
    {
	manager.persist(cust);
    }

   public Customer findCustomer(String lastName, long ssn)
   {
      CustomerPK pk = new CustomerPK(lastName, ssn);
      return manager.find(Customer.class, pk);
   }
}
