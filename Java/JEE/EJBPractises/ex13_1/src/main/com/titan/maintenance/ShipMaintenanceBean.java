package com.titan.maintenance;

import javax.ejb.*;
import java.util.Date;
import javax.annotation.Resource;

@Stateless
public class ShipMaintenanceBean implements ShipMaintenanceRemote {

    @Resource javax.ejb.TimerService timerService;

    public void scheduleMaintenance(String ship, String description, 
                                    Date dateOf) {
        String item = ship + " is scheduling maintenance of " + description;

        for (Object obj : timerService.getTimers()) {
            javax.ejb.Timer timer = (javax.ejb.Timer)obj;
            String scheduled = (String)timer.getInfo();
            if (scheduled.equals(item)) {
                timer.cancel();
            }
        }

        timerService.createTimer(dateOf, item);
    }

    @Timeout
    public void maintenance(javax.ejb.Timer timer) {
       System.out.println("TIMEOUT METHOD CALLED");
       String scheduled = (String)timer.getInfo();
       System.out.println(scheduled);
    }
}
