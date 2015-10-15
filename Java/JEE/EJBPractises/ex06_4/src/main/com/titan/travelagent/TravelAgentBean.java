package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.titan.domain.Customer; 

@Stateless
public class TravelAgentBean implements TravelAgentRemote
{
    @PersistenceContext(unitName="titan") private EntityManager manager;
    
    public long createCustomer(Customer cust)
    {
	manager.persist(cust);
        return cust.getId();
    }

   public Customer findCustomer(long pk)
   {
      return manager.find(Customer.class, pk);
   }
}
