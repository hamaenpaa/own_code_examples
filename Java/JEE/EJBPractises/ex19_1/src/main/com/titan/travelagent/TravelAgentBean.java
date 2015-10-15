package com.titan.travelagent;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.titan.domain.Cabin; 

@WebService(name = "TravelAgent", serviceName="TravelAgentService")
@Stateless
public class TravelAgentBean implements TravelAgentRemote
{
    @PersistenceContext(unitName="titan") private EntityManager manager;
   
    @WebMethod 
    public void createCabin(
       @WebParam(name = "Cabin")
       Cabin cabin
    )
    {
	manager.persist(cabin);
    }

    @WebMethod
    @WebResult(name = "Cabin")
    public Cabin findCabin(
       @WebParam(name = "ID")
       int pKey
    )
    {
	return manager.find(Cabin.class, pKey);
    }
}
