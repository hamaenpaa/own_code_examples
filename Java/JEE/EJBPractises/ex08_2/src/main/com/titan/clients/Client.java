package com.titan.clients;

import com.titan.access.DataAccessRemote;
import com.titan.domain.*;

import javax.naming.Context;
import java.util.List;
import javax.rmi.PortableRemoteObject;

public class Client 
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("DataAccessBean/remote");
            DataAccessRemote dao = (DataAccessRemote)
                PortableRemoteObject.narrow(ref,DataAccessRemote.class);
            dao.initializeDatabase();
            List persons = dao.findAllPersons();
            System.out.println("persons.size() = " + persons.size());
            for (Object obj : persons)
            {
               Person p = (Person)obj;
               System.out.println("\tclass is: " + p.getClass().getName());
               System.out.println("\tperson: " + p.getFirstName() + " " 
                                  + p.getLastName());
            }
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
