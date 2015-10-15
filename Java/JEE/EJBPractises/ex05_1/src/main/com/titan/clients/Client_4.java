package com.titan.clients;

import com.titan.travelagent.TravelAgentRemote;

import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

public class Client_4 
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup(TravelAgentRemote.class.getName());
            TravelAgentRemote dao = (TravelAgentRemote)
                PortableRemoteObject.narrow(ref,TravelAgentRemote.class);

            dao.flushModeExample();
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
