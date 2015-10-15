package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class Like
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
         
         like(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void like(EntityManager manager)
   {
      System.out.println("THE WHERE CLAUSE AND LIKE");
      System.out.println("--------------------------------");
      System.out.println("SELECT c FROM Customer c");
      System.out.println("WHERE c.lastName LIKE '%-%'");
      Query query;
      query = manager.createQuery("SELECT c FROM Customer c " +
                                  "WHERE c.lastName LIKE '%-%'");
      List customers = query.getResultList();
      Iterator it = customers.iterator();
      while (it.hasNext())
      {
         Customer cust = (Customer)it.next();
         System.out.println("   " + cust.getLastName());
      }
      System.out.println("");
   }
}
      
