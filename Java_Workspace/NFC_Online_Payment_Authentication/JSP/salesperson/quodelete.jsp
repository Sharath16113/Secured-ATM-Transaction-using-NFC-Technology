<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.drw.serviceLocation.serverConnector,java.sql.*,com.drw.dao.*,com.drw.action.*,javax.servlet.http.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<%=request.getContextPath()%>/bg1.jpg">
<%

     String userid=request.getParameter("pro_code");
     System.out.println("product code to be deleted" +userid);
     int q=Integer.parseInt(userid);
     int qno=UserDAO.getqno();
     int flag=UserDAO.deleteproduct(q,qno);
     if(flag==1)
     {
    	 System.out.println("procudt is deleted");
   %>
    <jsp:forward page="ss.jsp">
    <jsp:param name="InsertSuccess" value="deleted successfully"/>
    </jsp:forward>
    <%
     }
     else
     {
    	 System.out.println("procudt not  deleted");
    	 %>
    	    <jsp:forward page="ss.jsp">
    	    <jsp:param name="InsertSuccess" value="product not deleted"/>
    	    </jsp:forward>
    	    <%
     }
    %> 
</body>
</html>