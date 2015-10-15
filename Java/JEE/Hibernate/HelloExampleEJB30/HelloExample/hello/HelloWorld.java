package hello;

import org.jboss.ejb3.embedded.EJB3StandaloneBootstrap;
import javax.naming.InitialContext;

import java.util.*;
import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

public class HelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// Boot the JBoss Microcontainer with EJB3 settings, automatically
		// loads ejb3-interceptors-aop.xml and embedded-jboss-beans.xml
		EJB3StandaloneBootstrap.boot(null);

		// Deploy custom stateless beans (datasource, mostly)
		EJB3StandaloneBootstrap.deployXmlResource("META-INF/helloworld-beans.xml");
		
		// Deploy all EJBs found on classpath (slow, scans all)
		// EJB3StandaloneBootstrap.scanClasspath();
		// Deploy all EJBs found on classpath (fast, scans build directory)
		// This is a relative location, matching the substring end of one
		// of java.class.path locations. Print out the value of
		// System.getProperty("java.class.path") to see all paths.
		EJB3StandaloneBootstrap.scanClasspath("helloworld-ejb3/bin");

		// Create InitialContext from jndi.properties
		
		// Start EntityManagerFactory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");

		InitialContext initialContext = new InitialContext();
		
		// Look up the stateless MessageHandler EJB
		MessageHandler msgHandler = (MessageHandler) initialContext.lookup("MessageHandlerBean/local");
		
		// Call the stateless EJB
		msgHandler.saveMessages();
		msgHandler.showMessages();

		// Shut down EJB container
		EJB3StandaloneBootstrap.shutdown();	}
}
