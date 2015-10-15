package com.titan.simple;

import javax.ejb.Remote;

@Remote
public interface SimpleRemote
{
   public void echo(String echo) throws Exception;
}
