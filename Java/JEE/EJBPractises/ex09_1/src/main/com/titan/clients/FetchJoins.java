package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class FetchJoins
{
   public static void main(String[] args) throws Exception 
   {
      HashMap props = new HashMap();
      props.put("hibernate.show_sql", "true");
      EntityManagerFactory factory =
         Persistence.createEntityManagerFactory("titan", props);
      EntityManager manager = factory.createEntityManager();
      try 
      {
         manager.getTransaction().begin();
         System.out.println("Initialize DB");
         InitializeDB.initialize(manager);
         System.out.println();
         System.out.println();
         manager.getTransaction().commit();
         System.out.println();
         System.out.println();
         System.out.println();
         
         manager.getTransaction().begin();
         noJoin(manager);
         manager.clear();
         manager.getTransaction().commit();
         System.out.println();
         System.out.println();
         System.out.println();


         manager.getTransaction().begin();
         joinFetch(manager);
         manager.clear();
         manager.getTransaction().commit();
      } 
      finally 
      {
         manager.close();
         factory.close();
      }
   }

   public static void noJoin(EntityManager manager)
   {
      System.out.println("-----------");
      System.out.println("  NO JOIN  ");
      System.out.println("-----------");
      Query query = manager.createQuery("SELECT c FROM Customer c");
      List results = query.getResultList();
      System.out.println();
      Iterator it = results.iterator();
      while (it.hasNext()) {
         Customer c = (Customer)it.next();
         Collection<Phone> phoneNumbers = c.getPhoneNumbers();
         // force the query so output looks nice
         phoneNumbers.size();
         System.out.print(c.getFirstName() + " " + c.getLastName());
         for (Phone p : phoneNumbers) {
            System.out.print(" " + p.getNumber());
         }
         System.out.println("");
      }
   }

   public static void joinFetch(EntityManager manager)
   {
      System.out.println("------------");
      System.out.println(" JOIN FETCH ");
      System.out.println("------------");
      Query query = manager.createQuery("SELECT c FROM Customer c LEFT JOIN FETCH c.phoneNumbers");
      List results = query.getResultList();
      HashSet set = new HashSet();
      set.addAll(results);
      System.out.println();
      Iterator it = set.iterator();
      while (it.hasNext()) {
         Customer c = (Customer)it.next();
         System.out.print(c.getFirstName() + " " + c.getLastName());
         for (Phone p : c.getPhoneNumbers()) {
            System.out.print(" " + p.getNumber());
         }
         System.out.println("");
      }
   }
}
      
