package com.titan.clients;

import com.titan.simple.SimpleRemote;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class Client
{
   
   public static void main(String [] args)
   {
      try
      {
         Context jndiContext = getInitialContext();
         
         SimpleRemote bean = (SimpleRemote)jndiContext.lookup("SimpleBean/remote");
         
         bean.echo("hello world");
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
