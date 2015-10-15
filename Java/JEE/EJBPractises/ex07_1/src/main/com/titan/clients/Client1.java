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
         cascadeMergeAddress(factory, cust);
         cascadeRemoveAddress(factory, cust);
      } 
      finally 
      {
         factory.close();
      }
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

   public static void cascadeMergeAddress(EntityManagerFactory factory, Customer cust)
   {
      System.out.println("Show cascade merge()");
      cust.getAddress().setStreet("1 Yawkey Way");

      EntityManager manager = factory.createEntityManager();
      try
      {
         manager.getTransaction().begin();
         manager.merge(cust);
         manager.getTransaction().commit();

         manager.clear();
         Customer custCopy = manager.find(Customer.class, cust.getId());
         System.out.println(custCopy.getAddress().getStreet());
      }
      finally
      {
         manager.close();
      }
   }

   public static void cascadeRemoveAddress(EntityManagerFactory factory, Customer cust)
   {
      System.out.println("Show cascade remove()");
      EntityManager manager = factory.createEntityManager();

      try
      {
         manager.getTransaction().begin();
         Customer custCopy = manager.find(Customer.class, cust.getId());
         manager.remove(custCopy);
         manager.getTransaction().commit();
         
         Address addressCopy = manager.find(Address.class, cust.getAddress().getId());
         System.out.println("addressCopy is null: " + addressCopy);
      }
      finally
      {
         manager.close();
      }
   }
}
