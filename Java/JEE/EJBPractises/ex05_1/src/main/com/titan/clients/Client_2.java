package com.titan.clients;

import com.titan.travelagent.TravelAgentRemote;
import com.titan.travelagent.ExtendedPersistenceContextRemote;
import com.titan.travelagent.TransactionPersistenceContextRemote;
import com.titan.domain.Cabin;

import javax.naming.Context;

public class Client_2
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("TravelAgentBean/remote");
            TravelAgentRemote dao = (TravelAgentRemote)ref;


            ref = jndiContext.lookup("TransactionPersistenceContextBean/remote");
            TransactionPersistenceContextRemote txBean = (TransactionPersistenceContextRemote)ref;

	    Cabin fetchedCabin = dao.findCabin(1);
            int oldBedCount = fetchedCabin.getBedCount();

	    System.out.println("Set up transaction persistence context stateful bean");
	    txBean.setCabin(1);
	    txBean.updateBedCount(5);

	    fetchedCabin = dao.findCabin(1);
	    System.out.println("Cabin bed count will still be " + oldBedCount + ": " + fetchedCabin.getBedCount());

	    System.out.println("Set up extended persistence context stateful bean");

            ref = jndiContext.lookup("ExtendedPersistenceContextBean/remote");
            ExtendedPersistenceContextRemote extendedBean = (ExtendedPersistenceContextRemote)ref;


	    extendedBean.setCabin(1);
	    extendedBean.updateBedCount(5);

	    fetchedCabin = dao.findCabin(1);
	    System.out.println("Cabin bed count will be 5: " + fetchedCabin.getBedCount());

	    // cleanup
	    txBean.remove();
	    extendedBean.remove();
        } 
        catch (javax.naming.NamingException ne)
        {
	    ne.printStackTrace();
	}
    }

    public static Context getInitialContext() 
        throws javax.naming.NamingException 
    {
        return new javax.naming.InitialContext();
    }
}
