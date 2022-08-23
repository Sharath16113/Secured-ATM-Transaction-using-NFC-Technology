


<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="java.sql.*"%>
<%!String oldpass = "";
	String user = "";
	String pass = "";
	String confirmusr = "";

	

	StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";%>

<%
	sb = new StringBuffer();

user = request.getParameter("user");
System.out.print("user"+user);
pass = request.getParameter("passs");
System.out.print("pass"+pass);
Class.forName("com.mysql.jdbc.Driver");

Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nfc_payment", "root", "admin");

Statement stmt=(Statement) con.createStatement();


ResultSet rs=	stmt.executeQuery("select * from d_admin where admin_id='"+user+"' and admin_password='"+pass+"'");
boolean flag = false;
while(rs.next())
{
	
	flag=true;
	
	
}



sb.append(flag);


	System.out.println(sb.toString());

	out.println(sb.toString()); //Sending Response to Android App
	
	
	
%>

