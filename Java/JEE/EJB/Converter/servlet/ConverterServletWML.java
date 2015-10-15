/*
 *
 * Copyright 2000 Sun Microsystems, Inc. All Rights Reserved.
 *
 * This software is the proprietary information of Sun Microsystems, Inc.
 * Use is subject to license terms.
 *
 */

import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.rmi.PortableRemoteObject;
import javax.naming.Context;
import javax.naming.InitialContext;

import Converter;
import ConverterHome;

public class ConverterServletWML extends HttpServlet
{

   // Converter currencyConverter;
   String m_text;

   public void init(ServletConfig config) throws ServletException
   {

       super.init(config);
       m_text = config.getInitParameter("text");
       if (m_text == null)
       {
           m_text = "This is a simple test servlet.";
       }
       // System.out.println("in init of AdderServlet");
/*       try
       {
           InitialContext ic = new InitialContext();
           Object objref = ic.lookup("MyConverter");
           // System.out.println("lookup ok");
           ConverterHome home =
              (ConverterHome)PortableRemoteObject.narrow(objref,
                                           ConverterHome.class);
           currencyConverter = home.create();
           // System.out.println("narrow ok");
           // adder = home.create(0);
           // System.out.println("create ok");
       }
       catch(Exception e)
       {
            e.printStackTrace();
       }
*/
   }

   	public void doGet (HttpServletRequest req, HttpServletResponse res)
                      throws ServletException, IOException
   	{
      	String inputString = req.getParameter("toiminta");
      	// adder.add(inputNumber.intValue());
      	// int total = adder.getTotal();
      	res.setContentType("text/vnd.wap.wml");
      	PrintWriter out = res.getWriter();
      	generatePage(out,inputString);
	}

   	private void generatePage(PrintWriter out, String inputString)
   	{
		out.println("<?xml version=\"1.0\"?>");
		out.println("<!DOCTYPE wml PUBLIC \"-//WAPFORUM//DTD WML 1.1//EN\" \"http://www.wapforum.org/DTD/wml_1.1.xml\">");
		out.println("<wml>");
		out.println("<card id=\"card1\" title=\"Hello World\">");
		out.println("<p>");
		// out.println("No EJB was chosen to be used");
		out.println("InputString: [" + inputString + "] <br/>" );
		generateEJBLines(out,inputString);
		out.println("</p>");
		out.println("</card>");
		out.println("</wml>");
		out.close();
   	}

	private void generateEJBLines(PrintWriter out, String inputString)
	{
		if (inputString.equals("EJB/"))
		{
			out.println("EJB was chosen <br/>" );

			out.println("Here you are ..... <br/>" );

       		try
       		{
				Hashtable env = new Hashtable();

				out.println("Hashtable created <br/>" );
	            // This is only needed when accessing the bean remotely
	            env.put( Context.PROVIDER_URL, "t3://SHALLOT:7001" );

				out.println("Shallot context <br/>" );
	            env.put( Context.INITIAL_CONTEXT_FACTORY,
                 "weblogic.jndi.WLInitialContextFactory" );

				out.println("Initial context factory <br/>" );
	            // Here we could authenticate ourselves...
	            env.put( Context.SECURITY_AUTHENTICATION, "none" );

	            Context initial = new InitialContext( env );

				out.println("New initial context <br/>" );
        	    Object objref = initial.lookup("MyConverter");

				out.println("MyConverter lookup <br/>" );
         	    ConverterHome home =
        	       (ConverterHome)PortableRemoteObject.narrow(objref,
                                            ConverterHome.class);

				out.println("Home interface got <br/>" );
         	    Converter currencyConverter = home.create();
        	   	out.println("Home create <br/>" );
        	   	double amount;
        	   	amount=100.00;
        	    amount = currencyConverter.dollarToYen(100.00);
        	    out.println("EJB method dollarToYen  <br/>" );
        	   out.println(String.valueOf(amount));
        	   amount = currencyConverter.yenToEuro(200.00);
        	   out.println("EJB method YenTodollar <br/>" );
        	   out.println(String.valueOf(amount));
        	   out.println(String.valueOf(1000));
			}
       		catch (Exception ex)
       		{
        	   out.println("Caught an unexpected exception <br/>" );
        	   out.println("Exception text: <br/>" );
        	   out.println(ex.toString() + "<br/>" );
       		}
		}
		else
		{
			   out.println("No EJB was chosen to be used");
		}
   }

   public String getServletInfo()
   {
   	   return "This servlet accesses an enterprise bean.";
   }
}
