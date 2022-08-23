<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.drw.serviceLocation.serverConnector,java.sql.*,com.drw.dao.*,com.drw.action.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Mode</title>
</head>

<body>

<center>
	<h1>Payment Mode</h1>
	<form action="<%=request.getContextPath()%>/JSP/salesperson/cashpay.jsp">
		<input type="submit" value="Pay By Cash">
	</form>
	
	<form action="<%=request.getContextPath()%>/JSP/salesperson/cardpay1.jsp">
		<input type="submit" value="Pay By Card">
	</form>

</center>

<%
	String status=null;

    status=(String)request.getAttribute("InsertSuccess");
    if(status==null)
    {
    }
    else
    {
%>
	<br>
    <center>
    		<font color="green"><b><%=status%></b></font>
    </center>
<%
    }
%>
    

</body>
</html>