package com.titan.simple;

import com.titan.annotations.JndiInjected;
import javax.ejb.*;
import javax.transaction.TransactionManager;


@Stateless
public class SimpleBean implements SimpleRemote
{

   @JndiInjected("java:/TransactionManager")
   TransactionManager tm;

   public void echo(String message) throws Exception
   {
      System.out.print(message);

      System.out.println("Is there a transaction: " + (tm.getTransaction() != null));
   }

}


