<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@taglib uri="taglib.tld" prefix="dab"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" 	type="text/css">
<TITLE>RunStoredProcedure.jsp</TITLE>
</HEAD>
<BODY>
<H1>JSP with Stored Procedure Call</H1>
<dab:dataSourceSpec id="DSConnect" scope="page" dataSource='jdbc/bankdb' />
<dab:procedureCall id="getCustomer" connectionSpec="DSConnect" scope="request">
	<dab:sql>
		{ CALL ITSO.GETCUSTOMER(:ssn) }
	</dab:sql>
	<dab:parameter parmName="ssn" type="VARCHAR" mode="in" value="111-11-1111" />
</dab:procedureCall>
<TABLE border="1">
	<TR><TH align="left">Title</TH>    
		<TD><dab:getColumn name="getCustomer" index="1" /></TD></TR>
	<TR><TH align="left">Firstname</TH>
		<TD><dab:getColumn name="getCustomer" index="2" /></TD></TR>
	<TR><TH align="left">Lastname</TH> 
		<TD><dab:getColumn name="getCustomer" index="3" /></TD></TR>
	<TR><TH align="left">Ssn</TH>  
		<TD><dab:getColumn name="getCustomer" index="4" /></TD></TR>
</TABLE>
</BODY>
</HTML>
