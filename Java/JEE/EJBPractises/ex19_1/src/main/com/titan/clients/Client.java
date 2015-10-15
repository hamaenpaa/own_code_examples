package com.titan.clients;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

public class Client 
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            TravelAgentService service = 
               (TravelAgentService) jndiContext.lookup("java:comp/env/service/TravelAgentService");
            TravelAgent agent = service.getTravelAgentPort(); 

            Cabin cabin_1 = new Cabin();
            cabin_1.setId(1);
            cabin_1.setName("Master Suite");
            cabin_1.setDeckLevel(1);
            cabin_1.setShipId(1);
            cabin_1.setBedCount(3);

            agent.createCabin(cabin_1);

            Cabin cabin_2 = agent.findCabin(1);
            System.out.println(cabin_2.getName());
            System.out.println(cabin_2.getDeckLevel());
            System.out.println(cabin_2.getShipId());
            System.out.println(cabin_2.getBedCount());

        } 
        catch (javax.naming.NamingException ne)
        {
	    ne.printStackTrace();
	}
        catch (java.rmi.RemoteException re)
        {
            re.printStackTrace();
        }
        catch (javax.xml.rpc.ServiceException se)
        {
            se.printStackTrace();
        }
    }

    public static Context getInitialContext() 
        throws javax.naming.NamingException 
    {
        return new javax.naming.InitialContext();
    }
}
