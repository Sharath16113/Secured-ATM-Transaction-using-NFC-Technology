<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.drw.dao.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<%=request.getContextPath()%>/bg1.jpg">
<%
String cat_code=request.getParameter("cat_code");
System.out.println("category number to be Deleted "+cat_code);
int flag=CategoryDAO.deletecategory(cat_code);
if(flag==1)
{
%>
<jsp:forward page="/JSP/Admin/CategoryDetails.jsp">
<jsp:param name="deletestatus" value="success" />
</jsp:forward>
<%
}
%>
</body>
</html>