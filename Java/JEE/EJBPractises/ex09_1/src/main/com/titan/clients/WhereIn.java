package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class WhereIn
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
         
         whereIn(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void whereIn(EntityManager manager)
   {
      System.out.println("THE WHERE CLAUSE AND IN");
      System.out.println("--------------------------------");
      System.out.println("SELECT c FROM Customer c");
      System.out.println("WHERE c.address.state IN ('GA', 'MA')");
      Query query;
      query = manager.createQuery("SELECT c FROM Customer c " +
                                  "WHERE c.address.state IN ('GA', 'MA')");
      List customers = query.getResultList();
      Iterator it = customers.iterator();
      while (it.hasNext())
      {
         Customer cust = (Customer)it.next();
         System.out.println("   " + cust.getFirstName());
      }
      System.out.println("");

      System.out.println("SELECT c FROM Customer c");
      System.out.println("WHERE c.address.state NOT IN ('GA', 'MA')");
      query = manager.createQuery("SELECT c FROM Customer c " +
                                  "WHERE c.address.state NOT IN ('GA', 'MA')");
      customers = query.getResultList();
      it = customers.iterator();
      while (it.hasNext())
      {
         Customer cust = (Customer)it.next();
         System.out.println("   " + cust.getFirstName());
      }
      System.out.println("");
   }
}
      
