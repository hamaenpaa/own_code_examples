
package com.soacookbook.ns.credit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soacookbook.ns.credit package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Authorization_QNAME = new QName("http://ns.soacookbook.com/credit", "authorization");
    private final static QName _CreditCard_QNAME = new QName("http://ns.soacookbook.com/credit", "creditCard");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soacookbook.ns.credit
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Authorization }
     * 
     */
    public Authorization createAuthorization() {
        return new Authorization();
    }

    /**
     * Create an instance of {@link CreditCard }
     * 
     */
    public CreditCard createCreditCard() {
        return new CreditCard();
    }

    /**
     * Create an instance of {@link Name }
     * 
     */
    public Name createName() {
        return new Name();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Authorization }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.soacookbook.com/credit", name = "authorization")
    public JAXBElement<Authorization> createAuthorization(Authorization value) {
        return new JAXBElement<Authorization>(_Authorization_QNAME, Authorization.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditCard }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ns.soacookbook.com/credit", name = "creditCard")
    public JAXBElement<CreditCard> createCreditCard(CreditCard value) {
        return new JAXBElement<CreditCard>(_CreditCard_QNAME, CreditCard.class, null, value);
    }

}
