<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- jsf:pagecode language="java" location="/src/pagecode/Login.java" --%><%-- /jsf:pagecode --%><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<html>
<head>
<title>login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" title="Style"
	href="theme/stylesheet.css">
</head>
<f:view>
	<body><h:form styleClass="form" id="loginform">
		<h:outputLabel value="Username" styleClass="outputLabel" id="usernamelabel"
			for="username"></h:outputLabel>
		<h:inputText styleClass="inputText" id="username"></h:inputText>
		<h:outputLabel value="password" styleClass="outputLabel" id="passwordlabel"
			for="username"></h:outputLabel>
		<h:inputSecret styleClass="inputSecret" id="password"></h:inputSecret>
		<br/><br/>
		<h:commandButton type="submit" value="Login" label="Login"
			styleClass="commandButton" id="button1"></h:commandButton>
	</h:form></body>
</f:view>
</html>