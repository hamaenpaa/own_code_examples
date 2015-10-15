package com.titan.travelagent;

import javax.ejb.Remote;

import com.titan.domain.Customer;

@Remote
public interface TravelAgentRemote
{
   public long createCustomer(Customer cust);
   public Customer findCustomer(long pk);
}
