<%-- jsf:pagecode language="java" location="/JavaSource/pagecode/BankJSFAccountDetails.java" --%><%-- /jsf:pagecode --%>
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
	<TITLE>BankJSFAccountDetails.jsp</TITLE>
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
	<%-- tpl:put name="bodyarea" --%><hx:scriptCollector id="scriptCollector2"><table>
	<tbody>
						<TR>
							<TD align="left">SSN:</TD>
							<TD style="width:5px"></TD>
							<TD>
								<h:outputFormat styleClass="outputFormat" id="format1" value=" {0}">
<f:param id="param1" name="msg1" value="#{sessionScope.customerSSN}">
</f:param></h:outputFormat></TD>
						</TR>
						<tr>
	<td align="left">Id:</td>
	<td style="width:5px">&nbsp;</td>
	<td>
	<h:outputText id="text2" value="#{pc_BankJSFAccountDetails.account.ID}" styleClass="outputText" >
	</h:outputText></td>
</tr>
<tr>
	<td align="left">Balance:</td>
	<td style="width:5px">&nbsp;</td>
	<td><h:outputText id="text3" value="#{pc_BankJSFAccountDetails.account.BALANCE}" styleClass="outputText" >
<f:convertNumber type="currency"/>
</h:outputText></td>
</tr>
</tbody>
</table><h:messages styleClass="messages" id="messages1"></h:messages>
				<h:form styleClass="form" id="form1">
					<hx:commandExButton type="submit" value="Customer Details"
						styleClass="commandExButton" id="button1" action="#{pc_BankJSFAccountDetails.doButton1Action}"></hx:commandExButton>
					<hx:commandExButton type="submit" value="Logout"
						styleClass="commandExButton" id="button2" action="#{pc_BankJSFAccountDetails.doLogoutLogoutAction}"></hx:commandExButton>
				</h:form>
			</hx:scriptCollector><%-- /tpl:put --%>
	</BODY>
</f:view>
</HTML>
<%-- /tpl:insert --%>