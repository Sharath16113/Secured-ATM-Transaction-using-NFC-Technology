<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<%@page import="java.sql.*"%>
<%@page import="com.data.*"%>
<%!
String oldpass = "";
	String sid = "";
	String pass = "";
	String confirmusr = "";
     StringBuffer sb = null;
	String info = "Opps,Something Went Wrong Try Again..";
	%>

<%
	sb = new StringBuffer();
boolean flag = false;
sid = request.getParameter("sid");
System.out.print("sid>>>>>>>>>>>"+sid);
pass = request.getParameter("passs");
System.out.print("pass"+pass);
Class.forName("com.mysql.jdbc.Driver");
String status="no";
Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db_nfc_payment", "root", "admin");

Statement stmt=(Statement) con.createStatement();


ResultSet rs=	stmt.executeQuery("select * from d_salesperson where sp_id='"+sid+"' and sp_password='"+pass+"' ");

	
	String alphaNumerics = "123456789";
	String t = "";
	

	for (int i = 0; i < 6; i++) 
	{
	    t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
	}
	
	
String email=CommonDAO.getphonenum(sid);

	
	//SendSmscode.SendSMS(phone,"Your OTP is "+" "+t );
	//String email=CommonDAO.getEmail(sid);
    String msg="Hi ,You're One Time Password : "+t;
    SendMailAttachment.sendPersonalizedMail(email, "Regarding the OTP ", msg, "no");
   //result=adminDAO.addRating(type,desc,rating);
	
	flag=CommonDAO.updateotp(sid,pass, t);
	
	
	
		flag=true;
		    sb.append(flag);

		

	
	
	

System.out.println(sb.toString());

	out.println(sb.toString()); 
	
	
	
%>

