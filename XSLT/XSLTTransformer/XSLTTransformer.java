/*
 * Created on 31.1.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

/**
 * @author Harri M‰enp‰‰
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class XSLTTransformer {
	public static void main(String[] args)
	{
		if (args.length == 3)
		{
			doTransform(args[0], args[1], args[2]);
		}
		else
		{
			System.out.println("Illegal number of arguments");
		}
	}

	private static void doTransform
	(String xmlSourcePath, String htmlTargetPath, String xsltFilePath)
	{
		System.out.println("SourcePath:");
		System.out.println(xmlSourcePath);
		System.out.println("TargetPath:");
		System.out.println(htmlTargetPath);
		System.out.println("XSLTPath:");
		System.out.println(xsltFilePath);
		
		DocumentBuilderFactory bdf = DocumentBuilderFactory.newInstance();
		
		try
		{
			DocumentBuilder db = bdf.newDocumentBuilder();
			
			TransformerFactory tff = TransformerFactory.newInstance();
			
			Transformer tf = tff.newTransformer(new StreamSource(new File(xsltFilePath)));
			
			StreamSource source = new StreamSource(new File(xmlSourcePath));
			StreamResult result = new StreamResult(new File(htmlTargetPath));
			
			tf.transform(source, result);
		
		}
		catch (ParserConfigurationException pce)
		{
			System.out.println("ParserConfigurationException");
			pce.printStackTrace(System.out);
		}
		catch (TransformerConfigurationException tce)
		{
			System.out.println("TransformerConfigurationException");
			tce.printStackTrace(System.out);
		}
		catch (TransformerException te)
		{
			System.out.println("TransformerException");
			te.printStackTrace(System.out);
		}
	}
}
