package com.titan.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@TableGenerator(name="PaymentGenerator")
public class Payment implements java.io.Serializable
{
   private int id;
   private Customer customer;
   private double amount;
   private String type;
   private String checkBarCode;
   private int checkNumber;
   private String creditCard;
   private Date creditCardExpiration; 

   @Id
   @GeneratedValue(strategy=GenerationType.TABLE, 
                   generator="PaymentGenerator")
   public int getId() { return id; }
   public void setId(int id) { this.id = id; }

   @ManyToOne
   public Customer getCustomer() { return customer; }
   public void setCustomer(Customer cust) { this.customer = cust; }

   public double getAmount() { return amount; }
   public void setAmount(double amount) { this.amount = amount; }

   public String getType() { return type; }
   public void setType(String type) { this.type = type; }

   public String getCheckBarCode() { return checkBarCode; }
   public void setCheckBarCode(String checkBarCode) { this.checkBarCode = checkBarCode; }

   public int getCheckNumber() { return checkNumber; }
   public void setCheckNumber(int checkNumber) { this.checkNumber = checkNumber; }

   public String getCreditCard() { return creditCard; }
   public void setCreditCard(String creditCard) { this.creditCard = creditCard; }
   public Date getCreditCardExpiration() { return creditCardExpiration; }
   public void setCreditCardExpiration(Date creditCardExpiration) { this.creditCardExpiration = creditCardExpiration; }


}
