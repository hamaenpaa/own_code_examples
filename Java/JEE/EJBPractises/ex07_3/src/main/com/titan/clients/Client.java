package com.titan.clients;

import com.titan.access.*;
import com.titan.domain.*;

import javax.naming.Context;
import java.util.List;

public class Client 
{
    public static void main(String [] args) 
    {
        try 
	{
            Context jndiContext = getInitialContext();
            Object ref = jndiContext.lookup("DataAccessBean/remote");
            DataAccess dao = (DataAccess)ref;

            System.out.println("Fetch reservations with loaded relationships");
            System.out.println();
            List list = dao.fetchReservationsWithRelationships();
            for (Object obj : list)
            {
               Reservation res = (Reservation)obj;
               System.out.println("Reservation for: " + res.getCruise().getName());
               System.out.println("\tNum cabins: " + res.getCabins().size());
               System.out.println("\tNum customers: " + res.getCustomers().size());
            }
            System.out.println("----------");
            System.out.println("Try to access uninitialized relationships");
            System.out.println("----------");
            list = dao.fetchReservations();
            for (Object obj : list)
            {
               Reservation res = (Reservation)obj;
               System.out.println("Reservation for: " + res.getCruise().getName());
               try
               {
                  System.out.println("\tNum cabins: " + res.getCabins().size());
                  System.out.println("\tNum customers: " + res.getCustomers().size());
               }
               catch (org.hibernate.LazyInitializationException ex)
               {
                  System.out.println(ex.getMessage());
               }
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
