package com.titan.travelagent;
     
import com.titan.domain.Cruise;
import com.titan.domain.Cabin;
import com.titan.domain.Customer;
     
public class TicketDO implements java.io.Serializable {
    public int customerID;
    public int cruiseID;
    public int cabinID;
    public double price;
    public String description;
    
    public TicketDO(Customer customer, Cruise cruise, 
        Cabin cabin, double price) {        
            description = customer.getFirstName( )+
                " " + customer.getLastName( ) + 
                " has been booked for the "
                + cruise.getName( ) + 
                " cruise on ship " + 
                  cruise.getShip( ).getName( ) + ".\n" +  
                " Your accommodations include " + 
                  cabin.getName( ) + 
                " a " + cabin.getBedCount( ) + 
                " bed cabin on deck level " + cabin.getDeckLevel( ) + 
                ".\n Total charge = " + price;
            customerID = customer.getId();
            cruiseID = cruise.getId();
            cabinID = cabin.getId();
            this.price = price;
        }
        
    public String toString( ) {
        return description;
    }
}
