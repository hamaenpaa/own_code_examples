package com.titan.clients;

/**
 * JAX-RPC Service Endpoint Interface
 */
public interface TravelAgent extends java.rmi.Remote 
{
    public CreateCabinResponse createCabin(Cabin cabin) throws java.rmi.RemoteException;
    public Cabin findCabin(int ID) throws java.rmi.RemoteException;
}
