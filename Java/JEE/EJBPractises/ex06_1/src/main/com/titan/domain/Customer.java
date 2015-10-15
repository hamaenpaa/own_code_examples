package com.titan.domain;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="CUSTOMER_TABLE")
public class Customer implements java.io.Serializable 
{
   private int id;
   private String lastName;
   private String firstName;
   private CustomerType customerType;
   private Date timeCreated = new Date();
   private JPEG picture;
   
   @Id
   @GeneratedValue
   @Column(name="CUST_ID")
   public int getId()
   {
      return id;
   }
   public void setId(int pk) 
   {
      id = pk;
   }

   public String getLastName() { return lastName; }
   public void setLastName(String lastName) { this.lastName = lastName; }

   public String getFirstName() { return firstName; }
   public void setFirstName(String firstName) { this.firstName = firstName; }

   @Enumerated(EnumType.STRING)
   public CustomerType getCustomerType() { return customerType; }
   public void setCustomerType(CustomerType type) { customerType = type; }

   @Temporal(TemporalType.TIME)
   public Date getTimeCreated() { return timeCreated; }
   public void setTimeCreated(Date time) { timeCreated = time; }

   @Lob @Basic(fetch=FetchType.LAZY)
   public JPEG getPicture() { return picture; }
   public void setPicture(JPEG jpeg) { picture = jpeg; }
}

 

    
    

    
