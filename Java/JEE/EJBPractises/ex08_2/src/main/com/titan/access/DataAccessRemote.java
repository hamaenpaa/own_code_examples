package com.titan.access;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DataAccessRemote
{
   public void initializeDatabase();
   public List findAllPersons();
}
