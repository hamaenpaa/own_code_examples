package com.titan.access;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface DataAccess
{
   List getCruises();
   List getCabins(int cruiseId);
   void initializeDB();
}
