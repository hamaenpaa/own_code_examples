/*
 * Created on 7.6.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pagecode;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;

import com.ibm.faces.component.html.HtmlCommandExButton;
import com.ibm.faces.component.html.HtmlScriptCollector;
import com.ibm.websphere.sdo.access.connections.ConnectionManager;
import com.ibm.websphere.sdo.mediator.JDBCMediator;
import com.ibm.websphere.sdo.mediator.exception.MediatorException;
import com.ibm.websphere.sdo.mediator.jdbc.ConnectionWrapper;
import com.ibm.ws.sdo.mediator.jdbc.ConnectionWrapperFactoryImpl;
import com.ibm.ws.sdo.mediator.jdbc.JDBCMediatorFactoryImpl;
import commonj.sdo.DataObject;
import javax.faces.component.html.HtmlOutputFormat;
import javax.faces.component.UIParameter;
/**
 * @author Harri M�enp��
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BankJSFLogin extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector2;
	protected HtmlOutputText text2;
	protected HtmlInputText customer;
	protected HtmlForm form1;
	protected HtmlCommandExButton button1;
	protected DataObject customersParameters;
	protected List customers;
	protected JDBCMediator customersMediator;
	private static final String SDOConnection_name = "BankJSF_Con1";
	private ConnectionWrapper SDOConnectionWrapper;
	private static final String customers_metadataFileName = "/WEB-INF/wdo/customers.xml";
	protected static final String[] customersArgNames = { "sessionScopecustomerSSN" };
	protected static final String[] customersArgValues = { "#{sessionScope.customerSSN}" };
	private static final int customersTargetPageSize = -1;
	protected HtmlScriptCollector getScriptCollector2() {
		if (scriptCollector2 == null) {
			scriptCollector2 = (HtmlScriptCollector) findComponentInRoot("scriptCollector2");
		}
		return scriptCollector2;
	}
	protected HtmlOutputText getText2() {
		if (text2 == null) {
			text2 = (HtmlOutputText) findComponentInRoot("text2");
		}
		return text2;
	}
	protected HtmlInputText getCustomer() {
		if (customer == null) {
			customer = (HtmlInputText) findComponentInRoot("customer");
		}
		return customer;
	}
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}
	protected HtmlCommandExButton getButton1() {
		if (button1 == null) {
			button1 = (HtmlCommandExButton) findComponentInRoot("button1");
		}
		return button1;
	}
	/** 
	 * @paramBean id=customers
	 */
	public DataObject getCustomersParameters() {
		if (customersParameters == null) {
			try {
				customersParameters = getCustomersMediator()
						.getParameterDataObject();
			} catch (MediatorException e) {
				logException(e);
			}
		}
		return customersParameters;
	}
	/** 
	 * @mediatorFactory com.ibm.etools.sdo.rdb.datahandlers.RelationalDataFactory
	 * @mediatorProperties metadataFileName=/WEB-INF/wdo/customers.xml
	 * @methodEntry id=customers/paramBean=customers/action=customers
	 * @action FILL
	 */
	public List getCustomers() {
		if (customers == null) {
			doCustomersFetchAction();
		}
		return customers;
	}
	/** 
	 * @action id=customers
	 */
	public String doCustomersFetchAction() {
		try {
			resolveParams(getCustomersParameters(), customersArgNames,
					customersArgValues, "customers_params_cache");
			DataObject graph = getCustomersMediator().getGraph(
					getCustomersParameters());
			customers = graph.getList(0);
		} catch (Throwable e) {
			logException(e);
		} finally {
			SDOConnectionWrapper = null;
		}
		return "";
	}
	protected ConnectionWrapper getSDOConnectionWrapper() {
		if (SDOConnectionWrapper == null) {
			try {
				Connection con = ConnectionManager
						.createJDBCConnection(SDOConnection_name);
				SDOConnectionWrapper = ConnectionWrapperFactoryImpl.soleInstance
						.createConnectionWrapper(con);
			} catch (Throwable e) {
				logException(e);
			}
		}
		return SDOConnectionWrapper;
	}
	protected JDBCMediator getCustomersMediator() {
		if (customersMediator == null) {
			try {
				customersMediator = JDBCMediatorFactoryImpl.soleInstance
						.createMediator(
								getResourceInputStream(customers_metadataFileName),
								getSDOConnectionWrapper());
				initSchema(getRealPath(customers_metadataFileName),
						customersMediator.getSchema());
			} catch (Throwable e) {
				logException(e);
			}
		}
		return customersMediator;
	}
	
	public static final String OUTCOME_FAILED = "failed";
	public static final String OUTCOME_LOGIN = "login";
	
	public String login()
	{
		String outcome = OUTCOME_FAILED;
		List custs = getCustomers();
//		 A valid customer SSN should only return one record
		if (custs == null || custs.size() < 1) 
		{
			addErrorMessage("Customer Record not found.");
		} 
		else if (custs.size() == 1)
		{
//			 successfully entered a valid Customer SSN
			outcome = OUTCOME_LOGIN;
		} 
		else 
		{
			addErrorMessage("To many customer records found.");
		}
		return outcome;
	}

	protected void addErrorMessage(String error)
	{
		if (errorMessages == null)
		{
			errorMessages = new ArrayList();
		}
		errorMessages.add(error);
	}

	public String getErrorMessages()
	{
		StringBuffer messages = new StringBuffer();
		if (errorMessages != null && errorMessages.size() > 0)
		{
			int size = errorMessages.size();
			for (int i=0;i<size;i++)
			{
				messages.append(errorMessages.get(i));
			}
		}
		return messages.toString();
	}

	private ArrayList errorMessages = null;
	protected HtmlOutputFormat errorMessage;
	protected UIParameter param1;
	protected HtmlOutputFormat getErrorMessage() {
		if (errorMessage == null) {
			errorMessage = (HtmlOutputFormat) findComponentInRoot("errorMessage");
		}
		return errorMessage;
	}
	protected UIParameter getParam1() {
		if (param1 == null) {
			param1 = (UIParameter) findComponentInRoot("param1");
		}
		return param1;
	}
}