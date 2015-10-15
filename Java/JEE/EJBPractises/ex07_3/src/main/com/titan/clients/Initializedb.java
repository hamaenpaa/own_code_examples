package com.titan.clients;

import com.titan.access.*;

import javax.naming.Context;

public class Initializedb
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("DataAccessBean/remote");
            DataAccess dao = (DataAccess)ref;
            System.out.println(dao.initializeDatabase());
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
