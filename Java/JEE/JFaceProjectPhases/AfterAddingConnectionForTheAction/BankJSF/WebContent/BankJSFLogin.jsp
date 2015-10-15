<%-- jsf:pagecode language="java" location="/JavaSource/pagecode/BankJSFLogin.java" --%><%-- /jsf:pagecode --%>
<%-- tpl:insert page="/BankJSFTemplate.jtpl" --%><!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@taglib uri="http://www.ibm.com/jsf/html_extended" prefix="hx"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<HTML>
<HEAD>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
<META NAME="GENERATOR" CONTENT="IBM Software Development Platform">
<META HTTP-EQUIV="Content-Style-Type" CONTENT="text/css">
<LINK HREF="/BankJSF/theme/Master.css" REL="stylesheet" TYPE="text/css">
<%-- tpl:put name="headarea" --%>
	<TITLE>BankJSFLogin.jsp</TITLE>
<%-- /tpl:put --%>
<LINK rel="stylesheet" type="text/css"
	href="/BankJSF/theme/stylesheet.css" title="Style">
</HEAD>
<f:view>
	<BODY><hx:scriptCollector id="scriptCollector1">
	<P></P>
		<hx:panelBox styleClass="panelBox" id="box1">
			<hx:graphicImageEx styleClass="graphicImageEx" id="headerImage"
				value="theme/itso_logo.gif"></hx:graphicImageEx>
		</hx:panelBox>
		<h:outputText styleClass="outputText" id="text1" value="ITSO RedBank" style="font-family: sans-serif, Arial; font-size: 18pt"></h:outputText>
	</hx:scriptCollector>
	<HR>
	<%-- tpl:put name="bodyarea" --%>Default content of bodyarea<%-- /tpl:put --%>
	<HR>
	</BODY>
</f:view>
</HTML>
<%-- /tpl:insert --%>