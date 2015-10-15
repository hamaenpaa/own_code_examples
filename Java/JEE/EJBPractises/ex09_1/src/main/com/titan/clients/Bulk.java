package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class Bulk
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
         entityManager.flush();
         entityManager.clear();

         bulkUpdate(entityManager);
         entityManager.clear();
         bulkDelete(entityManager);
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

   public static void bulkUpdate(EntityManager manager)
   {
      System.out.println("Bulk Update");
      System.out.println("--------------------------------");
      System.out.println("UPDATE Reservation res set res.amountPaid = (res.amountPaid + 10)");
      System.out.println("WHERE EXISTS (");
      System.out.println("      SELECT c FROM res.customers c WHERE c.firstName = 'Bill' AND c.lastName='Burke'");
      System.out.println(")");


      System.out.println("Show all amount paid for all of Bill's reservations before update:");
      Customer bill = (Customer)manager.createQuery("FROM Customer c " +
                                                    "where c.firstName = 'Bill' and " +
                                                    "c.lastName='Burke'").getSingleResult();
      Collection<Reservation> reservations = bill.getReservations();
      for (Reservation res : reservations)
      {
         System.out.println("amountPaid: " + res.getAmountPaid());
      }

      Query query;
      query = manager.createQuery("UPDATE Reservation res " +
                                  "SET res.amountPaid = (res.amountPaid + 10) " +
                                  "WHERE EXISTS (" +
                                  "      SELECT c FROM res.customers c WHERE c.firstName = 'Bill' AND c.lastName='Burke')");
      query.executeUpdate();
      manager.flush();
      manager.clear();
      System.out.println("Show all amount paid for all of Bill's reservations after update:");
      bill = (Customer)manager.createQuery("FROM Customer c " +
                                           "where c.firstName = 'Bill' and " +
                                           "c.lastName='Burke'").getSingleResult();
      reservations = bill.getReservations();
      for (Reservation res : reservations)
      {
         System.out.println("amountPaid: " + res.getAmountPaid());
      }
   }
   public static void bulkDelete(EntityManager manager)
   {
      System.out.println("Bulk Delete");
      System.out.println("--------------------------------");
      System.out.println("DELETE FROM Reservation res");
      System.out.println("WHERE EXISTS (");
      System.out.println("      SELECT c FROM res.customers c WHERE c.firstName = 'Bill' AND c.lastName='Burke'");
      System.out.println(")");


      System.out.println("Show all amount paid for all of Bill's reservations before update:");
      Customer bill = (Customer)manager.createQuery("FROM Customer c " +
                                                    "where c.firstName = 'Bill' and " +
                                                    "c.lastName='Burke'").getSingleResult();
      Collection<Reservation> reservations = bill.getReservations();
      for (Reservation res : reservations)
      {
         System.out.println("amountPaid: " + res.getAmountPaid());
      }

      manager.clear();
      Query query;
      query = manager.createQuery("DELETE FROM Reservation res " +
                                  "WHERE EXISTS (" +
                                  "      SELECT c FROM res.customers c WHERE c.firstName = 'Bill' AND c.lastName='Burke')");
      query.executeUpdate();
      manager.flush();
      manager.clear();
      System.out.println("Show all amount paid for all of Bill's reservations after update:");
      bill = (Customer)manager.createQuery("FROM Customer c " +
                                           "where c.firstName = 'Bill' and " +
                                           "c.lastName='Burke'").getSingleResult();
      reservations = bill.getReservations();
      for (Reservation res : reservations)
      {
         System.out.println("amountPaid: " + res.getAmountPaid());
      }
   }
}
      
