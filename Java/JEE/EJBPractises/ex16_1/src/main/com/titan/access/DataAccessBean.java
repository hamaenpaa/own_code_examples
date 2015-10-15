package com.titan.access;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

import com.titan.domain.*;

@Stateless
public class DataAccessBean implements DataAccess
{
   @PersistenceContext(unitName="titan") private EntityManager manager;
    
   public List getCruises()
   {
      return manager.createQuery("FROM Cruise").getResultList();
   }

   public List getCabins(int cruiseId)
   {
      Ship ship = (Ship)manager.createQuery("SELECT cruise.ship FROM Cruise cruise WHERE cruise.id = " + cruiseId).getSingleResult();
      return manager.createQuery("FROM Cabin c WHERE c.ship = :ship").setParameter("ship", ship).getResultList();
   }

   public void initializeDB()
   {
      List list = manager.createQuery("FROM Ship ship").getResultList();
      if (list.size() > 0) 
      {
        return;
      }
      Ship queenMary = new Ship("Queen Mary", 40000.0);
      manager.persist(queenMary);
      Ship titanic = new Ship("Titanic", 100000.0);
      manager.persist(titanic);
      
      // Create cabins
      Cabin cabin1 = new Cabin();
      cabin1.setDeckLevel(1);
      cabin1.setShip(queenMary);
      cabin1.setBedCount(1);
      cabin1.setName("Queen Cabin 1");
      manager.persist(cabin1);

      Cabin cabin2 = new Cabin();
      cabin2.setDeckLevel(1);
      cabin2.setShip(queenMary);
      cabin2.setBedCount(1);
      cabin2.setName("Queen Cabin 2");
      manager.persist(cabin2);
         
      Cabin cabin3 = new Cabin();
      cabin3.setDeckLevel(1);
      cabin3.setShip(titanic);
      cabin3.setBedCount(2);
      cabin3.setName("Titanic Cabin 1");
      manager.persist(cabin3);
         
      Cabin cabin4 = new Cabin();
      cabin4.setDeckLevel(1);
      cabin4.setShip(titanic);
      cabin4.setBedCount(2);
      cabin4.setName("Titanic Cabin 2");
      manager.persist(cabin4);
         
      Cabin cabin5 = new Cabin();
      cabin5.setDeckLevel(1);
      cabin5.setShip(titanic);
      cabin5.setBedCount(2);
      cabin5.setName("Titanic Cabin 3");
      manager.persist(cabin5);

      // Create cruise
      Cruise alaskan = new Cruise("Alaskan Cruise", queenMary);
      manager.persist(alaskan);
      Cruise atlantic = new Cruise("Atlantic Cruise", titanic);
      manager.persist(atlantic);

      // Create cabins
      CruiseCabin ccabin1 = new CruiseCabin();
      ccabin1.setCabin(cabin1);
      ccabin1.setCruise(alaskan);
      manager.persist(ccabin1);

      CruiseCabin ccabin2 = new CruiseCabin();
      ccabin2.setCabin(cabin2);
      ccabin2.setCruise(alaskan);
      manager.persist(ccabin2);
         
      CruiseCabin ccabin3 = new CruiseCabin();
      ccabin3.setCabin(cabin3);
      ccabin3.setCruise(atlantic);
      manager.persist(ccabin3);
         
      CruiseCabin ccabin4 = new CruiseCabin();
      ccabin4.setCabin(cabin4);
      ccabin4.setCruise(atlantic);
      manager.persist(ccabin4);
         
      CruiseCabin ccabin5 = new CruiseCabin();
      ccabin5.setCabin(cabin5);
      ccabin5.setCruise(atlantic);
      manager.persist(ccabin5);
   }
}
