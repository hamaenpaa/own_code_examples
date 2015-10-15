package com.titan.clients;

/**
 * JAX-RPC Wrapper Object for Document/Literal Wrapped
 */
public class CreateCabin 
{
   private Cabin cabin;
    
   public com.titan.clients.Cabin getCabin() 
   {
      return cabin;
   }
    
   public void setCabin(Cabin cabin) {
      this.cabin = cabin;
   }
}
