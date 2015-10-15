package com.titan.travelagent;
     
import com.titan.processpayment.CreditCardDO;
import javax.ejb.Remote;
import com.titan.domain.Customer;
import com.titan.domain.Address;
 
@Remote    
public interface TravelAgentRemote {
    
    public Customer findOrCreateCustomer(String first, String last);

    public void updateAddress(Address addr);
    
    public void setCruiseID(int cruise); 
     
    public void setCabinID(int cabin); 
     
    public TicketDO bookPassage(CreditCardDO card, double price)
        throws IncompleteConversationalState;   
}
