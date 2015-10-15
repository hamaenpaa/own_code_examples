package com.titan.domain;

import javax.persistence.*;

@Embeddable
public class CustomerPK implements java.io.Serializable 
{
   private String lastName;
   private long ssn;

   public CustomerPK() {}

   public CustomerPK(String lastName, long ssn)
   {
      this.lastName = lastName;
      this.ssn = ssn;
   }

   @Column(name="CUSTOMER_LAST_NAME")
   public String getLastName() { return this.lastName; }
   public void setLastName(String lastName) { this.lastName = lastName; }

   @Column(name="CUSTOMER_SSN")
   public long getSsn() { return ssn; }
   public void setSsn(long ssn) { this.ssn = ssn; }

   public boolean equals(Object obj)
   {
      if (obj == this) return true;
      if (!(obj instanceof CustomerPK)) return false;
      CustomerPK pk = (CustomerPK)obj;
      if (!lastName.equals(pk.lastName)) return false;
      if (ssn != pk.ssn) return false;
      return true;
   }
   
   public int hashCode()
   {
      return lastName.hashCode() + (int)ssn;
   }
}
