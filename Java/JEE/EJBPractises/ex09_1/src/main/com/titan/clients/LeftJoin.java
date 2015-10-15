package com.titan.clients;

import java.util.*;
import javax.persistence.*;

public class LeftJoin
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
         
         leftJoin(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void leftJoin(EntityManager entityManager)
   {
      System.out.println("LEFT JOIN");
      System.out.println("--------------------------------");
      System.out.println("SELECT c.firstName, c.lastName, p.number");
      System.out.println("FROM Customer c LEFT JOIN c.phoneNumbers p");
      Query query;
      query = entityManager.createQuery("SELECT c.firstName, c.lastName, p.number " +
                                        " FROM Customer c LEFT JOIN c.phoneNumbers p");
      List resultSet = query.getResultList();
      Iterator it = resultSet.iterator();
      while (it.hasNext())
      {
         Object[] result = (Object[])it.next();
         System.out.println("\t" + result[0] + " " 
                            + result[1] + " " + result[2]);
      }
      System.out.println("");
   }
}
      
