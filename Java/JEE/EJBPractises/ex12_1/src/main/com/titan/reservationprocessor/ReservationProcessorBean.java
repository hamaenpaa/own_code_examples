package com.titan.reservationprocessor;
     
import com.titan.domain.*;
import com.titan.processpayment.*;
import com.titan.travelagent.*;
import java.util.Date;
import javax.annotation.*;
import javax.ejb.*;
import javax.jms.*;
import javax.persistence.*;
import javax.naming.*;

@MessageDriven(activationConfig={
   @ActivationConfigProperty(propertyName="destinationType",
                             propertyValue="javax.jms.Queue"),
   @ActivationConfigProperty(propertyName="destination", 
                             propertyValue="queue/titan-ReservationQueue")})
public class ReservationProcessorBean implements javax.jms.MessageListener 
{
   @PersistenceContext(unitName= "titan")
   private EntityManager em;

   @EJB 
   private ProcessPaymentLocal process;

   @Resource(mappedName="java:/JmsXA")
   private ConnectionFactory connectionFactory;

   public void onMessage(Message message) 
   {
      System.out.println("Received Message");
      try 
      {
         MapMessage reservationMsg = (MapMessage)message;
                
         int customerPk = reservationMsg.getInt("CustomerID");
         int cruisePk = reservationMsg.getInt("CruiseID");
         int cabinPk = reservationMsg.getInt("CabinID");
     
         double price = reservationMsg.getDouble("Price");
     
         // get the credit card
         Date expirationDate = 
            new Date(reservationMsg.getLong("CreditCardExpDate"));
         String cardNumber = reservationMsg.getString("CreditCardNum");
         String cardType = reservationMsg.getString("CreditCardType");
         CreditCardDO card = new CreditCardDO(cardNumber, 
                                              expirationDate, cardType);
            
         Customer customer = em.find(Customer.class, customerPk);
         Cruise cruise = em.find(Cruise.class, cruisePk);
         Cabin cabin = em.find(Cabin.class, cabinPk);
     
         Reservation reservation = new Reservation(customer, cruise, cabin, price, new Date());
         em.persist(reservation);
            
         process.byCredit(customer, card, price);
     
         TicketDO ticket = new TicketDO(customer,cruise,cabin,price);
            
         deliverTicket(reservationMsg, ticket);
      } 
      catch(Exception e) 
      {
         throw new EJBException(e);
      }
   }
    
   public void deliverTicket (MapMessage reservationMsg, TicketDO ticket) throws JMSException, NamingException
   {
      Queue queue = (Queue)reservationMsg.getJMSReplyTo();
      //      Queue queue = (Queue)
      //new InitialContext().lookup ("queue/titan-TicketQueue");
      Connection connect = connectionFactory.createConnection();
      Session session = connect.createSession(true,0);
      MessageProducer sender = session.createProducer(queue);
      ObjectMessage message = session.createObjectMessage();
      message.setObject(ticket);
      sender.send(message);
      connect.close();
   }
}
