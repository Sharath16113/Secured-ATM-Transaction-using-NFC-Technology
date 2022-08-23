<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.drw.dao.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String sp_id=request.getParameter("sp_id");
System.out.println("spid to be Deleted "+sp_id);
int flag=UserDAO.deleteAuser(sp_id);
%>

<%
if(flag==1)
{
	System.out.println("Delete the Details");
%>

<jsp:forward page="/JSP/Admin/SalesDetails.jsp">
<jsp:param name="deletestatus" value="success"/>
</jsp:forward>
<%
}
%>
</body>
</html>