package com.titan.processpayment;

import com.titan.domain.*;

import javax.ejb.*;
import javax.annotation.Resource;
import javax.persistence.*;
import static javax.persistence.PersistenceContextType.*;
import static javax.ejb.TransactionAttributeType.*;

@Stateful    
@TransactionAttribute(SUPPORTS)
public class ProcessPaymentBean implements ProcessPaymentLocal 
{
   
   final public static String CASH = "CASH";
   final public static String CREDIT = "CREDIT";
   final public static String CHECK = "CHECK";
    
   @PersistenceContext(unitName="titan", type=EXTENDED)
   private EntityManager entityManager;

   @Resource(name="min") int minCheckNumber = 100;
     
   public boolean byCash(Customer customer, double amount)
      throws PaymentException 
   {
      return process(customer, amount, CASH, null, -1, null, null);
   }
    
   public boolean byCheck(Customer customer, CheckDO check, double amount)
      throws PaymentException 
   {
      if (check.checkNumber > minCheckNumber) 
      {
         return process(customer, amount, CHECK, 
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
         return process(customer, amount, CREDIT, null,
                        -1, card.number, new java.sql.Date(card.expiration.getTime()));
      }
   }
   private boolean process(Customer cust, double amount, String type, 
                           String checkBarCode, int checkNumber, String creditNumber, 
                           java.sql.Date creditExpDate) throws PaymentException 
   {
      Payment payment = new Payment();
      payment.setCustomer(cust);
      payment.setAmount(amount);
      payment.setType(type);
      payment.setCheckBarCode(checkBarCode);
      payment.setCheckNumber(checkNumber);
      payment.setCreditCard(creditNumber);
      payment.setCreditCardExpiration(creditExpDate);
      entityManager.persist(payment);
      return true;
   }
}
