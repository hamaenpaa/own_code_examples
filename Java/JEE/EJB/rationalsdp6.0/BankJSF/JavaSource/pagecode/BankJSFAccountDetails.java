/*
 * Created on 29.5.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package pagecode;

import com.ibm.faces.component.html.HtmlScriptCollector;
import com.ibm.faces.component.html.HtmlPanelBox;
import com.ibm.faces.component.html.HtmlGraphicImageEx;
import javax.faces.component.html.HtmlOutputText;
import com.ibm.websphere.sdo.access.connections.ConnectionManager;
import com.ibm.ws.sdo.mediator.jdbc.ConnectionWrapperFactoryImpl;
import com.ibm.websphere.sdo.mediator.jdbc.ConnectionWrapper;
import com.ibm.websphere.sdo.mediator.JDBCMediator;
import com.ibm.websphere.sdo.mediator.exception.MediatorException;
import com.ibm.ws.sdo.mediator.jdbc.JDBCMediatorFactoryImpl;
import commonj.sdo.DataObject;
import java.sql.Connection;
import javax.faces.component.html.HtmlMessages;
import com.ibm.faces.component.html.HtmlCommandExButton;
import javax.faces.component.html.HtmlForm;
import com.ibm.bankjsf.actions.LogoutAction;
import java.lang.String;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlOutputFormat;
/**
 * @author Harri M‰enp‰‰
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BankJSFAccountDetails extends PageCodeBase {

	protected HtmlScriptCollector scriptCollector1;
	protected HtmlPanelBox box1;
	protected HtmlGraphicImageEx headerImage;
	protected HtmlOutputText text1;
	protected DataObject accountParameters;
	protected DataObject account;
	protected JDBCMediator accountMediator;
	private static final String SDOConnection_name = "BankJSF_Con1";
	private ConnectionWrapper SDOConnectionWrapper;
	private static final String account_metadataFileName = "/WEB-INF/wdo/account.xml";
	protected static final String[] accountArgNames = { "paramID",
			"sessionScopeaccountID" };
	protected static final String[] accountArgValues = { "#{param.ID}",
			"#{sessionScope.accountID}" };
	protected HtmlScriptCollector scriptCollector2;
	protected HtmlOutputText text2;
	protected HtmlOutputText text3;
	protected HtmlMessages messages1;
	protected HtmlCommandExButton button1;
	protected HtmlForm form1;
	protected LogoutAction Logout;
	protected HtmlCommandExButton button2;
	protected String logoutLogoutResultBean;
	protected UIParameter param1;
	protected HtmlOutputFormat format1;
	protected HtmlScriptCollector getScriptCollector1() {
		if (scriptCollector1 == null) {
			scriptCollector1 = (HtmlScriptCollector) findComponentInRoot("scriptCollector1");
		}
		return scriptCollector1;
	}
	protected HtmlPanelBox getBox1() {
		if (box1 == null) {
			box1 = (HtmlPanelBox) findComponentInRoot("box1");
		}
		return box1;
	}
	protected HtmlGraphicImageEx getHeaderImage() {
		if (headerImage == null) {
			headerImage = (HtmlGraphicImageEx) findComponentInRoot("headerImage");
		}
		return headerImage;
	}
	protected HtmlOutputText getText1() {
		if (text1 == null) {
			text1 = (HtmlOutputText) findComponentInRoot("text1");
		}
		return text1;
	}
	/** 
	 * @action id=account
	 */
	public String doAccountUpdateAction() {
		try {
			getAccountMediator().applyChanges(
					getAccount().getDataGraph().getRootObject());
		} catch (Throwable e) {
			logException(e);
		} finally {
			SDOConnectionWrapper = null;
		}
		return "";
	}
	/** 
	 * @action id=account
	 */
	public String doAccountDeleteAction() {
		try {
			DataObject root = getAccount().getDataGraph().getRootObject();
			getAccount().delete();
			getAccountMediator().applyChanges(root);
		} catch (Throwable e) {
			logException(e);
		} finally {
			SDOConnectionWrapper = null;
		}
		return "";
	}
	/** 
	 * @paramBean id=account
	 */
	public DataObject getAccountParameters() {
		if (accountParameters == null) {
			try {
				accountParameters = getAccountMediator()
						.getParameterDataObject();
			} catch (MediatorException e) {
				logException(e);
			}
		}
		return accountParameters;
	}
	/** 
	 * @mediatorFactory com.ibm.etools.sdo.rdb.datahandlers.RelationalDataFactory
	 * @mediatorProperties metadataFileName=/WEB-INF/wdo/account.xml
	 * @methodEntry id=account/paramBean=account/action=account
	 * @action FILL
	 */
	public DataObject getAccount() {
		if (account == null) {
			doAccountFetchAction();
		}
		return account;
	}
	/** 
	 * This method was created in order to retrieve existing data.  To create new data:
	 *   DataObject graph = getAccountMediator().getEmptyGraph();
	 *   account = graph.createDataObject(0);  
	 *
	 * @action id=account
	 */
	public String doAccountFetchAction() {
		try {
			resolveParams(getAccountParameters(), accountArgNames,
					accountArgValues, "account_params_cache");
			DataObject graph = getAccountMediator().getGraph(
					getAccountParameters());
			account = (DataObject) graph.getList(0).get(0);
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
	protected JDBCMediator getAccountMediator() {
		if (accountMediator == null) {
			try {
				accountMediator = JDBCMediatorFactoryImpl.soleInstance
						.createMediator(
								getResourceInputStream(account_metadataFileName),
								getSDOConnectionWrapper());
				initSchema(getRealPath(account_metadataFileName),
						accountMediator.getSchema());
			} catch (Throwable e) {
				logException(e);
			}
		}
		return accountMediator;
	}
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
	protected HtmlOutputText getText3() {
		if (text3 == null) {
			text3 = (HtmlOutputText) findComponentInRoot("text3");
		}
		return text3;
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
	protected HtmlForm getForm1() {
		if (form1 == null) {
			form1 = (HtmlForm) findComponentInRoot("form1");
		}
		return form1;
	}
	public String doButton1Action() {
		// Type Java code that runs when the component is clicked
		return "customerDetails";
	}
	/** 
	 * @managed-bean true
	 */
	public void setLogout(LogoutAction Logout) {
		this.Logout = Logout;
	}
	protected HtmlCommandExButton getButton2() {
		if (button2 == null) {
			button2 = (HtmlCommandExButton) findComponentInRoot("button2");
		}
		return button2;
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
	protected UIParameter getParam1() {
		if (param1 == null) {
			param1 = (UIParameter) findComponentInRoot("param1");
		}
		return param1;
	}
	protected HtmlOutputFormat getFormat1() {
		if (format1 == null) {
			format1 = (HtmlOutputFormat) findComponentInRoot("format1");
		}
		return format1;
	}
}