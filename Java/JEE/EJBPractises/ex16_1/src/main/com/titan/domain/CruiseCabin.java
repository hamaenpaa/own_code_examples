package com.titan.domain;

import javax.persistence.*;

@Entity
public class CruiseCabin {
   private int id;
   private Cabin cabin;
   private Cruise cruise;
   private boolean isReserved;
   private long version;

   @Id
   @GeneratedValue
   public int getId() {
      return id;
   }
   public void setId(int id) {
      this.id = id;
   }
  
   @ManyToOne
   public Cabin getCabin() {
      return cabin;
   }
   public void setCabin(Cabin cabin) {
      this.cabin = cabin;
   }

   @ManyToOne
   public Cruise getCruise() {
      return cruise;
   }

   public void setCruise(Cruise cruise)
   {
      this.cruise = cruise;
   }
  
   public boolean getIsReserved() {
      return isReserved;
   }
   public void setIsReserved(boolean is) {
     isReserved = is;
   }

   @Version
   protected long getVersion() {
      return version;
   }
   protected void setVersion(long version) {
      this.version = version;
   }
}
