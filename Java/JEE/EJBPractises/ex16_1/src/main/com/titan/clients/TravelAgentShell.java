package com.titan.clients;

import com.titan.domain.*;
import com.titan.travelagent.*;
import com.titan.processpayment.*;
import com.titan.access.DataAccess;
import javax.naming.*;
import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;

public class TravelAgentShell
{
   public static void main(String[] args) throws Exception
   {
      System.out.println();
      System.out.println("********************");
      System.out.println("    Titan Cruises");
      System.out.println("********************");
      System.out.println();
      TravelAgentShell shell = new TravelAgentShell();
      shell.shell();
   }

   private TravelAgentRemote agent;
   private DataAccess access;

   private TravelAgentRemote getAgent()
   {
      try
      {
         if (agent == null) agent = (TravelAgentRemote)getInitialContext().lookup("TravelAgentBean/remote");
      }
      catch (Exception ex){ throw new RuntimeException(ex);}
      return agent;
   }

   public void shell() throws Exception
   {
      access = (DataAccess)getInitialContext().lookup("DataAccessBean/remote");
      access.initializeDB();

      while (true)
      {
         System.out.println();
         System.out.print("> ");

         String command = "";
         char read = '\0';

         while (read != '\r' && read != '\n')
         {
            read = (char)System.in.read();
            command = command + read;
         }

         // clear out newlines from system input
         int available = System.in.available();
         for (int i = 0; i < available; i++) System.in.read();

         command = command.trim();
         if (command.equals(""))
         {
            continue;
         }
         processCommand(command);
      }
   }

   public void processCommand(String command)
   {
      if (command.startsWith("help"))
      {
         help();
      }
      else if (command.startsWith("cruises"))
      {
         cruises();
      }
      else if (command.startsWith("cabins"))
      {
         cabins(command);
      }
      else if (command.startsWith("cruise"))
      {
         cruise(command);
      }
      else if (command.startsWith("cabin"))
      {
         cabin(command);
      }
      else if (command.startsWith("book"))
      {
         book(command);
      }
      else if (command.startsWith("customer"))
      {
         customer(command);
      }
      else if (command.startsWith("checkout"))
      {
         checkout();
      }
      else
      {
         System.out.println("UNKNOWN COMMAND!");
      }
   }

   public void cruises()
   {
      System.out.println();
      List list = access.getCruises();
      for (Object obj : list)
      {
         Cruise cruise = (Cruise)obj;
         System.out.println(cruise.getId() + "   " + cruise.getName());
      }
   }

   public void cabins(String command)
   {
      StringTokenizer tokens = new StringTokenizer(command);
      tokens.nextToken();
      int cruiseId = Integer.parseInt(tokens.nextToken().trim());
         
      System.out.println();
      List list = access.getCabins(cruiseId);
      for (Object obj : list)
      {
         Cabin cabin = (Cabin)obj;
         System.out.println(cabin.getId() + "   " + cabin.getName());
      }
      System.out.println();
   }

   public void customer(String command)
   {
      StringTokenizer tokens = new StringTokenizer(command);
      tokens.nextToken();
      String first = tokens.nextToken().trim();
      String last = tokens.nextToken().trim();
      getAgent().findOrCreateCustomer(first, last);
      System.out.println("set customer: " + first + " " + last);
   }

   public void cruise(String command)
   {
      StringTokenizer tokens = new StringTokenizer(command);
      tokens.nextToken();
      String id = tokens.nextToken().trim();
      int cruiseId = Integer.parseInt(id);
      getAgent().setCruiseID(cruiseId);
      System.out.println("set cruise: " + id);
   }

   public void cabin(String command)
   {
      StringTokenizer tokens = new StringTokenizer(command);
      tokens.nextToken();
      String id = tokens.nextToken().trim();
      int cabinId = Integer.parseInt(id);
      getAgent().setCabinID(cabinId);
      System.out.println("set cabin");
   }

   public void checkout()
   {
      getAgent().checkout();
      agent = null;
   }

   public void book(String command)
   {
      StringTokenizer tokens = new StringTokenizer(command);
      tokens.nextToken();
      String number = tokens.nextToken().trim();
      String exp = tokens.nextToken().trim();
      String dollars = tokens.nextToken().trim();

      Date expDate = null;
      try
      {
         expDate = DateFormat.getDateInstance(DateFormat.SHORT).parse(exp);
      }
      catch (ParseException ex) 
      { 
         System.out.println("Illegal date format for expiration date! Format is MM/DD/YY");
         return;
      }
      if (expDate.before(new java.util.Date()))
      {
         System.out.println("Credit Card expired: " + expDate.toString() + " today: " + (new java.util.Date()).toString());
         return;
      }
      double amount = Double.parseDouble(dollars);

      String type = "";
      // bet you didn't know that first digit determines type?
      if (number.startsWith("5")) type = CreditCardDO.MASTER_CARD;
      else if (number.startsWith("4")) type = CreditCardDO.VISA;
      else if (number.startsWith("3")) type = CreditCardDO.AMERICAN_EXPRESS;
      else type = "UNKNOWN";
      
      CreditCardDO card = new CreditCardDO(number, expDate, type);
      try
      {
         TicketDO ticket = getAgent().bookPassage(card, amount);
         System.out.println(ticket.toString());
         System.out.println();
      }
      catch (IncompleteConversationalState ex)
      {
         System.out.println("You have not set either customer, cruise, or cabin yet.");
      }
   }

   public void help()
   {
      System.out.println();
      System.out.println("Titan Cruises Commands");
      System.out.println();
      System.out.println("cruises - list all cruises");
      System.out.println("cabins {cruiseId} - list all cabins");
      System.out.println("customer {first} {last} - find or create a customer");
      System.out.println("cabin {id} - set cabin");
      System.out.println("cruise {id} - set cruise");
      System.out.println("book {credit, MM/DD/YY, amount} - book a cruise");
      System.out.println("checkout");
   }


   static public Context getInitialContext() throws Exception
   {
      return new InitialContext();
   }

}
