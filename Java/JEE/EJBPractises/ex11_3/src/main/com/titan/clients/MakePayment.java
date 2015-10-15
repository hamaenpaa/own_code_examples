package com.titan.clients;

import com.titan.processpayment.*;
import com.titan.domain.Customer;
import com.titan.access.DataAccess;

import java.util.Calendar;
import javax.naming.InitialContext;
import javax.naming.Context;

/**
 * Example demonstrating use of ProcessPayment EJB directly
 *
 */

public class MakePayment
{
   
   public static void main(String [] args)
   {
      try
      {
         // obtain CustomerHome
         Context jndiContext = getInitialContext();
         DataAccess access = (DataAccess)jndiContext.lookup("DataAccessBean/remote");
         access.makePaymentDbTable();
         
         Customer cust = new Customer();
         cust.setFirstName("Bill");
         cust.setLastName("Burke");
         access.createCustomer(cust);
         
         ProcessPaymentRemote procpay = (ProcessPaymentRemote)jndiContext.lookup("ProcessPaymentBean/remote");
         
         System.out.println("Making a payment using byCash()..");
         procpay.byCash(cust,1000.0);
         
         System.out.println("Making a payment using byCheck()..");
         CheckDO check = new CheckDO("010010101101010100011", 3001);
         procpay.byCheck(cust,check,2000.0);
         
         System.out.println("Making a payment using byCredit()..");
         Calendar expdate = Calendar.getInstance();
         expdate.set(2025,1,28); // month=1 is February
         CreditCardDO credit = new CreditCardDO("370000000000002",expdate.getTime(),"AMERICAN_EXPRESS");
         procpay.byCredit(cust,credit,3000.0);
         
         System.out.println("Making a payment using byCheck() with a low check number..");
         CheckDO check2 = new CheckDO("111000100111010110101", 50);
         try
         {
            procpay.byCheck(cust,check2,9000.0);
            System.out.println("The PaymentException has not been raised because the min check number has been overriden in ejb-jar.xml");
         }
         catch(PaymentException pe)
         {
            System.out.println("Caught PaymentException: "+pe.getMessage());
         }
         access.dropPaymentDbTable();
      }
      catch(Throwable t)
      {
         t.printStackTrace();
      }
      
   }
   
   static public Context getInitialContext() throws Exception
   {
      return new InitialContext();
   }
   
}

