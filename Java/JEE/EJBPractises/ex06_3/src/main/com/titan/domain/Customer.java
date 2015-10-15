package com.titan.domain;

import javax.persistence.*;

@Entity
public class Customer implements java.io.Serializable {
   private String firstName;
   private CustomerPK pk;

   public String getFirstName() { return firstName; }
   public void setFirstName(String firstName) { this.firstName = firstName; }

   @EmbeddedId
   @AttributeOverrides({
       @AttributeOverride(name="lastName", column=@Column(name="LAST_NAME")),
       @AttributeOverride(name="ssn", column=@Column(name="SSN"))
   })
   public CustomerPK getPk() { return pk; }
   public void setPk(CustomerPK pk) { this.pk = pk; }

   @Transient
   public String getLastName() { return pk.getLastName(); }

   @Transient
   public long getSsn() { return pk.getSsn(); }
}
