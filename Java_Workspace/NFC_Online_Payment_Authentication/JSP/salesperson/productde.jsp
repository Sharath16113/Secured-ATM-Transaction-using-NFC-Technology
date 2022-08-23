<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.drw.serviceLocation.serverConnector,java.sql.*,com.drw.dao.*,com.drw.action.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body background="<%=request.getContextPath()%>/bg1.jpg">
<%
	String s=request.getParameter("sub");
String cat=request.getParameter("cat");
%>

<%!
   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String photo="";
   String name="";
   String pro_code="";
%>
<%
   con=serverConnector.serverConnector();
   st=con.createStatement();
   String query="select pro_photo_path,pro_name,pro_code from d_product where sub_cat_code='"+s+"' and cat_code='"+cat+"'";
   res=st.executeQuery(query);
%>
 <center><h2>Product Details</h2></center>
 
 <table align="center" border="1" width="75%">
 <tr align="center">
 <td width="20%" align="center">
 	<p align="center">
	 	<font size="4">
	 		<b>Product Photo</b>
	 	</font>
 	</p>
 </td>
 
 <td width="65%" align="center">
 	<p align="center"><font size="4">&nbsp;<b>Product Name</b></font></p>
 </td>
 
 <td width="10%" align="center">
 	<p align="center"><font size="4">&nbsp;<b>Action</b></font></p>
 </td>
    
 </tr>
 <%
   int count=0;
   while(res.next())
   {++count;
    photo=res.getString(1);
    name=res.getString(2);
    pro_code=res.getString(3);
%>
   <tr align="center">
    <td width="20%" align="center">
    	<img src="<%=request.getContextPath()%>//uploadedimages//<%=photo%>"  height="40" width="50"></img>
    </td>
    <td width="65%">
    	<%=name %>
    </td>
    
     <td width="10%">
      <a href="<%=request.getContextPath()%>/JSP/salesperson/GenerateQuotation.jsp?pro_code=<%=pro_code%>">View</a>
    </td>
    
    </tr>
<%
    }
%>
    </table>
</body>
</html>