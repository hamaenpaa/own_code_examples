package com.titan.processpayment;

import java.util.Date;

public class CreditCardDO implements java.io.Serializable
{
   final static public String MASTER_CARD = "MASTER_CARD";
   final static public String VISA = "VISA";
   final static public String AMERICAN_EXPRESS = "AMERICAN_EXPRESS";
   final static public String DISCOVER = "DISCOVER";
   final static public String DINERS_CARD = "DINERS_CARD";

   public String number;
   public Date expiration;
   public String type;

   public CreditCardDO(String number, Date expiration, String type)
   {
      this.number = number;
      this.expiration = expiration;
      this.type = type;
   }
}
