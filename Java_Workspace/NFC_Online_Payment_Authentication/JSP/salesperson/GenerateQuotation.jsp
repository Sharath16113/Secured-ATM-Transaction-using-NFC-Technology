<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.drw.serviceLocation.serverConnector,java.sql.*,com.drw.dao.*,com.drw.action.*,java.util.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function f()
{
	var q=document.f.qty.value;
	return q;
}
function f1()
{
	var q=document.f.qty.value;
	var m=document.f.mrp.value;
	var m1=document.f.tax.value;
	var t,e;
	var t1=m1/100;
	t=q*m;
	e=t+t1;
	document.f.tot.value=t;
	
	
}


</script>
</head>
<body background="<%=request.getContextPath()%>/bg1.jpg">

<%String s=request.getParameter("pro_code");

%>

<%!
   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String photo="";
   String name="";
   String price="";
   String purchase="";
   String mrp="";
   String tax="";
  String code="";
  
%>
 
<%
   con=serverConnector.serverConnector();
   st=con.createStatement();
   String query="select pro_name,pro_photo_path,pro_pur_price,pro_price,pro_tax,pro_mrp,pro_code from d_product where pro_code='"+s+"'";
   res=st.executeQuery(query);
%>

<%
   int count=0;
   while(res.next())
   {
	 ++count;
   	 name=res.getString(1);
   	 photo=res.getString(2);
     purchase=res.getString(3);
     price =res.getString(4);
     tax=res.getString(5);
     mrp=res.getString(6);
     code=res.getString(7);
    
   }
%>

<form name="f" action="<%=request.getContextPath()%>/qutoation" method="post">
   
   <table align="center" width="700">
   		<tr align="center">
   				<td colspan="3" align="center">
   					<h2>Product Details</h2>
   				</td>
   		</tr>
   		
   		<tr>
   				<td colspan="3" align="center">
   						<hr>
   				</td>
   		</tr>
   		
   		<tr>
   				<td colspan="3" align="center">
   						<img src="<%=request.getContextPath()%>//uploadedimages//<%=photo%>"  height="150" width="150"></img>
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
   						<input type="text" name="code" value="<%=code%>"></input>
   				</td>
   		</tr>
   		
   		<tr align="center" height="10"></tr>
   		
   		<tr align="center">
   				<td align="center">
   						Product Name 
   				</td>
   				
   				<td width="30" align="center">
   						:
   				</td>
   				
   				<td align="center">
   						<input type="text" name="name" value="<%=name %>"></input> 
   				</td>
   		</tr>
   		
   		<tr align="center" height="10"></tr>
   		
   		<tr align="center">
   				<td align="center">
   						MRP Rate 
   				</td>
   				
   				<td width="30" align="center">
   						:
   				</td>
   				
   				<td align="center">
   						<input type="text" name="mrp" value="<%=mrp%>"></input>
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
   						<input type="text" name="price" value="<%=price%>"></input>
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
   						<input type="text" name="tax" value="<%=tax%>"></input>
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
   						<input type="text" name="qty" onchange="f1()" />
   				</td>
   		</tr>
   		
   		<tr align="center" height="10"></tr>
   		
   		<tr align="center">
   				
   				<td colspan="3" align="center">
   						<input type="submit" name="submit" value="Add To Cart"/>
   				</td>
   		</tr>
   		
   </table> 

</form>

<%-- 
<form action="<%=request.getContextPath()%>/createquo" method="post">
   <input type="submit" value="Prepare Bill"></input>
</form>
--%>   
</body>
</html>