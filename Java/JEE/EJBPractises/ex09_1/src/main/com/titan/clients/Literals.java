package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class Literals
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

         literals(entityManager);
         
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void literals(EntityManager manager)
   {
      System.out.println("THE WHERE CLAUSE AND LITERALS");
      System.out.println("--------------------------------");
      System.out.println("SELECT c FROM Customer AS c");
      System.out.println("WHERE c.creditCard.creditCompany.name = 'Capital One'");
      Query query;
      query = manager.createQuery("SELECT c FROM Customer AS c " +
                                  "WHERE c.creditCard.creditCompany.name = 'Capital One'");
      List customers = query.getResultList();
      Iterator it = customers.iterator();
      while (it.hasNext())
      {
         Customer cust = (Customer)it.next();
         System.out.println("   " + cust.getFirstName() + " has a Capital One card.");
      }
      System.out.println("");

      System.out.println("SELECT s FROM Ship AS s");
      System.out.println("WHERE s.tonnage = 100000.0");
      query = manager.createQuery("SELECT s FROM Ship AS s " +
                                  "WHERE s.tonnage = 100000.0");
      List ships = query.getResultList();
      it = ships.iterator();
      while (it.hasNext())
      {
         Ship ship = (Ship)it.next();
         System.out.println("   Ship " + ship.getName() + " as tonnage 100000.0");
      }
      System.out.println("");

      System.out.println("SELECT c FROM Customer AS c");
      System.out.println("WHERE c.hasGoodCredit = TRUE");
      query = manager.createQuery("SELECT c FROM Customer AS c " +
                                  "WHERE c.hasGoodCredit = TRUE");
      customers = query.getResultList();
      it = customers.iterator();
      while (it.hasNext())
      {
         Customer cust = (Customer)it.next();
         System.out.println("   " + cust.getFirstName() + " has good credit.");
      }
      System.out.println("");
   }
}
      
