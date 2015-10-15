package com.titan.clients;

import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.Session;
import javax.jms.Queue;
import javax.jms.MessageConsumer;
import javax.jms.JMSException;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.titan.travelagent.TicketDO;

public class JmsClient_TicketConsumer
   implements javax.jms.MessageListener
{
   
   public static void main(String [] args) throws Exception
   {      
      new JmsClient_TicketConsumer();
      
      while(true) { Thread.sleep (10000); }      
   }
   
   public JmsClient_TicketConsumer () throws Exception
   {      
      Context jndiContext = getInitialContext ();
      
      ConnectionFactory factory = (ConnectionFactory)
      jndiContext.lookup ("ConnectionFactory");
      
      Queue ticketQueue = (Queue)
      jndiContext.lookup ("queue/titan-TicketQueue");
      
      Connection connect = factory.createConnection();      
      Session session =
         connect.createSession(false,Session.AUTO_ACKNOWLEDGE);      
      MessageConsumer receiver = session.createConsumer(ticketQueue);      
      receiver.setMessageListener(this);
      
      System.out.println ("Listening for messages on titan-TicketQueue...");
      connect.start ();
   }
   
   public void onMessage (Message message)
   {      
      try
      {         
         ObjectMessage objMsg = (ObjectMessage)message;
         TicketDO ticket = (TicketDO)objMsg.getObject ();
         System.out.println ("********************************");
         System.out.println (ticket);
         System.out.println ("********************************");
         
      }
      catch (JMSException displayed)
      {
         displayed.printStackTrace ();
      }
   }
   
   public static Context getInitialContext ()
      throws javax.naming.NamingException
   {
      return new InitialContext ();
   }
}
