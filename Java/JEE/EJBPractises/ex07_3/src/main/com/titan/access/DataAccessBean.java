package com.titan.access;

import javax.persistence.*;
import javax.ejb.*;
import java.io.*;

import com.titan.domain.*;
import java.util.List;
import java.util.Date;


@Stateless
public class DataAccessBean implements DataAccess
{
   @PersistenceContext(unitName="titan") EntityManager manager;
   
   public List fetchReservations()
   {
      return manager.createQuery("FROM Reservation res").getResultList();
   }

   public List fetchReservationsWithRelationships()
   {
      List list = manager.createQuery("FROM Reservation res").getResultList();
      for (Object obj : list)
      {
         Reservation res = (Reservation)obj;
         res.getCabins().size();
         res.getCustomers().size();
      }
      return list;
   }

   public String initializeDatabase()
   {
      List list = manager.createQuery("FROM Reservation res").getResultList();
      if (list.size() > 0) 
      {
         return "Database already initialized with entities";
      }
      

      String output = null;
      StringWriter writer = new StringWriter();
      PrintWriter out = new PrintWriter(writer);
      
      Customer bill = new Customer();
      bill.setFirstName("Bill");
      bill.setLastName("Burke");
      bill.setHasGoodCredit(true);

      Customer sacha = new Customer();
      sacha.setFirstName("Sacha");
      sacha.setLastName("Labourey");
      sacha.setHasGoodCredit(false); // Sacha get's bad credit ;)

      Customer marc = new Customer();
      marc.setFirstName("Marc");
      marc.setLastName("Fleury");
      marc.setHasGoodCredit(true);

      Address addr = new Address();
      addr.setStreet("123 Boston Road");
      addr.setCity("Billerica");
      addr.setState("MA");
      addr.setZip("01821");
      bill.setAddress(addr);

      addr = new Address();
      addr.setStreet("Etwa Schweitzer Strasse");
      addr.setCity("Neuchatel");
      addr.setState("Switzerland");
      addr.setZip("07711");
      sacha.setAddress(addr);

      addr = new Address();
      addr.setStreet("JBoss Dr.");
      addr.setState("Atlanta");
      addr.setCity("GA");
      addr.setZip("06660");
      marc.setAddress(addr);

      CreditCard cc;
      cc = new CreditCard();
      cc.setExpirationDate(new Date());
      cc.setNumber("5324 9393 1010 2929");
      cc.setNameOnCard("Bill Burke");
      cc.setCreditOrganization("Capital One");
      bill.setCreditCard(cc);

      cc = new CreditCard();
      cc.setExpirationDate(new Date());
      cc.setNumber("3311 5000 1011 2333");
      cc.setNameOnCard("Sacha Labourey");
      cc.setCreditOrganization("American Express");
      sacha.setCreditCard(cc);

      cc = new CreditCard();
      cc.setNumber("4310 5131 7711 2663");
      cc.setNameOnCard("Marc Fleury");
      cc.setCreditOrganization("MBNA");
      marc.setCreditCard(cc);

      out.println("added Bill Burke");
      manager.persist(bill);
      out.println("added Sacha Labourey");
      manager.persist(sacha);
      out.println("added Marc Fleury");
      manager.persist(marc);

      Ship queenMary = new Ship("Queen Mary", 40.0);
      manager.persist(queenMary);
      out.println("added Query Mary ship");
      Ship titanic = new Ship("Titanic", 80.0);
      manager.persist(titanic);
      out.println("added Titanic ship");
      
      // Create cabins
      Cabin cabin1 = new Cabin();
      cabin1.setDeckLevel(1);
      cabin1.setShip(queenMary);
      cabin1.setBedCount(1);
      cabin1.setName("Queen Cabin 1");
      manager.persist(cabin1);
      out.println("Added Queen Cabin 1 to Queen Mary");

      Cabin cabin2 = new Cabin();
      cabin2.setDeckLevel(1);
      cabin2.setShip(queenMary);
      cabin2.setBedCount(1);
      cabin2.setName("Queen Cabin 2");
      manager.persist(cabin2);
      out.println("Added Queen Cabin 2 to Queen Mary");
         
      Cabin cabin3 = new Cabin();
      cabin3.setDeckLevel(1);
      cabin3.setShip(titanic);
      cabin3.setBedCount(2);
      cabin3.setName("Titanic Cabin 1");
      manager.persist(cabin3);
      out.println("Titanic Cabin 1 to Titanic");
         
      Cabin cabin4 = new Cabin();
      cabin4.setDeckLevel(1);
      cabin4.setShip(titanic);
      cabin4.setBedCount(2);
      cabin4.setName("Titanic Cabin 2");
      manager.persist(cabin4);
      out.println("Titanic Cabin 2 to Titanic");
         
      Cabin cabin5 = new Cabin();
      cabin5.setDeckLevel(1);
      cabin5.setShip(titanic);
      cabin5.setBedCount(2);
      cabin5.setName("Titanic Cabin 3");
      manager.persist(cabin5);
      out.println("Titanic Cabin 3 to Titanic");

      // Create cruise
      Cruise alaskan = new Cruise("Alaskan Cruise", queenMary);
      manager.persist(alaskan);
      out.println("added Alaskan Cruise on the Queen Mary");
      Cruise atlantic = new Cruise("Atlantic Cruise", titanic);
      manager.persist(atlantic);
      out.println("added Atlantic Cruise on the Titanic");

      Reservation alaskanReservation = new Reservation();
      alaskanReservation.setCruise(alaskan);
      alaskanReservation.getCabins().add(cabin1);
      alaskanReservation.getCabins().add(cabin2);
      alaskanReservation.getCustomers().add(bill);
      alaskanReservation.getCustomers().add(sacha);
      manager.persist(alaskanReservation);
      out.println("Booked Bill and Sacha on Alaskan cruise in Cabin 1 and Cabin 2");
      
      Reservation atlanticReservation = new Reservation();
      atlanticReservation.setCruise(atlantic);
      atlanticReservation.getCabins().add(cabin3);
      atlanticReservation.getCustomers().add(marc);
      manager.persist(atlanticReservation);
      out.println("Booked Marc in Cabin 1 on the Atlantic Cruise on the Titanic.  Say hi to Leo for us!");

      out.close();
      output = writer.toString();

      return output;
   }
}

