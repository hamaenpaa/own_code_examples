package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.FlushModeType;

import com.titan.domain.Cabin; 

@Stateless
public class TravelAgentBean implements TravelAgentRemote
{
   @PersistenceUnit(unitName="titan") private EntityManagerFactory factory;
   @PersistenceContext(unitName="titan") private EntityManager manager;
    
   public void createCabin(Cabin cabin)
   {
      manager.persist(cabin);
   }

   public Cabin findCabin(int pKey)
   {
      return manager.find(Cabin.class, pKey);
   }
   
   public void updateCabin(Cabin cabin)
   {
      manager.merge(cabin);
   }
   
   public void flushModeExample()
   {
      EntityManager createdManager = factory.createEntityManager();
        
      try
      {
         Cabin newCabin2 = new Cabin();
         newCabin2.setId(2);
         newCabin2.setName("Another Cabin");
         newCabin2.setBedCount(1);
         createdManager.persist(newCabin2);

         Cabin cabin2 = manager.find(Cabin.class, 2);
         if (cabin2 != null) 
         {
            throw new RuntimeException("newCabin2 should not be flushed yet");
         }

         Cabin cabin1 = (Cabin)createdManager.createQuery("FROM Cabin c WHERE c.id = 1").getSingleResult();
            
         cabin2 = manager.find(Cabin.class, 2);
         if (cabin2 == null)
         {
            throw new RuntimeException("newCabin2 should be flushed now");
         }

         createdManager.setFlushMode(FlushModeType.COMMIT);
         newCabin2.setBedCount(99);

         cabin1 = (Cabin)createdManager.createQuery("FROM Cabin c WHERE c.id = 1").getSingleResult();

         manager.refresh(cabin2);
         if (cabin2.getBedCount() == 99) 
         {
            throw new RuntimeException("should not be 99 yet with COMMIT and a query");
         }

         createdManager.flush();

         manager.refresh(cabin2);
         if (cabin2.getBedCount() != 99)
         {
            throw new RuntimeException("should be 99 yet with a flush");
         }
      }
      finally
      {
         createdManager.close();
      }
   }
}
