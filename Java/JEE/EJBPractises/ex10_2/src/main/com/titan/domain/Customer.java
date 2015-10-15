package com.titan.domain;

import javax.persistence.*;

@Entity
@EntityListeners(com.titan.stats.EntityListener.class)
public class Customer implements java.io.Serializable 
{
   private int id;
   private String lastName;
   private String firstName;

   @Id
   @GeneratedValue
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
}

 

    
    

    
