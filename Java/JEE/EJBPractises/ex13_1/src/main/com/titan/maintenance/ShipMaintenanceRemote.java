package com.titan.maintenance;

import javax.ejb.Remote;
import java.util.Date;

@Remote
public interface ShipMaintenanceRemote
{
   public void scheduleMaintenance(String ship, String description, 
                                   Date dateOfTest);
}
