package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.titan.domain.Cabin; 

@Stateless
public class TravelAgentBean implements TravelAgentRemote
{
    @PersistenceContext(unitName="titan") private EntityManager manager;
    
    public void createCabin(Cabin cabin)
    {
        manager.persist(cabin);
    }

    public Cabin findCabin(int pKey)
    {
        return manager.find(Cabin.class, pKey);
    }
}
