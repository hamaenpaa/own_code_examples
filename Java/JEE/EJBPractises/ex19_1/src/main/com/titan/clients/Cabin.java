package com.titan.clients;

/**
 * A Cabin DTO for JAX-RPC
 */
public class Cabin {
   private int bedCount;
   private int deckLevel;
   private int id;
   private int shipId;
   private String name;

   public Cabin() 
   {
   }
  
   public Cabin(int id, String name, int shipId, int deckLevel, int bedCount) 
   {
      this.bedCount = bedCount;
      this.deckLevel = deckLevel;
      this.id = id;
      this.name = name;
      this.shipId = shipId;
   }
   
   public int getBedCount() 
   {
      return bedCount;
   }
   
   public void setBedCount(int bedCount) 
   {
      this.bedCount = bedCount;
   }
   
   public int getDeckLevel() 
   {
      return deckLevel;
   }
   
   public void setDeckLevel(int deckLevel)
   {
      this.deckLevel = deckLevel;
   }
   
   public int getId()
   {
      return id;
   }
   
   public void setId(int id)
   {
      this.id = id;
   }
   
   public java.lang.String getName()
   {
      return name;
   }
    
   public void setName(java.lang.String name)
   {
      this.name = name;
   }
    
   public int getShipId()
   {
      return shipId;
   }
    
   public void setShipId(int shipId)
   {
      this.shipId = shipId;
   }
}
