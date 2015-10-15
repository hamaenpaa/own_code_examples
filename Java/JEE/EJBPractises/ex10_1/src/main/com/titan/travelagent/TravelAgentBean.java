package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.titan.domain.Customer; 

@Stateless
public class TravelAgentBean implements TravelAgentRemote
{
   @PersistenceContext(unitName="titan") private EntityManager manager;
    
   public int createCustomer(Customer cust)
   {
      System.out.println("--------------------------------------");
      System.out.println("Calling createCustomer():" + cust.getFirstName());
      System.out.println("Calling manager.persist()");
      manager.persist(cust);
      System.out.println("Ending createCustomer.");
      return cust.getId();
   }

   public Customer findCustomer(int pKey)
   {
      System.out.println("--------------------------------------");
      System.out.println("Calling findCustomer()");
      System.out.println("manager.find()");
      Customer cust = manager.find(Customer.class, pKey);
      System.out.println("Returning from findCustomer(): " + cust.getFirstName());
      return cust;
   }

   public void doMerge(Customer cust)
   {
      System.out.println("--------------------------------------");
      System.out.println("Calling doMerge()");
      manager.merge(cust);
      System.out.println("Returning from doMerge()");
   }

   public void doFlush(int pKey)
   {
      System.out.println("--------------------------------------");
      System.out.println("Calling doFlush()");
      System.out.println("manager.find()");
      Customer cust = manager.find(Customer.class, pKey);
      System.out.println("cust.setName()");
      cust.setFirstName("doFlush");
      System.out.println("calling manager.flush()");
      manager.flush();
      System.out.println("returning from doFlush()");
   }

   public void doRemove(int pKey)
   {
      System.out.println("--------------------------------------");
      System.out.println("Calling doRemove()");
      System.out.println("manager.find()");
      Customer cust = manager.find(Customer.class, pKey);
      System.out.println("calling manager.remove()");
      manager.remove(cust);
      System.out.println("returning from doRemove()");
   }
      
}
