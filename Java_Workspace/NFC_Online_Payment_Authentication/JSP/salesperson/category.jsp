<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.drw.action.*,com.drw.dao.*,com.drw.serviceLocation.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body background="<%=request.getContextPath()%>/bg1.jpg">

<font color="blue">
<center>
<%!
   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String code="";
   String clevel="";
   String cname="";
%>
<form name="f" action="<%=request.getContextPath()%>/JSP/salesperson/productde.jsp" method="post">

<b>category:</b>
<select name="cat" >
<% 
	String name=request.getParameter("cat");
	System.out.println(name);
	serverConnector obj=new serverConnector();
	Connection con=obj.serverConnector();
%>

<%
try
{
	//session.removeAttribute("qd");
	Statement smt=con.createStatement();
	ResultSet rs=smt.executeQuery("select cat_code ,cat_name from d_cat");
	while(rs.next())
	{
		String code=rs.getString(1);
		String catname=rs.getString(2);
		
				
	%>
	<option value=<%=code%>><%=catname%></option>

<%
		

	}
}
catch(Exception e)
{
	
}
%>
</select>
<br>
</br>
SubCategory::
<select size="1" name="sub" >
<%
String cat=request.getParameter("cat");
System.out.println(cat);
try
{
	Statement smt1=con.createStatement();
	ResultSet rs1=smt1.executeQuery("select sub_cat_name ,sub_cat_code from d_sub_cat where cat_code='"+cat+"'");
	while(rs1.next())
	{
	String	sub_name=rs1.getString(1);
	String	subcode=rs1.getString(2);
		
	
%>
<option value="<%=subcode%>"><%=rs1.getString(1)%></option>
<%
	}
}

catch(Exception e)
{
	out.println(e);
}
%>
<br>
</br>
</select><br></br>
<input type="submit" value="view"></input>
</form>
</body>
</html>