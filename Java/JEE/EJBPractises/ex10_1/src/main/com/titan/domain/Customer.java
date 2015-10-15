package com.titan.domain;

import javax.persistence.*;

@Entity
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

   @PrePersist
   public void prePersist()
   {
      System.out.println("@PrePersist");
   }

   @PostPersist
   public void postPersist()
   {
      System.out.println("@PostPersist");
   }

   @PostLoad
   public void postLoad()
   {
      System.out.println("@PostLoad");
   }

   @PreUpdate
   public void preUpdate()
   {
      System.out.println("@PreUpdate");
   }

   @PostUpdate
   public void postUpdate()
   {
      System.out.println("@PostUpdate");
   }

   @PreRemove
   public void preRemove()
   {
      System.out.println("@PreRemove");
   }

   @PostRemove
   public void postRemove()
   {
      System.out.println("@PostRemove");
   }

}

 

    
    

    
