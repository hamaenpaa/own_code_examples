package com.titan.processpayment;
     
import com.titan.domain.*;

public interface ProcessPayment {
     
   public boolean byCheck(Customer customer, CheckDO check, double amount)
      throws PaymentException;
   
   public boolean byCash(Customer customer, double amount)
      throws PaymentException;
   
   public boolean byCredit(Customer customer, CreditCardDO card, 
                           double amount) throws PaymentException;
   
}
