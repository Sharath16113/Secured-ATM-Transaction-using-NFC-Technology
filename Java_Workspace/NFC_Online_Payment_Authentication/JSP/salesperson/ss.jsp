<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.drw.serviceLocation.serverConnector,java.sql.*,com.drw.dao.*,com.drw.action.*,java.math.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="<%=request.getContextPath()%>/bg1.jpg">
<%!
   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String photo="";
   String name="";
     String proname="";
     float q=0.0f;
     int qno;
     float p=0.0f;
     float t=0.0f;
     float am=0.0f;
     float amt=0.0f;
     float amtp=0.0f;
     float amtptt=0.0f;
     float tmp; 
     
   int code;
   String qp="";
   String pp="";
   String amp="";
   String tp="";
   int qun;
   
 %>
 <%
 
int qno=UserDAO.getqno();
 
 System.out.println("Quotatio nin jsp"+qno);
 
   con=serverConnector.serverConnector();
   st=con.createStatement();
   String query="select qty,price,tax,amount,pro_code from t_quotation where q_no='"+qno+"'";
   res=st.executeQuery(query);
   
 %>
 <form  action="<%=request.getContextPath()%>/confirm"   method="post">
 <center >ONLINE BILLING FOR COMPUTER SUPERMARKET </center>
<center>BILL NUMBER:<input type="text" name="qno" value="<%=qno%>"></input></center>
 
 <table align="center" border="1" width="75%" >
 
 <tr>
 
  <td width="35%">
 <p align="center"><font size="4">&nbsp;<b>Name</b></font></p>
 </td>
  <td width="35%">
 <p align="center"><font size="4">&nbsp;<b>Quantity</b></font></p>
 </td>
 <td width="35%">
 <p align="center"><font size="4">&nbsp;<b>Price</b></font></p>
 </td>
 <td width="35%">
 <p align="center"><font size="4">&nbsp;<b>Tax</b></font></p>
 </td>
 <td width="35%">
 <p align="center"><font size="4">&nbsp;<b>Amount</b></font></p>
 </td>
 </tr>
 <%
 float tt=0.0f;
 while(res.next())
   {  qun=res.getInt(1);
   p=res.getFloat(2);
   t=res.getFloat(3);
   am=res.getFloat(4);
   System.out.println("amount"+am);
     int code=res.getInt(5);
     System.out.println("code in jsp"+code);
     String name=UserDAO.getname(code);
     System.out.println("the mnemr"+name);
     amt=UserDAO.gettotal(qno);
     System.out.println("the mnemr"+amt);
     System.out.println("thre initial amount is "+tt);
     tt=tt+am;
     System.out.println("thre after addition amount is "+tt);
     tmp = Math.round(tt);
  
      %>
   <tr>
        <td width="35%"><%=name%></td>
        <td width="35%"><%=qun%></td>
        <td width="35%"><%=p%></td>
        <td width="35%"><%=t%></td>
        <td width="35%"><%=am%></td>
        
        <td width="26%"><a href="<%=request.getContextPath()%>/JSP/salesperson/quodelete.jsp?pro_code=<%=code%>" onClick="return confirm('Do u want to delete<%=name%>?')">Delete</a>
    </td>
    <td width="26%"><a href="<%=request.getContextPath()%>/JSP/salesperson/quoupdate1.jsp?pro_code=<%=code%>">Edit</a>
    </td>
      
    <%
    }

	
    %>
     
     </table>
 <center> NET AMOUNT:<input type="text" name="tot" value="<%=tmp%>"></center>
    <br>
    <center><a href="<%=request.getContextPath()%>/JSP/salesperson/category1.jsp">Add More Items To Cart</a></center><br></br>
 <center><input type="submit" value="Pay...The...Amount"></input></center> 

</form>
   <%String status=null;
    status=(String)request.getAttribute("InsertSuccess");
    if(status==null)
    {
    }
    else
    {
    %>
    <center><font color="green"><b><%=status%></b></font></center>
    <%
    }
    %>
    
    
</body>
</html>