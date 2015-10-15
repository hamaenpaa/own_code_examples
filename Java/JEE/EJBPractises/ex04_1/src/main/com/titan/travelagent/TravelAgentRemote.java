package com.titan.travelagent;

import javax.ejb.Remote;

import com.titan.domain.Cabin;

@Remote
public interface TravelAgentRemote
{
    public void createCabin(Cabin cabin);
    public Cabin findCabin(int pKey);
}
