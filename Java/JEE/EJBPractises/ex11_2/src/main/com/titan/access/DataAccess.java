package com.titan.access;

import javax.ejb.Remote;

import com.titan.domain.Customer;

@Remote
public interface DataAccess
{
   public int createCustomer(Customer cust);
   public Customer findCustomer(int pKey);

   public void makePaymentDbTable();
   public void dropPaymentDbTable();
}
