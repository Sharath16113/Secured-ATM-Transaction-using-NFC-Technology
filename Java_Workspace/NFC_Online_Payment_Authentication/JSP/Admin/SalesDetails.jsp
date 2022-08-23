 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.drw.serviceLocation.*,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<link rel="stylesheet" href="<%=request.getContextPath()%>/CSS/table.css" type="text/css"/>
<body background="<%=request.getContextPath()%>/bg1.jpg">
<%!
Connection connection=null;
Statement statement=null;
ResultSet resultset=null;
String sp_id="";
String sp_password="";
String sp_name="";
String sp_address="";
String sp_mobile="";
%>
<%
connection=serverConnector.serverConnector();
statement=connection.createStatement();
String query="select sp_id,sp_password,sp_name,sp_address,sp_mobile from d_salesperson";
resultset=statement.executeQuery(query);
%>
<form action="<%=request.getContextPath()%>/JSP/Admin/AddSales.jsp" method="post">
<center><h2>SalesPersonDetails</h2>
<table class="CSS_Table_Example" style="width:600px;height:150px;">
<tr bgcolor="#145B8D">

<td width="35%" >
<p align="center"><font size="4">&nbsp;<b>LoginID</b></font></p>
</td>
<td width="27%">
<p align="center"><font size="4">&nbsp;<b>password</b></font></p>
</td>
<td width="26%">
<p align="center"><font size="4">&nbsp;<b>name</b></font></p>
</td>
<td width="26%">
<p align="center"><font size="4">&nbsp;<b>address</b></font></p>
</td>
<td width="26%">
<p align="center"><font size="4">&nbsp;<b>mobileNO</b></font></p>
</td>

<td width="26%">
<p align="center"><font size="4">&nbsp;<b>Delete</b></font></p>
</td>

</tr>
<%
int count=0;
while(resultset.next())
{
	++count;
	sp_id=resultset.getString(1);
	sp_password=resultset.getString(2);
	sp_name=resultset.getString(3);
	sp_address=resultset.getString(4);
	sp_mobile=resultset.getString(5);
%>
<tr>
<td width="35%"><%=sp_id%></td>
<td width="27%"><%=sp_password%></td>
<td width="26%"><%=sp_name%></td>
<td width="26%"><%=sp_address%></td>
<td width="26%"><%=sp_mobile%></td>
<td width="26%">
<a href="<%=request.getContextPath()%>/JSP/Admin/userdelete.jsp?sp_id=<%=sp_id%>" Onclick="return confirm('Do you want to delete : <%=sp_id%>?')">Delete</a>
</td>
</tr>



<%
}
String deletestatus="";
deletestatus=request.getParameter("deletestatus");
if(deletestatus==null)
{}
else if(deletestatus.equals("success"))
{
%>
<script language="javascript">
alert("Deleted Successfully");
</script>
<%
}
%>
</table><br></br></center>
<center><input type="submit" name="add" value="Add" class="button button2"></input></center>
</form>
</body>
</html>