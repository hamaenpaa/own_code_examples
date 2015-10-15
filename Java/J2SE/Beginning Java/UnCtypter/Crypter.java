/*
 * Yomi Solutions Oy, Kalle Väyrynen
 * Date: 23.10.2002
 * Time: 13:55:02
 */
// package com.yomi.elisacti;

import java.math.BigInteger;
import java.io.*;

/**
 * Crypts and decrypts userid and password
 */

public class Crypter
{
    /** cryptKey used for crypting */
    private static final String cryptKey = "161092";

    /**
     * Crypts given string
     * @throws IllegalArgumentException if string is not numerical
     * @param uncryptedString string to be crypted
     * @return crypted String
     */

    public static String crypt(String uncryptedString) throws IllegalArgumentException
    {
        // check non alphanumeric characters
        for (int i = 0; i < uncryptedString.length(); i++)
        {
            if (!Character.isDigit((uncryptedString.charAt(i))))
            {
                throw new IllegalArgumentException("Illegal characters in string, '" + uncryptedString.charAt(i) + "' is not numeric character.");
            }
        }

        StringBuffer sbString = new StringBuffer();
        if (uncryptedString.length() == 0)
        {
            sbString.append((int) (Math.random() * 9) + 1);
        }
        for (int i = 0; i < uncryptedString.length(); i++)
        {
            sbString.append((int) (Math.random() * 9) + 1);
            sbString.append(uncryptedString.substring(i, i + 1));
        }
        sbString.append((int) (Math.random() * 9) + 1);

	String sMultiply = "5152336425368748994041423364353617181";
	BigInteger multiplyInt = new BigInteger(sMultiply); 
	BigInteger multipliedInt = multiplyInt.multiply(new BigInteger(cryptKey));
	System.out.println(sMultiply + " is multiplied to: " + multipliedInt.toString());
        BigInteger cryptedInt = new BigInteger(sbString.toString());
        
        BigInteger calculatedInt = cryptedInt.multiply(new BigInteger(cryptKey));
        return calculatedInt.toString();
    }

    /**
     * Decrypts given string
     * @param cryptedstring string that is to be decrypted
     * @return decrypted string
     */
    public static String decrypt(String cryptedstring)
    {
        BigInteger calculatedInt = new BigInteger(cryptedstring);
        BigInteger cryptedInt = calculatedInt.divide(new BigInteger(cryptKey));

        String cryptedString = cryptedInt.toString();
        StringBuffer sbString = new StringBuffer();
        cryptedString = cryptedString.substring(0, cryptedString.length() - 1);
        for (int i = 1; i < cryptedString.length();)
        {
            sbString.append(cryptedString.charAt(i));
            i += 2;
        }
        return sbString.toString();
    }
}