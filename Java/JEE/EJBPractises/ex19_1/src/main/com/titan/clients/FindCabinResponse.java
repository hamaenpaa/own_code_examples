package com.titan.clients;

/**
 * JAX-RPC Wrapper Object for Document/Literal Wrapped
 */
public class FindCabinResponse {
   private Cabin cabin;
    
   public Cabin getCabin() 
   {
      return cabin;
   }
    
   public void setCabin(Cabin cabin)
   {
      this.cabin = cabin;
   }
}
