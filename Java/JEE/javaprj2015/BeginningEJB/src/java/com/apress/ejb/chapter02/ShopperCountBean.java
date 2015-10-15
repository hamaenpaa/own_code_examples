package com.apress.ejb.chapter02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
@Singleton (name = "ShopperCount")
@Startup
public class ShopperCountBean implements ShopperCountLocal {
   private int shopperCounter;

   // Reset counter
   @PostConstruct
   public void applicationStartup() {
       System.out.println("From applicationStartup method.");
       resetCounter();
   }

   @PreDestroy
   public void applicationShutdown() {
      System.out.println("From applicationShutdown method.");
   }   
   
   
   // Increment number of shopper counter
   @Lock(LockType.WRITE)
   public void incrementShopperCount() {
       shopperCounter++;
   }

   // Return number of shoppers
   @Lock(LockType.READ)
   public int getShopperCount() {
       return shopperCounter;
   }
   
   // Reset counter
   @Lock(LockType.WRITE)
   public void resetCounter() {
       shopperCounter = 0;
   }   
}
