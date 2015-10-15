package com.titan.travelagent;

import javax.ejb.Remote;

import com.titan.domain.Customer;
import com.titan.domain.Address;

@Remote
public interface TravelAgentRemote
{
   public long createCustomer(Customer cust);
   public Address findAddress(long custPk);
}
