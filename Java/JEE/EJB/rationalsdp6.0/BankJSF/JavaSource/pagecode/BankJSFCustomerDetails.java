/*
 * Created on 29.5.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pagecode;

import com.ibm.websphere.sdo.access.connections.ConnectionManager;
import com.ibm.ws.sdo.mediator.jdbc.ConnectionWrapperFactoryImpl;
import com.ibm.websphere.sdo.mediator.jdbc.ConnectionWrapper;
import com.ibm.websphere.sdo.mediator.JDBCMediator;
import com.ibm.websphere.sdo.mediator.exception.MediatorException;
import com.ibm.ws.sdo.mediator.jdbc.JDBCMediatorFactoryImpl;
import commonj.sdo.DataObject;
import java.sql.Connection;
import com.ibm.faces.component.html.HtmlScriptCollector;
import javax.faces.component.html.HtmlForm;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlMessages;
import com.ibm.faces.component.html.HtmlCommandExButton;
import java.util.List;
import javax.faces.component.UIColumn;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlDataTable;
import com.ibm.faces.component.html.HtmlCommandExRowAction;
import com.ibm.bankjsf.actions.LogoutAction;
import java.lang.String;
/**
 * @author Harri M‰enp‰‰
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BankJSFCustomerDetails extends PageCodeBase {

	protected DataObject customerParameters;
	protected DataObject customer;
	protected JDBCMediator customerMediator;
	private static final String SDOConnection_name = "BankJSF_Con1";
	private ConnectionWrapper SDOConnectionWrapper;
	private static final String customer_metadataFileName = "/WEB-INF/wdo/customer.xml";
	protected static final String[] customerArgNames = { "sessionScopecustomerSSN" };
	protected static final String[] customerArgValues = { "#{sessionScope.customerSSN}" };
	protected HtmlScriptCollector scriptCollector2;
	protected HtmlForm form1;
	protected HtmlInputText text2;
	protected HtmlInputText text3;
	protected HtmlInputText text4;
	protected HtmlMessages messages1;
	protected HtmlCommandExButton button1;
	protected DataObject accountsParameters;
	protected List accounts;
	protected JDBCMediator accountsMediator;
	private static final String accounts_metadataFileName = "/WEB-INF/wdo/accounts.xml";
	protected static final String[] accountsArgNames = { "sessionScopecustomerSSN" };
	protected static final String[] accountsArgValues = { "#{sessionScope.customerSSN}" };
	private static final int accountsTargetPageSize = -1;
	protected UIColumn column1;
	protected HtmlOutputText text5;
	protected HtmlOutputText text7;
	protected HtmlDataTable table1;
	protected HtmlOutputText text6;
	protected UIColumn column2;
	protected HtmlOutputText text8;
	protected HtmlCommandExRowAction rowAction1;
	protected UIColumn column3;
	protected LogoutAction Logout;
	protected String logoutLogoutResultBean;
	protected HtmlCommandExButton button2;
	/** 
	 * @action id=customer
	 */
	public String doCustomerUpdateAction() {
		try {
			getCustomerMediator().applyChanges(
					getCustomer().getDataGraph().getRootObject());
		} catch (Throwable e) {
			logException(e);
		} finally {
			SDOConnectionWrapper = null;
		}
		return "";
	}
	/** 
	 * @action id=customer
	 */
	public String doCustomerDeleteAction() {
		try {
			DataObject root = getCustomer().getDataGraph().getRootObject();
			getCustomer().delete();
			getCustomerMediator().applyChanges(root);
		} catch (Throwable e) {
			logException(e);
		} finally {
			SDOConnectionWrapper = null;
		}
		return "";
	}
	/** 
	 * @paramBean id=customer
	 */
	public DataObject getCustomerParameters() {
		if (customerParameters == null) {
			try {
				customerParameters = getCustomerMediator()
						.getParameterDataObject();
			} catch (MediatorException e) {
				logException(e);
			}
		}
		return customerParameters;
	}
	/** 
	 * @mediatorFactory com.ibm.etools.sdo.rdb.datahandlers.RelationalDataFactory
	 * @mediatorProperties metadataFileName=/WEB-INF/wdo/customer.xml
	 * @methodEntry id=customer/paramBean=customer/action=customer
	 * @action FILL
	 */
	public DataObject getCustomer() {
		if (customer == null) {
			doCustomerFetchAction();
		}
		return customer;
	}
	/** 
	 * This method was created in order to retrieve existing data.  To create new data:
	 *   DataObject graph = getCustomerMediator().getEmptyGraph();
	 *   customer = graph.createDataObject(0);  
	 *
	 * @action id=customer
	 */
	public String doCustomerFetchAction() {
		try {
			resolveParams(getCustomerParameters(), customerArgNames,
					customerArgValues, "customer_params_cache");
			DataObject graph = getCustomerMediator().getGraph(
					getCustomerParameters());
			customer = (DataObject) graph.getList(0).get(0);
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
	protected JDBCMediator getCustomerMediator() {
		if (customerMediator == null) {
			try {
				customerMediator = JDBCMediatorFactoryImpl.soleInstance
						.createMediator(
								getResourceInputStream(customer_metadataFileName),
								getSDOConnectionWrapper());
				initSchema(getRealPath(customer_metadataFileName),
						customerMediator.getSchema());
			} catch (Throwable e) {
				logException(e);
			}
		}
		return customerMediator;
	}
	protected HtmlScriptCollector getScriptCollector2() {
		if (scriptCollector2 == null) {
			scriptCollector2 = (HtmlScriptCollector) findComponentInRoot("scriptCollector2");
		}
		return scriptCollector2;
	}
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}
	protected HtmlInputText getText2() {
		if (text2 == null) {
			text2 = (HtmlInputText) findComponentInRoot("text2");
		}
		return text2;
	}
	protected HtmlInputText getText3() {
		if (text3 == null) {
			text3 = (HtmlInputText) findComponentInRoot("text3");
		}
		return text3;
	}
	protected HtmlInputText getText4() {
		if (text4 == null) {
			text4 = (HtmlInputText) findComponentInRoot("text4");
		}
		return text4;
	}
	protected HtmlMessages getMessages1() {
		if (messages1 == null) {
			messages1 = (HtmlMessages) findComponentInRoot("messages1");
		}
		return messages1;
	}
	protected HtmlCommandExButton getButton1() {
		if (button1 == null) {
			button1 = (HtmlCommandExButton) findComponentInRoot("button1");
		}
		return button1;
	}
	/** 
	 * @paramBean id=accounts
	 */
	public DataObject getAccountsParameters() {
		if (accountsParameters == null) {
			try {
				accountsParameters = getAccountsMediator()
						.getParameterDataObject();
			} catch (MediatorException e) {
				logException(e);
			}
		}
		return accountsParameters;
	}
	/** 
	 * @mediatorFactory com.ibm.etools.sdo.rdb.datahandlers.RelationalDataFactory
	 * @mediatorProperties metadataFileName=/WEB-INF/wdo/accounts.xml
	 * @methodEntry id=accounts/paramBean=accounts/action=accounts
	 * @action FILL
	 */
	public List getAccounts() {
		if (accounts == null) {
			doAccountsFetchAction();
		}
		return accounts;
	}
	/** 
	 * @action id=accounts
	 */
	public String doAccountsFetchAction() {
		try {
			resolveParams(getAccountsParameters(), accountsArgNames,
					accountsArgValues, "accounts_params_cache");
			DataObject graph = getAccountsMediator().getGraph(
					getAccountsParameters());
			accounts = graph.getList(0);
		} catch (Throwable e) {
			logException(e);
		} finally {
			SDOConnectionWrapper = null;
		}
		return "";
	}
	protected JDBCMediator getAccountsMediator() {
		if (accountsMediator == null) {
			try {
				accountsMediator = JDBCMediatorFactoryImpl.soleInstance
						.createMediator(
								getResourceInputStream(accounts_metadataFileName),
								getSDOConnectionWrapper());
				initSchema(getRealPath(accounts_metadataFileName),
						accountsMediator.getSchema());
			} catch (Throwable e) {
				logException(e);
			}
		}
		return accountsMediator;
	}
	protected UIColumn getColumn1() {
		if (column1 == null) {
			column1 = (UIColumn) findComponentInRoot("column1");
		}
		return column1;
	}
	protected HtmlOutputText getText5() {
		if (text5 == null) {
			text5 = (HtmlOutputText) findComponentInRoot("text5");
		}
		return text5;
	}
	protected HtmlOutputText getText7() {
		if (text7 == null) {
			text7 = (HtmlOutputText) findComponentInRoot("text7");
		}
		return text7;
	}
	protected HtmlDataTable getTable1() {
		if (table1 == null) {
			table1 = (HtmlDataTable) findComponentInRoot("table1");
		}
		return table1;
	}
	protected HtmlOutputText getText6() {
		if (text6 == null) {
			text6 = (HtmlOutputText) findComponentInRoot("text6");
		}
		return text6;
	}
	protected UIColumn getColumn2() {
		if (column2 == null) {
			column2 = (UIColumn) findComponentInRoot("column2");
		}
		return column2;
	}
	protected HtmlOutputText getText8() {
		if (text8 == null) {
			text8 = (HtmlOutputText) findComponentInRoot("text8");
		}
		return text8;
	}
	protected HtmlCommandExRowAction getRowAction1() {
		if (rowAction1 == null) {
			rowAction1 = (HtmlCommandExRowAction) findComponentInRoot("rowAction1");
		}
		return rowAction1;
	}
	protected UIColumn getColumn3() {
		if (column3 == null) {
			column3 = (UIColumn) findComponentInRoot("column3");
		}
		return column3;
	}
	public String doRowAction1Action() {
try 
{
	int row = getRowAction1().getRowIndex();
	Object keyvalue =
		((DataObject)getAccounts().get(row)).get("ACCOUNTS_ID");
		getSessionScope().put("accountId", keyvalue);
} 
catch(Exception e)
{
	e.printStackTrace();
}
return "accountDetails";

	}
	/** 
	 * @managed-bean true
	 */
	public void setLogout(LogoutAction Logout) {
		this.Logout = Logout;
	}
	/** 
	 * @resultBean id=1
	 */
	public String getLogoutLogoutResultBean() {
		return logoutLogoutResultBean;
	}
	/** 
	 * @action id=1
	 */
	public String doLogoutLogoutAction() {
		try {
			logoutLogoutResultBean = getLogout().logout();
		} catch (Exception e) {
			logException(e);
		}
		return "logoutLogoutResultBean";
	}
	/** 
	 * @managed-bean true
	 * @methodEntry id=logout()/resultBean=1/action=1
	 */
	public LogoutAction getLogout() {
		if (Logout == null) {
			Logout = (LogoutAction) getFacesContext().getApplication()
					.createValueBinding("#{Logout}")
					.getValue(getFacesContext());
		}
		return Logout;
	}
	protected HtmlCommandExButton getButton2() {
		if (button2 == null) {
			button2 = (HtmlCommandExButton) findComponentInRoot("button2");
		}
		return button2;
	}
}