package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class Subqueries
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
         
         subquery(entityManager);
         System.out.println();
         System.out.println();
         subqueryALL(entityManager);
         System.out.println();
         System.out.println();
         subqueryANY(entityManager);
         System.out.println();
         System.out.println();
         subqueryEXISTS(entityManager);
         entityManager.getTransaction().commit();
      } 
      catch (Exception ex)
      {
         ex.printStackTrace();
      }
      finally 
      {
         entityManager.close();
         factory.close();
      }
   }

   public static void subquery(EntityManager manager)
   {
      System.out.println("Subquery");
      System.out.println("--------------------------------");
      System.out.println("SELECT COUNT(res) FROM Reservation res");
      System.out.println("WHERE res.amountPaid >");
      System.out.println("(SELECT AVG(r.amountPaid) FROM Reservation r)");
      Query query;
      query = manager.createQuery("SELECT COUNT(res) FROM Reservation res " +
                                  "WHERE res.amountPaid > " +
                                  "(SELECT AVG(r.amountPaid) FROM Reservation r)");
      long count = (Long)query.getSingleResult();
      System.out.println("Number of reservations paid above the average: " + count);
   }

   public static void subqueryALL(EntityManager manager)
   {
      System.out.println("Subquery with ALL");
      System.out.println("--------------------------------");
      System.out.println("FROM Cruise cr");
      System.out.println("WHERE 0 < ALL");
      System.out.println("(SELECT res.amountPaid from cr.reservations res)");
      Query query;
      query = manager.createQuery("FROM Cruise cr " +
                                  "WHERE 0 < ALL" +
                                  "(SELECT res.amountPaid from cr.reservations res)");
      List cruises = query.getResultList();
      System.out.println("Cruises where all reservations have down payments:");
      Iterator it = cruises.iterator();
      while (it.hasNext())
      {
         Cruise cr = (Cruise)it.next();
         System.out.println("\t" + cr.getName());
      }
   }

   public static void subqueryANY(EntityManager manager)
   {
      System.out.println("Subquery with ANY");
      System.out.println("--------------------------------");
      System.out.println("FROM Cruise cr");
      System.out.println("WHERE 0 = ANY");
      System.out.println("(SELECT res.amountPaid from cr.reservations res)");
      Query query;
      query = manager.createQuery("FROM Cruise cr " +
                                  "WHERE 0 = ANY" +
                                  "(SELECT res.amountPaid from cr.reservations res)");
      List cruises = query.getResultList();
      System.out.println("Cruises where any reservation doesn't have down payments:");
      Iterator it = cruises.iterator();
      while (it.hasNext())
      {
         Cruise cr = (Cruise)it.next();
         System.out.println("\t" + cr.getName());
      }
   }

   public static void subqueryEXISTS(EntityManager manager)
   {
      System.out.println("Subquery with EXISTS");
      System.out.println("--------------------------------");
      System.out.println("FROM Cruise cr");
      System.out.println("WHERE NOT EXISTS");
      System.out.println("(SELECT res.amountPaid from cr.reservations res WHERE res.amountPaid = 0)");
      Query query;
      query = manager.createQuery("FROM Cruise cr " +
                                  "WHERE NOT EXISTS" +
                                  "(SELECT res.amountPaid from cr.reservations res WHERE res.amountPaid = 0)");
      List cruises = query.getResultList();
      System.out.println("Cruises that have reservations that don't have a down payment:");
      Iterator it = cruises.iterator();
      while (it.hasNext())
      {
         Cruise cr = (Cruise)it.next();
         System.out.println("\t" + cr.getName());
      }
   }
}
      
