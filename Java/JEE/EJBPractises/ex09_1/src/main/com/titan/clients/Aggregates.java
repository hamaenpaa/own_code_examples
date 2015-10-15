package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class Aggregates
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
         
         aggregates(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void aggregates(EntityManager manager)
   {
      System.out.println("Aggregate Functions");
      System.out.println("--------------------------------");
      System.out.println("SELECT DISTINCT COUNT(c.address.zip)");
      System.out.println("FROM Customer AS c");
      System.out.println("WHERE c.address.zip LIKE '0%'");
      Query query;
      query = manager.createQuery("SELECT DISTINCT COUNT(c.address.zip) " +
                                  "FROM Customer c " +
                                  "WHERE c.address.zip LIKE '0%'");
      long count = (Long)query.getSingleResult();
      System.out.println("");
      System.out.println("count of zip codes starting with 0: " + count);

      System.out.println("--------------------------------");
      System.out.println("SELECT MAX(r.amountPaid)");
      System.out.println("FROM Reservation As r");
      System.out.println("");
      query = manager.createQuery("SELECT MAX(r.amountPaid) " +
                                  "FROM Reservation r");
      double max = (Double)query.getSingleResult();
      System.out.println("max amount paid for a reservation: $" + max);
         
      System.out.println("--------------------------------");
      System.out.println("SELECT SUM( r.amountPaid)");
      System.out.println("FROM Cruise c, IN( c.reservations) r");
      System.out.println("WHERE  c = :cruise");
      System.out.println("");
      Cruise cruise = 
         (Cruise)manager.createQuery("FROM Cruise cr WHERE cr.name='Atlantic Cruise'").getSingleResult();

      query = manager.createQuery("SELECT SUM( r.amountPaid) " +
                                  "FROM Cruise c, IN( c.reservations) r " +
                                  "WHERE  c = :cruise");
      query.setParameter("cruise", cruise);
      double sum = (Double)query.getSingleResult();
      System.out.println("Sum of Atlantic Cruise reservations: $" + sum);
         
      System.out.println("--------------------------------");
      System.out.println("SELECT AVG( r.amountPaid)");
      System.out.println("FROM Cruise c, IN( c.reservations) r");
      System.out.println("WHERE  c = :cruise");
      System.out.println("");
      query = manager.createQuery("SELECT AVG( r.amountPaid) " +
                                  "FROM Cruise c, IN( c.reservations) r " +
                                  "WHERE  c = :cruise");
      query.setParameter("cruise", cruise);
      double avg = (Double)query.getSingleResult();
      System.out.println("Average of Atlantic Cruise reservations: $" + avg);
   }
}
      
