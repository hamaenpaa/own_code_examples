package com.titan.clients;

import com.titan.domain.*;
import java.util.*;
import javax.persistence.*;

public class NativeQueries
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
         
         nativeSql(entityManager);
         System.out.println();
         nativeWithMultipleEntities(entityManager);
         System.out.println();
         mixedNative(entityManager);
      } 
      finally 
      {
         entityManager.getTransaction().commit();
         entityManager.close();
         factory.close();
      }
   }

   public static void nativeSql(EntityManager manager)
   {
      System.out.println("Named Native Query, implicit mapping");
      System.out.println("--------------------------------");
      System.out.println("Executing @NamedNativeQuery(name=\"NativePhone\")");
      Query query;
      query = manager.createNamedQuery("NativePhone");
      List phones = query.getResultList();
      Iterator it = phones.iterator();
      while (it.hasNext())
      {
         Phone phone = (Phone)it.next();
         System.out.println("Phone Number: " + phone.getNumber());
      }
   }

   public static void nativeWithMultipleEntities(EntityManager manager)
   {
      System.out.println("Complex Native queries");
      System.out.println("--------------------------------");
      System.out.println("SELECT c.id, c.firstName, c.lastName, ");
      System.out.println(" cc.id AS CC_ID, cc.number, "); 
      System.out.println("FROM CUST_TABLE c, CREDIT_CARD_TABLE cc ");
      System.out.println("WHERE c.credit_card_id = cc.id");


      Query query = manager.createNativeQuery("SELECT c.id, c.firstName, c.lastName, cc.id As CC_ID, cc.number " +
                                              "FROM CUST_TABLE c, CREDIT_CARD_TABLE cc " +
                                              "WHERE c.credit_card_id = cc.id",
                                              "customerAndCreditCardMapping");
      List phones = query.getResultList();
      Iterator it = phones.iterator();
      while (it.hasNext())
      {
         Object[] result = (Object[])it.next();
         Customer cust = (Customer)result[0];
         CreditCard cc = (CreditCard)result[1];
         System.out.println(cust.getFirstName() + " " + cc.getNumber());
      }
   }
   public static void mixedNative(EntityManager manager)
   {
      System.out.println("Complex Native queries");
      System.out.println("--------------------------------");
      System.out.println("SELECT c.id, count(Reservation.id) as resCount");
      System.out.println("FROM Cruise c ");
      System.out.println("LEFT JOIN Reservation ON c.id = Reservation.CRUISE_ID");
      System.out.println("GROUP BY c.id");



      Query query = manager.createNativeQuery("SELECT c.id, count(Reservation.id) as resCount " +
                                              "FROM Cruise c " +
                                              "LEFT JOIN Reservation ON c.id = Reservation.CRUISE_ID " +
                                              "GROUP BY c.id",
                                              "reservationCount");
      List phones = query.getResultList();
      Iterator it = phones.iterator();
      while (it.hasNext())
      {
         Object[] result = (Object[])it.next();
         Cruise cruise = (Cruise)result[1];
         int count = (Integer)result[0];
         System.out.println(cruise.getName() + " " + count);
      }
   }
}
      
