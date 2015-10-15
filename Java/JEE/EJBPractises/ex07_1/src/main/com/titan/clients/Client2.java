package com.titan.clients;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.titan.domain.*;

public class Client2
{
   public static void main(String[] args) throws Exception 
   {
      EntityManagerFactory factory =
         Persistence.createEntityManagerFactory("titan");
      try 
      {
         Customer cust = Client1.createCustomerAddress(factory);
         addPhoneNumbers(factory, cust);
      } 
      finally 
      {
         factory.close();
      }
   }

   public static void addPhoneNumbers(EntityManagerFactory factory, Customer cust) 
   {
      Phone phone1 = new Phone();
      phone1.setNumber("617-666-6666");
      phone1.setType((byte)1);
      cust.getPhoneNumbers().add(phone1);

      EntityManager manager = factory.createEntityManager();
      try
      {
         manager.getTransaction().begin();
         manager.merge(cust);
         manager.getTransaction().commit();
         
         manager.clear();
         Customer custCopy = manager.find(Customer.class, cust.getId());
         for (Phone phone : custCopy.getPhoneNumbers())
         {
            System.out.println("Phone number: " + phone.getNumber());
         }
      }
      finally
      {
         manager.close();
      }
   }
}
