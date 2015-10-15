package com.titan.processpayment;

import com.titan.domain.*;

import java.sql.*;
import javax.sql.DataSource;
import javax.ejb.EJBException;

public class ProcessPaymentBean implements ProcessPaymentRemote, 
                                           ProcessPaymentLocal 
{
   
   final public static String CASH = "CASH";
   final public static String CREDIT = "CREDIT";
   final public static String CHECK = "CHECK";
    
   DataSource dataSource;

   int minCheckNumber = 100;
     
   public boolean byCash(Customer customer, double amount)
      throws PaymentException 
   {
      return process(customer.getId(), amount, CASH, null, -1, null, null);
   }
    
   public boolean byCheck(Customer customer, CheckDO check, double amount)
      throws PaymentException 
   {
      if (check.checkNumber > minCheckNumber) 
      {
         return process(customer.getId(), amount, CHECK, 
                        check.checkBarCode, check.checkNumber, null, null);
      }
      else 
      {
         throw new PaymentException("Check number is too low. Must be at least "+minCheckNumber);
      }
   }
   public boolean byCredit(Customer customer, CreditCardDO card, 
                           double amount) throws PaymentException 
   {
      if (card.expiration.before(new java.util.Date())) 
      {
         throw new PaymentException("Expiration date has passed");
      }
      else 
      {
         return process(customer.getId(), amount, CREDIT, null,
                        -1, card.number, new java.sql.Date(card.expiration.getTime()));
      }
   }
   private boolean process(int customerID, double amount, String type, 
                           String checkBarCode, int checkNumber, String creditNumber, 
                           java.sql.Date creditExpDate) throws PaymentException 
   {
     
      Connection con = null;
        
      PreparedStatement ps = null;
     
      try 
      {
         con = dataSource.getConnection();
         ps = con.prepareStatement
            ("INSERT INTO payment (customer_id, amount, type,"+ 
             "check_bar_code,check_number,credit_number,"+
             "credit_exp_date) VALUES (?,?,?,?,?,?,?)");
         ps.setInt(1,customerID);
         ps.setDouble(2,amount);
         ps.setString(3,type);
         ps.setString(4,checkBarCode);
         ps.setInt(5,checkNumber);
         ps.setString(6,creditNumber);
         ps.setDate(7,creditExpDate);
         int retVal = ps.executeUpdate();
         if (retVal!=1) 
         {
            throw new EJBException("Payment insert failed");
         }         
         return true;
      } 
      catch(SQLException sql) 
      {
         throw new EJBException(sql);
      } 
      finally 
      {
         try 
         {
            if (ps != null) ps.close();
            if (con!= null) con.close();
         } 
         catch(SQLException se) 
         {
            se.printStackTrace();
         }
      }
   }

}
