package com.titan.clients;

import com.titan.maintenance.ShipMaintenanceRemote;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;

/**
 * Example demonstrating use of ProcessPayment EJB directly
 *
 */

public class ScheduleMaintenance
{
   
   public static void main(String [] args)
   {
      try
      {
         if (args.length < 2)
         {
            System.err.println("usage: ScheduleMaintenance <ship-name> <description>");
            return;
         }
         // obtain CustomerHome
         Context jndiContext = getInitialContext();
         ShipMaintenanceRemote access = (ShipMaintenanceRemote)jndiContext.lookup("ShipMaintenanceBean/remote");

         String ship = args[0];
         Date date = new Date(System.currentTimeMillis() + 5000);
         String desc = args[1];

         access.scheduleMaintenance(ship, desc, date); 
      }
      catch(Throwable t)
      {
         t.printStackTrace();
      }
      
   }
   
   static public Context getInitialContext() throws Exception
   {
      return new InitialContext();
   }
   
}

