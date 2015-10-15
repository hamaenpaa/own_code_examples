/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soacookbook.ch03.validate;

import com.soacookbook.ns.credit.*;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *
 * @author hamaenpaa
 */

/**
 * Demonstrates a service that uses JAXB-generated types as 
 * parameters for a start-from-schema-and-java method.
 * Uses Credit.wsdl and Credit.xsd.
 */
@WebService(
  name="CreditAuthorizer",
  serviceName="CreditService",
  targetNamespace="http://ns.soacookbook.com/credit", 
  wsdlLocation="WEB-INF/wsdl/ch03/Credit.wsdl")
public class CreditService {

         
    /** Creates an instance of CreditService.
     */
    public CreditService() {
        
    }
    
    //business method
    @WebMethod(operationName="authorize")
    @SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
     use=SOAPBinding.Use.LITERAL,
     parameterStyle=SOAPBinding.ParameterStyle.BARE)
    public @WebResult(name="authorization",
            targetNamespace="http://ns.soacookbook.com/credit")
            Authorization
            
            authorize(
            
            @WebParam(name="creditCard", 
            mode=WebParam.Mode.IN,
            targetNamespace="http://ns.soacookbook.com/credit")
            CreditCard creditCard)  { 
        
        System.out.println("Authorizing.");
        
        System.out.println("Card Number: " + creditCard.getCardNumber());
        
        //get data from compound type
        String cardNumber = creditCard.getCardNumber();
        
        Name name = creditCard.getName();
        System.out.println("First name " + name.getFirstName());
        System.out.println("Middle name " + name.getMiddleInitial());
        System.out.println("Last name " + name.getLastName());
        
        XMLGregorianCalendar expDate = creditCard.getExpirationDate();
        System.out.println(expDate.toString());
        
        //create custom type for return
        Authorization auth = new Authorization();
        //business logic here
        if (cardNumber.startsWith("4")) {
            auth.setAmount(2500.0);
        } else {
            auth.setAmount(0.0);
        }
        
        System.out.println("Returning auth for amt: " + auth.getAmount());
        
        return auth;
    }
}

