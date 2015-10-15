package com.titan.clients;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashMap;

import com.titan.domain.Cabin;
public class StandaloneClient 
{
   public static void main(String[] args) throws Exception 
   {
      HashMap map = new HashMap();
      EntityManagerFactory factory =
         Persistence.createEntityManagerFactory("titan", map);
      EntityManager manager = factory.createEntityManager();
      try 
      {
         createCabin(manager);
         Cabin cabin_2 = manager.find(Cabin.class, 1);
         System.out.println(cabin_2.getName());
         System.out.println(cabin_2.getDeckLevel());
         System.out.println(cabin_2.getShipId());
         System.out.println(cabin_2.getBedCount());
      } 
      finally 
      {
         manager.close();
         factory.close();
      }
   }

   public static void createCabin(EntityManager manager) 
   {
      Cabin cabin_1 = new Cabin();
      cabin_1.setId(1);
      cabin_1.setName("Master Suite");
      cabin_1.setDeckLevel(1);
      cabin_1.setShipId(1);
      cabin_1.setBedCount(3);      

      EntityTransaction transaction = manager.getTransaction();
      transaction.begin();
      manager.persist(cabin_1);
      transaction.commit();
   }
}
