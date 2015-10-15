package com.titan.clients;

import javax.jms.MapMessage;
import javax.jms.Session;
import javax.jms.ConnectionFactory;
import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.Queue;
import javax.jms.MessageProducer;

import javax.naming.Context;
import javax.naming.InitialContext;

import java.util.Date;

import com.titan.processpayment.*;
import com.titan.access.DataAccess;


public class JmsClient_ReservationProducer
{
   
   public static void main(String [] args) throws Exception
   {
      
      if(args.length != 2)
         throw new Exception("Usage: java JmsClient_ReservationProducer <CruiseID> <count>");
      
      Integer cruiseID = new Integer(args[0]);
      int count = new Integer(args[1]).intValue();
      
      Context jndiContext = getInitialContext();
      
      DataAccess access =(DataAccess)jndiContext.lookup("DataAccessBean/remote");
      access.initializeDB();
      try
      {
         access.makePaymentDbTable();
      }
      catch (Exception ignored) {}

      ConnectionFactory factory =(ConnectionFactory)jndiContext.lookup("ConnectionFactory");
      
      Queue reservationQueue =(Queue)jndiContext.lookup("queue/titan-ReservationQueue");
      Queue ticketQueue =(Queue)jndiContext.lookup("queue/titan-TicketQueue");
      
      Connection connect = factory.createConnection();      
      Session session = connect.createSession(false, Session.AUTO_ACKNOWLEDGE);
      MessageProducer sender = session.createProducer(reservationQueue);
      
      for(int i = 0; i < count; i++)
      {         
         MapMessage message = session.createMapMessage();
         
         message.setJMSReplyTo(ticketQueue);  // Used in ReservationProcessor to send Tickets back out
         
         message.setStringProperty("MessageFormat", "Version 3.4");
         
         message.setInt("CruiseID", cruiseID);
         message.setInt("CustomerID", i%2 + 1);  // either Customer 1 or 2, all we've got in database
         message.setInt("CabinID", i%5 + 1);  // cabins 100-109 only
         message.setDouble("Price",(double)1000 + i);
         
         // the card expires in about 30 days
         //
         Date expDate = new Date(System.currentTimeMillis() + 30*24*60*60*1000L);
         
         message.setString("CreditCardNum", "5549861006051975");
         message.setLong("CreditCardExpDate", expDate.getTime());
         message.setString("CreditCardType", CreditCardDO.MASTER_CARD);
         
         System.out.println("Sending reservation message #"+i);
         sender.send(message);
      }
      
      connect.close();
   }
   
   public static Context getInitialContext()
      throws javax.naming.NamingException
   {
      return new InitialContext();
   }
}
