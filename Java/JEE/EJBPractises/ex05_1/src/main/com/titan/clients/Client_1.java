package com.titan.clients;

import com.titan.travelagent.TravelAgentRemote;
import com.titan.domain.Cabin;

import javax.naming.Context;

public class Client_1 
{
    public static void main(String [] args) 
    {
        try 
        {
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("TravelAgentBean/remote");
            TravelAgentRemote dao = (TravelAgentRemote)ref;

            Cabin noCabin = dao.findCabin(1);
            System.out.println("no cabin should be null: " + noCabin);

            Cabin cabin_1 = new Cabin();
            cabin_1.setId(1);
            cabin_1.setName("Master Suite");
            cabin_1.setDeckLevel(1);
            cabin_1.setShipId(1);
            cabin_1.setBedCount(3);

            dao.createCabin(cabin_1);

            Cabin cabin_2 = dao.findCabin(1);
            System.out.println(cabin_2.getName());
            System.out.println(cabin_2.getDeckLevel());
            System.out.println(cabin_2.getShipId());
            System.out.println(cabin_2.getBedCount());

	    System.out.println("Updating detached cabin instance with new bed count of 4");
	    cabin_2.setBedCount(4);
	    dao.updateCabin(cabin_2);

	    System.out.println("Finding cabin to see it has been updated with a merge() on server");
            Cabin cabin_3 = dao.findCabin(1);
	    System.out.println("new bed count is: " + cabin_3.getBedCount());
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
