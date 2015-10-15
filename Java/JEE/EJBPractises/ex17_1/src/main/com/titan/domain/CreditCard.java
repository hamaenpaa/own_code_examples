package com.titan.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CreditCard implements java.io.Serializable
{
   private int id;
   private Date expirationDate;
   private String number;
   private String nameOnCard;
   private Customer customer;
   private CreditCompany creditCompany;

   @Id @GeneratedValue
   public int getId() { return id; }
   public void setId(int id) { this.id = id; }

   public Date getExpirationDate() { return expirationDate; }
   public void setExpirationDate(Date date) { expirationDate = date; }

   public String getNumber() { return number; }
   public void setNumber(String number) { this.number = number; }

   public String getNameOnCard() { return nameOnCard; }
   public void setNameOnCard(String name) { nameOnCard = name; }

   @OneToOne(mappedBy="creditCard")
   public Customer getCustomer() { return customer; }
   public void setCustomer(Customer customer) { this.customer = customer; }

   @ManyToOne
   public CreditCompany getCreditCompany() { return creditCompany; }
   public void setCreditCompany(CreditCompany creditCompany) { this.creditCompany = creditCompany; }
}
