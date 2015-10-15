package com.titan.stats;

import javax.persistence.*;
import java.util.concurrent.ConcurrentHashMap;

public class EntityListener
{
   public static class Stats
   {
      public String entity;
      public int updates;
      public int loads;
      public int inserts;
      public int removes;
   }

   public static ConcurrentHashMap<String, Stats> map = new ConcurrentHashMap<String, Stats>();


   private static Stats getStats(Object entity)
   {
      String name = entity.getClass().getName();
      Stats stats = map.get(name);
      if (stats == null) 
      {
         stats = new Stats();
         map.put(name, stats);
         stats.entity = name;
      }
      return stats;
   }

   @PostUpdate
   public void update(Object entity)
   {
      System.out.println("@PostUpdate: " + entity.getClass().getName());
      Stats stats = getStats(entity);
      synchronized(stats) {stats.updates++;}
   }

   @PostPersist
   public void persist(Object entity)
   {
      System.out.println("@PostPersist: " + entity.getClass().getName());
      Stats stats = getStats(entity);
      synchronized(stats) {stats.inserts++;}
   }

   @PostLoad
   public void load(Object entity)
   {
      System.out.println("@PostLoad: " + entity.getClass().getName());
      Stats stats = getStats(entity);
      synchronized(stats) {stats.loads++;}
   }
      
   @PostRemove
   public void remove(Object entity)
   {
      System.out.println("@PostRemove: " + entity.getClass().getName());
      Stats stats = getStats(entity);
      synchronized(stats) {stats.removes++;}
   }
   
}
