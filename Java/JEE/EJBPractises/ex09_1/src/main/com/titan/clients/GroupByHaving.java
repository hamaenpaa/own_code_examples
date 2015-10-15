package com.titan.clients;

import java.util.*;
import javax.persistence.*;

public class GroupByHaving
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
         
         groupBy(entityManager);
         having(entityManager);
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

   public static void groupBy(EntityManager manager)
   {
      System.out.println("GROUP BY Clause");
      System.out.println("--------------------------------");
      System.out.println("SELECT new com.titan.clients.ReservationSummary(" +
                         "cr.name, COUNT(res), SUM(res.amountPaid))");
      System.out.println("FROM Cruise cr");
      System.out.println("LEFT JOIN cr.reservations res");
      System.out.println("GROUP BY cr.name");
      Query query;
      query = manager.createQuery("SELECT new com.titan.clients.ReservationSummary(" +
                                  "cr.name, COUNT(res), SUM(res.amountPaid)) " +
                                  "FROM Cruise cr " +
                                  "LEFT JOIN cr.reservations res " +
                                  "GROUP BY cr.name");
      List summaries = query.getResultList();
      Iterator it = summaries.iterator();
      while (it.hasNext())
      {
         ReservationSummary summary = (ReservationSummary)it.next();
         System.out.println("   " + summary.cruise + ": " 
                            + summary.numReservations + "   " +
                            + summary.cashflow);
      }
   }

   public static void having(EntityManager manager)
   {
      System.out.println("GROUP BY Clause");
      System.out.println("--------------------------------");
      System.out.println("SELECT new com.titan.clients.ReservationSummary(" +
                         "cr.name, COUNT(res), SUM(res.amountPaid))");
      System.out.println("FROM Cruise cr");
      System.out.println("LEFT JOIN cr.reservations res");
      System.out.println("GROUP BY cr.name");
      System.out.println("HAVING count(res) > 1");
      Query query;
      query = manager.createQuery("SELECT new com.titan.clients.ReservationSummary(" +
                                  "cr.name, COUNT(res), SUM(res.amountPaid)) " +
                                  "FROM Cruise cr " +
                                  "LEFT JOIN cr.reservations res " +
                                  "GROUP BY cr.name " +
                                  "HAVING count(res) > 1");
      List summaries = query.getResultList();
      Iterator it = summaries.iterator();
      while (it.hasNext())
      {
         ReservationSummary summary = (ReservationSummary)it.next();
         System.out.println("   " + summary.cruise + ": " 
                            + summary.numReservations + "   " +
                            + summary.cashflow);
      }
   }
}
      
