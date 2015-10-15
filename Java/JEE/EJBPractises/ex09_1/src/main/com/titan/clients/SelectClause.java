package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class SelectClause
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
         
         columnResultSet(entityManager);
         System.out.println();
         System.out.println();

         nestedRelationshipPropertyResultSet(entityManager);
         System.out.println();
         System.out.println();
         
         constructorExpression(entityManager);
         System.out.println();
         System.out.println();
         

      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void columnResultSet(EntityManager entityManager)
   {
      System.out.println("Executing query: ");
      System.out.println("SELECT c.firstName, c.lastName FROM Customer AS c");
      Query query = entityManager.createQuery("SELECT c.firstName, c.lastName FROM Customer AS c");
      List list = query.getResultList();
      Iterator it = list.iterator();
      while (it.hasNext())
      {
         Object[] result = (Object[])it.next();
         System.out.println("\t" + result[0] + " " + result[1]);
      }
   }

   public static void nestedRelationshipPropertyResultSet(EntityManager entityManager)
   {
      System.out.println("Executing query: ");
      System.out.println("SELECT c.creditCard.creditCompany.address.city FROM Customer AS c");
      Query query = entityManager.createQuery("SELECT c.creditCard.creditCompany.address.city FROM Customer AS c");
      List list = query.getResultList();
      Iterator it = list.iterator();
      while (it.hasNext())
      {
         System.out.println("\t" + it.next());
      }
   }

   public static void constructorExpression(EntityManager entityManager)
   {
      System.out.println("Executing query: ");
      System.out.println("SELECT new com.titan.domain.Name(c.firstName, c.lastName) FROM Customer c");
      Query query = entityManager.createQuery("SELECT new com.titan.domain.Name(c.firstName, c.lastName) FROM Customer c");
      List list = query.getResultList();
      Iterator it = list.iterator();
      while (it.hasNext())
      {
         Name result = (Name)it.next();
         System.out.println("\t" + result.getFirst() + " " + result.getLast());
      }
   }
      

}
