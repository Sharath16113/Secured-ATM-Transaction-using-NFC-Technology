<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.drw.serviceLocation.serverConnector,java.sql.*,com.drw.dao.*,com.drw.action.*"
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
   float q=0.0f;
   float p=0.0f;
   float t=0.0f;
   String q1="";
   String p1="";
   String t1="";
   
   %>
<%
   String cust_id=request.getParameter("pro_code");
   System.out.println(cust_id);
   int pro_code=Integer.parseInt(cust_id);
   con=serverConnector.serverConnector();
   st=con.createStatement();
   String query="select qty,price,tax from t_quotation where pro_code='"+pro_code+"'";
   res=st.executeQuery(query);
   int count=0;
   while(res.next())
   {
	   ++count;
   q1=res.getString(1);
   p1=res.getString(2);
   t1=res.getString(3);
	
   
   }
   %>
   
   <form action="<%=request.getContextPath()%>/xx" method="post">
   
   <table align="center" width="700">
   		<tr align="center">
   				<td colspan="3" align="center">
   					<h2>Product Update</h2>
   				</td>
   		</tr>
   		
   		<tr>
   				<td colspan="3" align="center">
   						<hr>
   				</td>
   		</tr>
   		
   		
   		
   		<tr align="center" height="10"></tr>
   		
   		<tr align="center">
   				<td align="center">
   						Product Code 
   				</td>
   				
   				<td width="30" align="center">
   						:
   				</td>
   				
   				<td align="center">
   						<input type="text" name="procode" value="<%=pro_code%>" readonly="readonly" ></input>
   				</td>
   		</tr>
   		
   		<tr align="center" height="10"></tr>
   		
   		<tr align="center">
   				<td align="center">
   						Quantity
   				</td>
   				
   				<td width="30" align="center">
   						:
   				</td>
   				
   				<td align="center">
   						<input type="text" name="qty" value="<%=q1%>" ></input> 
   				</td>
   		</tr>
   		
   		
   		
   		<tr align="center" height="10"></tr>
   		
   		<tr align="center">
   				<td align="center">
   						Price
   				</td>
   				
   				<td width="30" align="center">
   						:
   				</td>
   				
   				<td align="center">
   						<input type="text" name="price" value="<%=p1%>" readonly="readonly"></input>
   				</td>
   		</tr>
   		
   		<tr align="center" height="10"></tr>
   		
   		<tr align="center">
   				<td align="center">
   						Tax
   				</td>
   				
   				<td width="30" align="center">
   						:
   				</td>
   				
   				<td align="center">
   						<input type="text" name="tax" value="<%=t1%>" readonly="readonly"></input>
   				</td>
   		</tr>
   		
   		
   		
   		<tr align="center" height="10"></tr>
   		
   		<tr align="center">
   				
   				<td colspan="3" align="center">
   						<input type="submit" name="submit" value="update"/>
   				</td>
   		</tr>
   		
   </table> 

</form>
   
   
   
   
   
   
   
   
   <%-- <form action="<%=request.getContextPath()%>/xx" method="post">
   <div style=" left: 600px; top: 100px ">
   pro_code:<input type="text" name="procode" value="<%=pro_code%>"></input><br></br>
   Quantity:<input type="text" name="qty" value="<%=q1%>"></input><br></br>
   Price:<input type="text" name="price" value="<%=p1%>"></input><br></br>
   Tax:<input type="text" name="tax" value="<%=t1%>"></input><br></br>
   <input type="submit" value="update"></input>
   
   </div>
   </form> --%>
</body>
</html>