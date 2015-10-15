package com.titan.domain;

import javax.persistence.*;

@Entity
@Table(name="CUSTOMER_TABLE")
@SecondaryTable(name="ADDRESS_TABLE",
                pkJoinColumns={
                   @PrimaryKeyJoinColumn(name="ADDRESS_ID")})
public class Customer implements java.io.Serializable {
   private long id;
   private String firstName;
   private String lastName;
   private String street;
   private String city;
   private String state;

   @Id @GeneratedValue
   public long getId() { return id; }
   public void setId(long id) { this.id = id; }

   public String getFirstName() { return firstName; }
   public void setFirstName(String first) { this.firstName = first; }

   public String getLastName() { return lastName; }
   public void setLastName(String last) { this.lastName = last; }

   @Column(name="STREET", table="ADDRESS_TABLE")
   public String getStreet() { return street; }
   public void setStreet(String street) { this.street = street; }

   @Column(name="CITY", table="ADDRESS_TABLE")
   public String getCity() { return city; }
   public void setCity(String city) { this.city = city; }

   @Column(name="STATE", table="ADDRESS_TABLE")
   public String getState() { return state; }
   public void setState(String state) { this.state = state; }
}


 

    
    

    
