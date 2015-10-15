package com.titan.travelagent;

import com.titan.processpayment.*;
import com.titan.domain.*;
import javax.ejb.*;
import javax.persistence.*;
import java.util.Date;
import static javax.persistence.PersistenceContextType.*;
import static javax.ejb.TransactionAttributeType.*;

@Stateful
@TransactionAttribute(NOT_SUPPORTED)
public class TravelAgentBean implements TravelAgentRemote 
{
   @PersistenceContext(unitName="titan", type=EXTENDED)
   private EntityManager entityManager;

   @EJB private ProcessPaymentLocal processPayment;

   private Customer customer;
   private Cruise cruise;
   private Cabin cabin;
     
   public Customer findOrCreateCustomer(String first, String last) {
      try {
         Query q = entityManager.createQuery("from Customer c where c.firstName = :first and c.lastName = :last");
         q.setParameter("first", first);
         q.setParameter("last", last);
         this.customer = (Customer)q.getSingleResult();
      } catch (NoResultException notFound) {
         this.customer = new Customer();
         this.customer.setFirstName(first);
         this.customer.setLastName(last);
         entityManager.persist(this.customer);
      }
      return this.customer;
   }

   public void updateAddress(Address addr) {
      this.customer.setAddress(addr);
      this.customer = entityManager.merge(customer);
   }

   public void setCabinID(int cabinID) 
   {
      this.cabin = entityManager.find(Cabin.class, cabinID);
      if (cabin == null) throw new NoResultException("Cabin not found");
   }

   public void setCruiseID(int cruiseID) 
   {
      this.cruise = entityManager.find(Cruise.class, cruiseID);
      if (cruise == null) throw new NoResultException("Cruise not found");
   } 

   public TicketDO bookPassage(CreditCardDO card, double price)
      throws IncompleteConversationalState 
   {
                   
      if (customer == null || cruise == null || cabin == null) 
      {
         throw new IncompleteConversationalState( );
      }

      Reservation reservation = new Reservation(customer, cruise, cabin, price, new Date( ));
      entityManager.persist(reservation);
                
      Query getCruiseCabin = entityManager.createQuery("SELECT cc FROM CruiseCabin cc WHERE " +
                                                       "cc.cabin = :cabin AND cc.cruise = :cruise");
      getCruiseCabin.setParameter("cabin", cabin);
      getCruiseCabin.setParameter("cruise", cruise);
      CruiseCabin cc = (CruiseCabin)getCruiseCabin.getSingleResult();
        
      if (cc.getIsReserved())
         throw new EJBException ("Cabin is already reserved");
      cc.setIsReserved(true);

      try 
      {
         processPayment.byCredit(customer, card, price);
     
         TicketDO ticket = new TicketDO(customer, cruise, cabin, price);
         return ticket;
      } 
      catch(Exception e) 
      {
         throw new EJBException(e);
      }
   }

   @Remove
   @TransactionAttribute(REQUIRED)
   public void checkout()
   {
      // this really isn't necessary as the entityManager would
      // be enlisted with the transaction anyways.
      entityManager.flush();
   }

}
