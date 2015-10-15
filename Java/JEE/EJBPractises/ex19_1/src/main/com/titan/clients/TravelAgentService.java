package com.titan.clients;

import javax.xml.rpc.*;

/**
 * JAX-RPC Service Interface
 */
public interface TravelAgentService extends javax.xml.rpc.Service 
{
    public TravelAgent getTravelAgentPort() throws ServiceException;
}
