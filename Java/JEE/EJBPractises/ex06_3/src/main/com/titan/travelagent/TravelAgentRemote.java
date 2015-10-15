package com.titan.travelagent;

import javax.ejb.Remote;

import com.titan.domain.Customer;

@Remote
public interface TravelAgentRemote
{
   public void createCustomer(Customer cust);
   public Customer findCustomer(String lastName, long ssn);
}
