/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.ejb.chapter02;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.DependsOn;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Schedule;
import javax.ejb.Timer;

@Singleton
@Startup
@DependsOn("ShopperCount")
public class LogShopperCountBean implements LogShopperCountLocal, LogShopperCount {
   private final Logger log = Logger.getLogger("LogShopperCount.class");

   // Logs shopper count every 2 hours
   @Schedule(hour="*/2")   
   public void logShopperCount(Timer timer) {
       // Log shopper count
       String timerInfo = (String) timer.getInfo();
       System.out.println(timerInfo);
   }
   
   // Reset counter
   @PostConstruct
   public void applicationStartup() {
       System.out.println("LogShopper created");
   }

   @PreDestroy
   public void applicationShutdown() {
      System.out.println("LogShopper to be destroyed");
   }   
   
}
