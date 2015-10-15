<%-- jsf:pagecode language="java" location="/JavaSource/pagecode/BankJSFCustomerDetails.java" --%><%-- /jsf:pagecode --%>
<%-- tpl:insert page="/BankJSFTemplate.jtpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<HTML>
<HEAD>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM Software Development Platform">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="/BankJSF/theme/Master.css" rel="stylesheet" type="text/css">
<%-- tpl:put name="headarea" --%>
	<TITLE>BankJSFCustomerDetails.jsp</TITLE>
<%-- /tpl:put --%>
<LINK rel="stylesheet" type="text/css"
	href="/BankJSF/theme/stylesheet.css" title="Style">
</HEAD>
<f:view>
	<BODY><hx:scriptCollector id="scriptCollector1">
	<P><hx:panelBox styleClass="panelBox" id="box1">
			<hx:graphicImageEx styleClass="graphicImageEx" id="headerImage"
				value="theme/itso_logo.gif"></hx:graphicImageEx>
		</hx:panelBox><h:outputText styleClass="outputText" id="text1"
			value="ITSO Redbank" style="font-family: Arial, sans-serif; font-size: 18pt"></h:outputText></P>
	</hx:scriptCollector>
	<HR>
	<%-- tpl:put name="bodyarea" --%><hx:scriptCollector id="scriptCollector2"><h:form
					styleClass="form" id="form1"><table>
	<tbody>
		<tr>
	<td align="left">Title:</td>
	<td style="width:5px">&nbsp;</td>
	<td><h:inputText id="text2" value="#{pc_BankJSFCustomerDetails.customer.TITLE}" styleClass="inputText"  >
</h:inputText>
</td>
</tr>
<tr>
	<td align="left">Firstname:</td>
	<td style="width:5px">&nbsp;</td>
	<td><h:inputText id="text3" value="#{pc_BankJSFCustomerDetails.customer.FIRSTNAME}" styleClass="inputText"  >
</h:inputText>
</td>
</tr>
<tr>
	<td align="left">Lastname:</td>
	<td style="width:5px">&nbsp;</td>
	<td><h:inputText id="text4" value="#{pc_BankJSFCustomerDetails.customer.LASTNAME}" styleClass="inputText"  >
</h:inputText>
</td>
</tr>
</tbody>
</table><h:messages styleClass="messages" id="messages1"></h:messages>
					<hx:commandExButton type="submit" value="Logout"
						styleClass="commandExButton" id="button2" action="#{pc_BankJSFCustomerDetails.doLogoutLogoutAction}"></hx:commandExButton>
					<BR>
<hx:commandExButton id="button1" styleClass="commandExButton" type="submit" value="Update" action="#{pc_BankJSFCustomerDetails.doCustomerUpdateAction}" >
</hx:commandExButton><h:dataTable id="table1" value="#{pc_BankJSFCustomerDetails.accounts}" var="varaccounts" styleClass="dataTable" headerClass="headerClass" footerClass="footerClass" rowClasses="rowClass1" columnClasses="columnClass1" border="0" cellpadding="2" cellspacing="0" >
						<h:column id="column3">
							<hx:commandExRowAction id="rowAction1" action="#{pc_BankJSFCustomerDetails.doRowAction1Action}"></hx:commandExRowAction>
							<f:facet name="header"></f:facet>
						</h:column>
						<h:column id="column1" >
<f:facet name="header">
<h:outputText styleClass="outputText" value="Account ID" id="text5"></h:outputText>
</f:facet>
<h:outputText id="text6" value="#{varaccounts.ACCOUNTS_ID}" styleClass="outputText" >
</h:outputText></h:column>
<h:column id="column2" >
<f:facet name="header">
<h:outputText styleClass="outputText" value="Balance" id="text7"></h:outputText>
</f:facet>
<h:outputText id="text8" value="#{varaccounts.ACCOUNTS_CUSTOMERS_ACCOUNT.BALANCE}" styleClass="outputText" >
<f:convertNumber type="currency"/>
</h:outputText></h:column>
</h:dataTable>
</h:form>
			</hx:scriptCollector><%-- /tpl:put --%>
	</BODY>
</f:view>
</HTML>
<%-- /tpl:insert --%>