<%-- jsf:pagecode language="java" location="/JavaSource/pagecode/BankJSFLogin.java" --%><%-- /jsf:pagecode --%>
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
	<TITLE>BankJSFLogin.jsp</TITLE>
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
	<%-- tpl:put name="bodyarea" --%><hx:scriptCollector id="scriptCollector2"><h:outputText
					styleClass="outputText" id="text2" value="Login" style="font-family: Arial, sans-serif; font-size: 14pt"></h:outputText><P><FONT
					face="Arial">Enter customer SSN:</FONT><h:outputFormat
					styleClass="outputFormat" id="errorMessage" style="color: red; font-family: Arial, sans-serif; font-size: 12pt" value=" {0}"><f:param id="param1" name="msg1" value="#{pc_BankJSFLogin.errorMessages}"></f:param></h:outputFormat></P>
				<h:form styleClass="form" id="form1">
					<h:inputText styleClass="inputText" id="customer" value="#{sessionScope.customerSSN}" required="true">
						<f:validateLength minimum="11"></f:validateLength>
					</h:inputText>
					<h:message for="customer"></h:message>
					<hx:commandExButton type="submit" value="Enter"
						styleClass="commandExButton" id="button1" action="#{pc_BankJSFLogin.login}"></hx:commandExButton>
				</h:form>
			</hx:scriptCollector><%-- /tpl:put --%>
	</BODY>
</f:view>
</HTML>
<%-- /tpl:insert --%>