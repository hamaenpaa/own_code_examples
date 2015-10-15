package com.titan.domain;

import javax.persistence.*;

@Entity
@IdClass(CustomerPK.class)
public class Customer implements java.io.Serializable {
   private String firstName;
   private String lastName;
   private long ssn;

   public String getFirstName() { return firstName; }
   public void setFirstName(String firstName) { this.firstName = firstName; }

   @Id
   public String getLastName() { return lastName; }
   public void setLastName(String lastName) { this.lastName = lastName; }

   @Id
   public long getSsn() { return ssn; }
   public void setSsn(long ssn) { this.ssn = ssn; }
}


 

    
    

    
