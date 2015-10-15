package com.titan.access;

import java.sql.*;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import javax.sql.DataSource;
import javax.ejb.EJBException;

import com.titan.domain.*;

@Stateless
public class DataAccessBean implements DataAccess
{
   @PersistenceContext(unitName="titan") private EntityManager manager;
    
   @Resource(mappedName="java:/DefaultDS") DataSource dataSource;

   public List getCruises()
   {
      return manager.createQuery("FROM Cruise").getResultList();
   }

   public List getCabins(int cruiseId)
   {
      Ship ship = (Ship)manager.createQuery("SELECT cruise.ship FROM Cruise cruise WHERE cruise.id = " + cruiseId).getSingleResult();
      return manager.createQuery("FROM Cabin c WHERE c.ship = :ship").setParameter("ship", ship).getResultList();
   }

   public void initializeDB()
   {
      List list = manager.createQuery("FROM Ship ship").getResultList();
      if (list.size() > 0) 
      {
        return;
      }
      Ship queenMary = new Ship("Queen Mary", 40000.0);
      manager.persist(queenMary);
      Ship titanic = new Ship("Titanic", 100000.0);
      manager.persist(titanic);
      
      // Create cabins
      Cabin cabin1 = new Cabin();
      cabin1.setDeckLevel(1);
      cabin1.setShip(queenMary);
      cabin1.setBedCount(1);
      cabin1.setName("Queen Cabin 1");
      manager.persist(cabin1);

      Cabin cabin2 = new Cabin();
      cabin2.setDeckLevel(1);
      cabin2.setShip(queenMary);
      cabin2.setBedCount(1);
      cabin2.setName("Queen Cabin 2");
      manager.persist(cabin2);
         
      Cabin cabin3 = new Cabin();
      cabin3.setDeckLevel(1);
      cabin3.setShip(titanic);
      cabin3.setBedCount(2);
      cabin3.setName("Titanic Cabin 1");
      manager.persist(cabin3);
         
      Cabin cabin4 = new Cabin();
      cabin4.setDeckLevel(1);
      cabin4.setShip(titanic);
      cabin4.setBedCount(2);
      cabin4.setName("Titanic Cabin 2");
      manager.persist(cabin4);
         
      Cabin cabin5 = new Cabin();
      cabin5.setDeckLevel(1);
      cabin5.setShip(titanic);
      cabin5.setBedCount(2);
      cabin5.setName("Titanic Cabin 3");
      manager.persist(cabin5);

      // Create cruise
      Cruise alaskan = new Cruise("Alaskan Cruise", queenMary);
      manager.persist(alaskan);
      Cruise atlantic = new Cruise("Atlantic Cruise", titanic);
      manager.persist(atlantic);

   }

   // Create DB environmnet
   //
   public void makePaymentDbTable()
   {
      PreparedStatement ps = null;
      Connection con = null;

      try
      {
         con = dataSource.getConnection();

         System.out.println("Creating table PAYMENT...");
         ps = con.prepareStatement("CREATE TABLE PAYMENT ( " +
                                   "CUSTOMER_ID INT, " +
                                   "AMOUNT DECIMAL (8,2), " +
                                   "TYPE CHAR (10), " +
                                   "CHECK_BAR_CODE CHAR (50), " +
                                   "CHECK_NUMBER INTEGER, " +
                                   "CREDIT_NUMBER CHAR (20), " +
                                   "CREDIT_EXP_DATE DATE" +
                                   ")");
         ps.execute();
         System.out.println("...done!");
      }
      catch (SQLException sql)
      {
         throw new EJBException(sql);
      }
      finally
      {
         try { if (ps != null) ps.close(); } catch (Exception e) {}
         try { if (con != null) con.close(); } catch (Exception e) {}
      }
   }

   public void dropPaymentDbTable()
   {
      PreparedStatement ps = null;
      Connection con = null;

      try
      {
         con = dataSource.getConnection();

         System.out.println("Dropping table PAYMENT...");
         ps = con.prepareStatement("DROP TABLE PAYMENT");
         ps.execute();
         System.out.println("...done!");
      }
      catch (SQLException sql)
      {
         throw new EJBException(sql);
      }
      finally
      {
         try { if (ps != null) ps.close(); } catch (Exception e) {}
         try { if (con != null) con.close(); } catch (Exception e) {}
      }
   }
}
