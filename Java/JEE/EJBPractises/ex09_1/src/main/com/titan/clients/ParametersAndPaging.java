package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class ParametersAndPaging
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

         System.out.println("Find Bill Burke by named parameter");
         Customer cust = findCustomerByNamedParameter(entityManager, "Bill", "Burke");
         System.out.println("Bill Burke's cust id: " + cust.getId());
         System.out.println();
         System.out.println();

         System.out.println("Find Gavin King by indexed parameter");
         cust = findCustomerByIndexedParameter(entityManager, "Gavin", "King");
         System.out.println("Gavin King's cust id: " + cust.getId());
         System.out.println();
         System.out.println();

         System.out.println("Output all customers via paging");
         List results;
         int first = 0;
         int max = 2;
         do 
         {
            results = getCustomers(entityManager, max, first);
            Iterator it = results.iterator();
            while (it.hasNext()) 
            {
               Customer c = (Customer)it.next();
               System.out.println(c.getFirstName() + " " + c.getLastName());
            }
            entityManager.clear();
            first = first + results.size();
         } while (results.size() > 0);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static Customer findCustomerByNamedParameter(EntityManager entityManager, String first, String last)
   {
      Query query = entityManager.createQuery("from Customer c " +
                                        " where c.firstName=:first" +
                                        " and c.lastName=:last");
      query.setParameter("first", first);
      query.setParameter("last", last);
      return (Customer)query.getSingleResult();
   }

   public static Customer findCustomerByIndexedParameter(EntityManager entityManager, String first, String last)
   {
      Query query = entityManager.createQuery("from Customer c " +
                                        " where c.firstName=?1" +
                                        " and c.lastName=?2");
      query.setParameter(1, first);
      query.setParameter(2, last);
      return (Customer)query.getSingleResult();
   }

   public static List getCustomers(EntityManager entityManager, int max, int index)
   {
      Query query = entityManager.createQuery("from Customer c");
      return query.setMaxResults(max).
         setFirstResult(index).
         getResultList();
   }

}
