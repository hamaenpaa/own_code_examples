package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class MemberOf
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

         memberOf(entityManager);
         
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void memberOf(EntityManager manager)
   {
      System.out.println("THE WHERE CLAUSE AND MEMBER OF");
      System.out.println("--------------------------------");
      System.out.println("SELECT crs FROM Cruise crs,");
      System.out.println("IN (crs.reservations) res, Customer cust");
      System.out.println("WHERE cust = :c AND cust MEMBER OF res.customers");
      System.out.println("Use Bill Burke");
      Customer bill = (Customer)manager.createQuery("FROM Customer c " +
                                          "WHERE c.firstName = 'Bill' " +
                                          " AND c.lastName = 'Burke'").getSingleResult();

      Query query;
      query = manager.createQuery("SELECT crs FROM Cruise crs," +
                                  "IN (crs.reservations) res, Customer cust " +
                                  "WHERE cust = :c AND cust MEMBER OF res.customers");
      query.setParameter("c", bill);
      List cruises = query.getResultList();
      Iterator it = cruises.iterator();
      while (it.hasNext())
      {
         Cruise cruise = (Cruise)it.next();
         System.out.println("   Bill is member of " + cruise.getName());
      }
      System.out.println("");

      System.out.println("SELECT crs FROM Cruise crs,");
      System.out.println("IN (crs.reservations) res, Customer cust");
      System.out.println("WHERE cust = :c AND cust NOT MEMBER OF res.customers");
      System.out.println("Use Bill again");
      query = manager.createQuery("SELECT crs FROM Cruise crs," +
                                  "IN (crs.reservations) res, Customer cust " +
                                  "WHERE cust = :c AND cust NOT MEMBER OF res.customers");
      query.setParameter("c", bill);
      cruises = query.getResultList();
      it = cruises.iterator();
      while (it.hasNext())
      {
         Cruise cruise = (Cruise)it.next();
         System.out.println("   Bill is not member of " + cruise.getName());
      }
      System.out.println("");
   }
}
      
