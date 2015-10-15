import java.io.*;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.ejb.*;
import javax.naming.*;

import javax.naming.Context;
import javax.rmi.PortableRemoteObject;

public class ConverterClient
{
    public static void main (String[] arguments)
    {
		try
		{
//		  Hashtable env = new Hashtable();
//		  env.put( Context.PROVIDER_URL, "http://CRANBERRY:14000" );
//		  System.out.println("hashtable created");
          Context context = new InitialContext();
          System.out.println("initialcontext got");
          Object Obj = context.lookup( "MyConverter" );
          System.out.println("lookup");
          ConverterHome serviceHome = (ConverterHome) PortableRemoteObject.narrow( Obj, ConverterHome.class );
          System.out.println("home got");
          Converter service = serviceHome.create();
          System.out.println("remote got");
		  double yen = service.dollarToYen(100);
		  System.out.println("100 dollars is " + new Double(yen) + " yen" );
		  double euro = service.yenToEuro(100);
		  System.out.println("100 yen is " + new Double(euro) + " euro" );
	    }
	    catch (Exception e)
	    {
		    System.out.println("Exception, e: "+ e.toString() );
	    }
    }

}