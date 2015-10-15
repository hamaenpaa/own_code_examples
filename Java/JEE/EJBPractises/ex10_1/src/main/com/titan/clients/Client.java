package com.titan.clients;

import com.titan.travelagent.TravelAgentRemote;
import com.titan.domain.*;

import javax.naming.Context;

import javax.rmi.PortableRemoteObject;

public class Client 
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("TravelAgentBean/remote");
            TravelAgentRemote dao = (TravelAgentRemote)
                PortableRemoteObject.narrow(ref,TravelAgentRemote.class);

            Customer cust = new Customer();
            cust.setFirstName("Bill");
            cust.setLastName("Burke");
            int pk = dao.createCustomer(cust);

            cust = dao.findCustomer(pk);
            cust.setFirstName("Billy");
            dao.doMerge(cust);
            dao.doFlush(cust.getId());
            dao.doRemove(cust.getId());
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
