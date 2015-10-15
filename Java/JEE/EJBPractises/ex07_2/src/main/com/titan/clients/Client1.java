package com.titan.clients;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.titan.domain.*;

public class Client1
{
   public static void main(String[] args) throws Exception 
   {
      EntityManagerFactory factory =
         Persistence.createEntityManagerFactory("titan");
      try 
      {
         Customer cust = createCustomerAddress(factory);
         createCreditCard(factory, cust);
      } 
      finally 
      {
         factory.close();
      }
   }

   public static Customer createCreditCard(EntityManagerFactory factory, Customer cust) 
   {
      CreditCard card = new CreditCard();
      card.setExpirationDate(new java.util.Date());
      card.setNumber("4444-4444-4444-4444");
      card.setNameOnCard("William Burke");
      card.setCreditOrganization("Capital One");
      card.setCustomer(cust);

      EntityManager manager = factory.createEntityManager();
      try
      {
         manager.getTransaction().begin();
         manager.persist(card);
         manager.getTransaction().commit();

         // Show that card.getCustomer() returns null

         manager.clear();

         CreditCard cardCopy = manager.find(CreditCard.class, card.getId());
         System.out.println("should be null: " + cardCopy.getCustomer());

         manager.getTransaction().begin();
         System.out.println("now set the owning side of the relationship");
         Customer custCopy = manager.find(Customer.class, cust.getId());
         custCopy.setCreditCard(cardCopy);
         manager.getTransaction().commit();

         manager.clear();
         
         cardCopy = manager.find(CreditCard.class, card.getId());
         System.out.println("should be set now: " + cardCopy.getCustomer().getFirstName());
      }
      finally
      {
         manager.close();
      }
      return cust;
   }

   public static Customer createCustomerAddress(EntityManagerFactory factory) 
   {
      System.out.println("Create 1st Customer");
      Customer cust = new Customer();
      cust.setFirstName("Bill");
      cust.setLastName("Burke");
      Address address = new Address();
      address.setStreet("Beacon Street");
      address.setCity("Boston");
      address.setState("MA");
      address.setZip("02115");
      cust.setAddress(address);

      EntityManager manager = factory.createEntityManager();
      try
      {
         manager.getTransaction().begin();
         manager.persist(cust);
         manager.getTransaction().commit();
      }
      finally
      {
         manager.close();
      }
      System.out.println("Address was also persisted with auto-generated key: " 
                         + address.getId());
      System.out.println("Return detached Customer instance: " + cust.getId());
      return cust;
   }
}
