package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class UsingDistinct
{
   public static void main(String[] args) throws Exception 
   {
      HashMap map = new HashMap();
      //map.put("hibernate.show_sql", "true");
      EntityManagerFactory factory =
         Persistence.createEntityManagerFactory("titan", map);
      EntityManager entityManager = factory.createEntityManager();
      entityManager.getTransaction().begin();
      try 
      {
         System.out.println("Initialize DB");
         InitializeDB.initialize(entityManager);
         System.out.println();
         System.out.println();
         
         usingDistinct(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void usingDistinct(EntityManager manager)
   {
      System.out.println("USING DISTINCT");
      System.out.println("--------------------------------");
      System.out.println("Non-distinct: ");
      System.out.println("SELECT cust");
      System.out.println("FROM Reservation res, IN (res.customers) cust");
      Query query;
      query = manager.createQuery("SELECT cust " +
                                  "FROM Reservation res, " +
                                  "IN (res.customers) cust");
                                  
      List customers = query.getResultList();
      Iterator it = customers.iterator();
      while (it.hasNext())
      {
         Customer cust = (Customer)it.next();
         System.out.println("   " + cust.getFirstName() + " has a reservation.");
      }
      System.out.println("");
      System.out.println("Distinct: ");
      System.out.println("SELECT DISTINCT cust");
      System.out.println("FROM Reservation res, IN (res.customers) cust");
      query = manager.createQuery("SELECT DISTINCT cust " +
                                  "FROM Reservation res, " +
                                  "IN (res.customers) cust");
                                  
      customers = query.getResultList();
      it = customers.iterator();
      while (it.hasNext())
      {
         Customer cust = (Customer)it.next();
         System.out.println("   " + cust.getFirstName() + " has a reservation.");
      }
      System.out.println("");
   }
}
      
