/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicecomplexschemaclient;

import com.soacookbook.ns.credit.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author hamaenpaa
 */
public class WebServiceComplexSchemaClient {

    public static XMLGregorianCalendar dateToXml(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        try {
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(strDate);
            return xmlDate;
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MONTH, 15);
        System.out.println(cal.getTime());
        CreditService service = new CreditService();
        CreditAuthorizer authorizer = service.getCreditAuthorizerPort();
        CreditCard card = new CreditCard();
        card.setCardNumber("47477788933");
        Name name = new Name();
        name.setFirstName("Kalle");
        name.setMiddleInitial("Ville");
        name.setLastName("Muittari");
        card.setName(name);
        XMLGregorianCalendar expirationDate = dateToXml(cal.getTime());
        card.setExpirationDate(expirationDate);
        Authorization auth = authorizer.authorize(card);
        System.out.println(auth.getAmount());
        
    }
    
}
