<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.drw.action.*,com.drw.dao.*,com.drw.serviceLocation.*,java.sql.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function Window_onload()
{
	document.changeform.oldpassword.focus();
}
function window_onload()
{
    document.changeform.oldpass.focus();
	document.getElementById("oldpassword").focus();
	document.getElementById("oldpassword").value="";
}
function checkFormValidator()
{
	if(document.changeform.oldpassword.value=="" && document.changeform.newpassword.value=="" && document.changeform.confirmpassword.value=="")
	{
		alert("Please Enter oldpwd");
		document.changeform.oldpassword.focus();
		return false;
	}
	else if(document.changeform.newpassword.value=="")
		{
			alert("Please Enter newpwd");
			document.changeform.newpassword.focus();
			return false;
		}
	else if(document.changeform.confirmpassword.value=="")
		{
			alert("Please Enter confirmpwd");
			document.changeform.confirmpassword.focus();
			return false;
		}
	}
</script>
<style type="text/css">

* {
  box-sizing: border-box;
}
body {
  background: white;
  font-family: "Open Sans", arial;
}
table {
  width: 100%;
  max-width: 600px;
  height: 320px;
  border-collapse: collapse;
  border: 1px solid #38678f;
  margin: 50px auto;
  background: white;
}
th {
  background: #04166f;
  height: 54px;
  width: 25%;
  font-weight: lighter;
  text-shadow: 0 1px 0 #38678f;
  color: white;
  border: 1px solid #38678f;
  box-shadow: inset 0px 1px 2px #568ebd;
  transition: all 0.2s;
}
tr {
  border-bottom: 1px solid #cccccc;
}
tr:last-child {
  border-bottom: 0px;
}
td {
  border-right: 1px solid #cccccc;
  padding: 15px;
  transition: all 0.2s;
}
td:last-child {
  border-right: 0px;
}
td.selected {
  background: #d7e4ef;
  z-index: ;
}
td input {
  font-size: 12px;
  background: none;
  outline: none;
  border: 0;
  display: table-cell;
  height: 100%;
  width: 100%;
}
td input:focus {
  box-shadow: 0 1px 0 steelblue;
  color: steelblue;
}
::-moz-selection {
  background: steelblue;
  color: white;
}
::selection {
  background: steelblue;
  color: white;
}
.heavyTable {
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
  animation: float 5s infinite;
}
.main {
  max-width: 600px;
  padding: 10px;
  margin: auto;
}
.content {
  color: white;
  text-align: center;
}
.content p,
.content pre,
.content h2 {
  text-align: left;
}
.content pre {
  padding: 1.2em 0 0.5em;
  background: white;
  background: rgba(255, 255, 255, 0.7);
  border: 1px solid rgba(255, 255, 255, 0.9);
  color: #38678f;
}
.content .download {
  margin: auto;
  background: rgba(255, 255, 255, 0.1);
  display: inline-block;
  padding: 1em 1em;
  border-radius: 12em;
  margin-bottom: 2em;
}
.content .button {
  display: inline-block;
  text-decoration: none;
  color: white;
  height: 48px;
  line-height: 48px;
  padding: 0 20px;
  border-radius: 24px;
  border: 1px solid #38678f;
  background: steelblue;
  box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 1px 3px rgba(255, 255, 255, 0.2);
  transition: all 0.1s;
}
.content .button:hover {
  background: #4f8aba;
  box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 0 10px rgba(255, 255, 255, 0.1);
}
.content .button:active {
  color: #294d6b;
  background: #427aa9;
  box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 0 5px rgba(0, 0, 0, 0.2);
}
.content .button:focus {
  outline: none;
}
h1 {
  text-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
  text-align: center;
}
.tb8 {
	width: 230px;
	border: 1px solid #3366FF;
	border-left: 4px solid #3366FF;
}

.button {
    background-color: #427aa9; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
.button3 {background-color: #f44336;}
</style>
</head>

<%!
   Connection con=null;
   Statement st=null;
   ResultSet res=null;
   String code="";
   String clevel="";
   String cname="";
%>


<body>





<form name="f" action="<%=request.getContextPath()%>/JSP/salesperson/productde.jsp" method="post">

<table border="0" align="center">
<tr><td><b><font size="4">Category:</font></b></td>

<td><select name="cat" class="tb8" >
<%

String name=request.getParameter("cat");
System.out.println(name);
serverConnector obj=new serverConnector();
Connection con=obj.serverConnector();

Statement smt=con.createStatement();
ResultSet rs=smt.executeQuery("select * from d_cat");
%>


<% 
while(rs.next())
	{
	 %>
<option value=<%=rs.getString(1)%>><%=rs.getString(2)%></option>
<% 
}
%>
</select> </td></tr>





<tr><td><b><font size="4">Sub Category:</font></b></td>

<td><select name="sub"  class="tb8" >

<%
String cat=request.getParameter("cat");
System.out.println(cat);
try
{
	Statement smt1=con.createStatement();
	ResultSet rs1=smt1.executeQuery("select sub_cat_name ,sub_cat_code from d_sub_cat ");
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







</select> 



</td>



</tr>

<tr><td><input type="submit" style="background: green;" value="VIEW"></input></td>
 </table>
 



</form>




























</body>
</html>