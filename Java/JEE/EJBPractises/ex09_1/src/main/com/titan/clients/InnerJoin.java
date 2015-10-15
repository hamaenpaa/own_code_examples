package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class InnerJoin
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
         
         innerJoin(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void innerJoin(EntityManager entityManager)
   {
      System.out.println("THE IN OPERATOR and INNER JOIN");
      System.out.println("--------------------------------");
      System.out.println("SELECT r");
      System.out.println("FROM Customer AS c, IN( c.reservations ) r");
      Query query = 
         entityManager.createQuery("SELECT r " +
                                   "FROM Customer AS c , " +
                                   "IN( c.reservations ) r");
      List reservations = query.getResultList();
      Iterator it = reservations.iterator();
      while (it.hasNext())
      {
         Reservation reservation = (Reservation)it.next();
         System.out.println("   Reservation for " + 
                     reservation.getCruise().getName());
      }
      System.out.println("");
      
      System.out.println("SELECT r.cruise");
      System.out.println("FROM Customer AS c, IN( c.reservations ) r");
      query = entityManager.createQuery("SELECT r.cruise " +
                                        "FROM Customer AS c, " +
                                        "IN( c.reservations ) r");
      List cruises = query.getResultList();
      it = cruises.iterator();
      while (it.hasNext())
      {
         Cruise cruise = (Cruise)it.next();
         System.out.println("   Cruise " + cruise.getName());
      }
      System.out.println("");

      System.out.println("SELECT cbn.ship");
      System.out.println("FROM Customer AS c, IN( c.reservations ) r,");
      System.out.println("IN( r.cabins ) AS cbn");
      query = entityManager.createQuery("SELECT cbn.ship " +
                                        "FROM Customer AS c, " +
                                        "IN( c.reservations ) r," +
                                        "IN( r.cabins ) cbn");
                                   
      List ships = query.getResultList();
      it = ships.iterator();
      while (it.hasNext())
      {
         Ship ship = (Ship)it.next();
         System.out.println("   Ship " + ship.getName());
      }
      System.out.println("");

      System.out.println("SELECT cbn.ship");
      System.out.println("FROM Customer c INNER JOIN c.reservations r ");
      System.out.println("INNER JOIN r.cabins cbn");
      query = entityManager.createQuery("SELECT cbn.ship " +
                                        "FROM Customer c " +
                                        "INNER JOIN c.reservations r " +
                                        "INNER JOIN r.cabins cbn");
                                   
      ships = query.getResultList();
      it = ships.iterator();
      while (it.hasNext())
      {
         Ship ship = (Ship)it.next();
         System.out.println("   Ship " + ship.getName());
      }
      System.out.println("");
   }

}
      
