package com.titan.clients;

import com.titan.travelagent.TravelAgentRemote;
import com.titan.domain.*;

import javax.naming.Context;

public class Client 
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("TravelAgentBean/remote");
            TravelAgentRemote dao = (TravelAgentRemote)ref;

            Customer cust = new Customer();
            cust.setFirstName("Bill");
            cust.setLastName("Burke");
            cust.setStreet("Clarendon Street");
            cust.setCity("Boston");
            cust.setState("MA");

            long pk = dao.createCustomer(cust);

            
            cust = dao.findCustomer(pk);
            System.out.println(cust.getFirstName());
            System.out.println(cust.getLastName());
            System.out.println(cust.getStreet());
            System.out.println(cust.getCity());
            System.out.println(cust.getState());
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
