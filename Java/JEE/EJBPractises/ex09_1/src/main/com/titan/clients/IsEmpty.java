package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class IsEmpty
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

         isEmpty(entityManager);
         
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void isEmpty(EntityManager manager)
   {
      System.out.println("THE WHERE CLAUSE AND IS EMPTY");
      System.out.println("--------------------------------");
      System.out.println("SELECT OBJECT( crs ) FROM Cruise crs");
      System.out.println("WHERE crs.reservations IS EMPTY");
      Query query;
      query = manager.createQuery("SELECT OBJECT( crs ) FROM Cruise crs " +
                                  "WHERE crs.reservations IS EMPTY");
      List cruises = query.getResultList();
      Iterator it = cruises.iterator();
      while (it.hasNext())
      {
         Cruise cruise = (Cruise)it.next();
         System.out.println("   " + cruise.getName() + " is empty.");
      }

      System.out.println("");
      System.out.println("SELECT crs FROM Cruise crs");
      System.out.println("WHERE crs.reservations IS NOT EMPTY");
      query = manager.createQuery("SELECT crs FROM Cruise crs " +
                                  "WHERE crs.reservations IS NOT EMPTY");
      cruises = query.getResultList();
      it = cruises.iterator();
      while (it.hasNext())
      {
         Cruise cruise = (Cruise)it.next();
         System.out.println("   " + cruise.getName() + " is NOT empty.");
      }
   }
}
      
