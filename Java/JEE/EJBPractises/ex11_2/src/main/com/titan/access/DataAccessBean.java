package com.titan.access;

import java.sql.*;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.ejb.EJBException;

import com.titan.domain.Customer; 

@Stateless
public class DataAccessBean implements DataAccess
{
   @PersistenceContext(unitName="titan") private EntityManager manager;
    
   @Resource(mappedName="java:/DefaultDS") DataSource dataSource;

   public int createCustomer(Customer cust)
   {
      manager.persist(cust);
      return cust.getId();
   }

   public Customer findCustomer(int pKey)
   {
      return manager.find(Customer.class, pKey);
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
