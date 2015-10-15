<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="false" %>
<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<META name="GENERATOR" content="IBM WebSphere Studio">
<META http-equiv="Content-Style-Type" content="text/css">
<LINK href="theme/Master.css" rel="stylesheet" 	type="text/css">
<TITLE>RunGetCustomerBean.jsp</TITLE>
</HEAD>
<BODY>
<H1>JSP -> JavaBean -> Stored Procedure</H1>
<jsp:useBean id="getCustomer"	class="itso.bank.example.db.bean.GetCustomerBean"></jsp:useBean>
<% try { %>	
<% getCustomer.execute( "111-11-1111" ); %>

<% itso.bank.example.db.bean.GetCustomerBeanRow row = getCustomer.getRows()[0]; %>
<TABLE border="1">
	<TR><TH align="left">Title</TH>
		<TD><%= row.getCUSTOMER_TITLE() %></TD></TR>
	<TR><TH align="left">Firstname</TH>
		<TD><%= row.getCUSTOMER_FIRSTNAME() %></TD></TR>
	<TR><TH align="left">Lastname</TH>
		<TD><%= row.getCUSTOMER_LASTNAME() %></TD></TR>
	<TR><TH align="left">Ssn</TH>
		<TD><%= row.getCUSTOMER_SSN() %></TD></TR>
</TABLE>

<% } catch ( java.sql.SQLException e ){ e.printStackTrace(); }%>	

</BODY>
</HTML>
