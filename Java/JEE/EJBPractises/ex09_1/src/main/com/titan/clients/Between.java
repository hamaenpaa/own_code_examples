package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class Between
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
       
         between(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void between(EntityManager manager)
   {
      System.out.println("THE WHERE CLAUSE AND BETWEEN");
      System.out.println("--------------------------------");
      System.out.println("SELECT s FROM Ship s");
      System.out.println("WHERE s.tonnage BETWEEN 80000.00 and 130000.00");
      Query query;
      query = manager.createQuery("SELECT s FROM Ship s " +
                                  "WHERE s.tonnage BETWEEN 80000.00 and 130000.00");
      List ships = query.getResultList();
      Iterator it = ships.iterator();
      while (it.hasNext())
      {
         Ship ship = (Ship)it.next();
         System.out.println("   " + ship.getName() + " has tonnage " + ship.getTonnage());
      }
      System.out.println("");
      System.out.println("SELECT s FROM Ship s");
      System.out.println("WHERE s.tonnage NOT BETWEEN 80000.00 and 130000.00");
      query = manager.createQuery("SELECT s FROM Ship s " +
                                  "WHERE s.tonnage NOT BETWEEN 80000.00 and 130000.00");
      ships = query.getResultList();
      it = ships.iterator();
      while (it.hasNext())
      {
         Ship ship = (Ship)it.next();
         System.out.println("   " + ship.getName() + " has tonnage " + ship.getTonnage());
      }
      System.out.println("");
   }
}
      
