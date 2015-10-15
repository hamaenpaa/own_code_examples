package com.titan.travelagent;

import com.titan.processpayment.*;
import com.titan.domain.*;
import javax.ejb.*;
import javax.persistence.*;
import java.util.Date;

public class TravelAgentBean implements TravelAgentRemote {
     
    private EntityManager entityManager;

    private ProcessPaymentLocal processPayment;

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

    public void setCabinID(int cabinID) {
        this.cabin = entityManager.find(Cabin.class, cabinID);
        if (cabin == null) throw new NoResultException("Cabin not found");
    }

    public void setCruiseID(int cruiseID) {
        this.cruise = entityManager.find(Cruise.class, cruiseID);
        if (cruise == null) throw new NoResultException("Cruise not found");
    } 

    public TicketDO bookPassage(CreditCardDO card, double price)
        throws IncompleteConversationalState {
                   
        if (customer == null || cruise == null || cabin == null) 
        {
            throw new IncompleteConversationalState( );
        }
        try {
            Reservation reservation = new Reservation(
                                  customer, cruise, cabin, price, new Date( ));
            entityManager.persist(reservation);
                
            processPayment.byCredit(customer, card, price);
     
            TicketDO ticket = new TicketDO(customer, cruise, cabin, price);
            return ticket;
        } catch(Exception e) {
            throw new EJBException(e);
        }
    }
}
