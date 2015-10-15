/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionb;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless(name = "CreditCheck")
@WebService(serviceName = "CreditService", targetNamespace = "http://oma/ejb/credit")
public class CreditCheck {
    public CreditCheck() {
    }

    @WebMethod(operationName = "CreditCheck")
    public boolean validateCC(String cc) {
        return true;
    }
}
