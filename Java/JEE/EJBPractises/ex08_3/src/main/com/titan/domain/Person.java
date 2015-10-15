package com.titan.domain;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Person implements java.io.Serializable
{
   private int id;
   private String firstName;
   private String lastName;

   @Id @GeneratedValue
   public int getId() { return id; }
   public void setId(int id) { this.id = id; }

   public String getFirstName() { return firstName; }
   public void setFirstName(String first) { this.firstName = first; }

   public String getLastName() { return lastName; }
   public void setLastName(String last) { this.lastName = last; }
}
    
