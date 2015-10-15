package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class OrderBy
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
         
         orderBy(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void orderBy(EntityManager manager)
   {
      System.out.println("ORDER BY Clause");
      System.out.println("--------------------------------");
      System.out.println("SELECT c FROM Customer AS c");
      System.out.println("ORDER BY c.lastName DESC");
      Query query;
      query = manager.createQuery("SELECT c FROM Customer AS c " +
                                  "ORDER BY c.lastName DESC");
      List customers = query.getResultList();
      Iterator it = customers.iterator();
      while (it.hasNext())
      {
         Customer cust = (Customer)it.next();
         System.out.println("   " + cust.getFirstName() + " " + cust.getLastName());
      }
   }
}
      
