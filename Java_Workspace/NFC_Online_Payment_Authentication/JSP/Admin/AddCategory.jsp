<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

</style>
<script language="javascript">
function window_onload()
{
    document.categoryform.ccode.focus();
	document.getElementById("ccode").focus();
	document.getElementById("ccode").values="";
}
function checkFormValidator()
{
	if(document.categoryform.ccode.value=="" && document.categoryform.cname.value=="")
	{
		alert("Please Enter All Fields");
		document.categoryform.ccode.focus();
		return false;
	}
	else if(document.categoryform.ccode.value=="")
	{
		alert("Please Enter categorycode");
		document.categoryform.ccode.focus();
		return false;
	}
	else if(document.categoryform.cname.value=="")
	{
		alert("Please Enter categoryname");
		document.categoryform.cname.focus();
		return false;
	}
}

function CheckNo()
{
	var ctrl=document.categoryform.ccode.value;
	var ctrl1=ctrl.length;
	var count=0;
	for(var i=0;i<ctrl1;i++)
	{
		var c=ctrl.charAt(i);
		if((c<"0")||(c>"9"))
		{
			count=count+1;
		}
	}
	if(count>=1)
	{
		alert("enter numbers only");
		document.categoryform.ccode.value="";
		document.categoryform.ccode.focus();
		return false;
	}
	else if(ctrl.length>12)
	{
		alert("enter correct code");
		document.categoryform.ccode.value="";
		document.categoryform.ccode.focus();
		return false;
	}
	if(ctrl.value=="")
	{
		alert("enter correct code");
		return false; 
	}
}

function CheckName()
{
	var name=document.categoryform.cname.value;
	var len=name.length;
	for(var i=0;i<len;i++)
	{
		var ctrl=name.charAt(i);
		var a=parseInt(ctrl);
		if((a>"65") || (a<"122"))
		{
			alert("enter characters only");
			document.categoryform.cname.value="";
			document.categoryform.cname.focus();
			return false;
		}
	}
}
	</script>
</head>
<body onload="window_onload()" background="<%=request.getContextPath()%>/bg1.jpg">
<center>
<form action="<%=request.getContextPath()%>/AddCategoryServlet" name="categoryform" method="post" onsubmit="return checkFormValidator()">
<table rows="2" width="25"><br></br>
<tr><td><b>CatCode:</b></td><td>&nbsp;&nbsp;<input type="text" name="ccode" name="categoryform" onBlur="return CheckNo()"></input></td></tr>
<tr><td><b>CatName:</b></td><td>&nbsp;&nbsp;<input type="text" name="cname" name="categoryform" onBlur="return CheckName()"></input></td></tr>
</table><br></br>
<input type="submit" name="submit" value="Add" class="button button2"></input>
<input type="reset" name="reset" value="Reset" class="button button2"></input>
<%
String status=null;
status=(String)request.getAttribute("insertstatus");
if(status==null)
{}
else
{
%>
<font color="blue"><b><%=status%></b></font>
<%
}
%>
</form>
</center>
</body>
</html>