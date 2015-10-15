/*
 *
 * Copyright 2000 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface Converter extends EJBObject {
 
   public double dollarToYen(double dollars) throws RemoteException;
   public double yenToEuro(double yen) throws RemoteException;
}
