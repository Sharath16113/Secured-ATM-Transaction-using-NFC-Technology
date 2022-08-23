<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript">
function window_onload()
{
    document.productform.pcode.focus();
	document.getElementById("pcode").focus();
	document.getElementById("pcode").value=="";
}
function checkFormValidator()
{
	if(document.productform.pcode.value=="" && document.productform.pname.value=="" && document.productform.ccode.value=="" && document.productform.subccode.value=="" && document.productform.pdesc.value=="" && document.productform.pprice.value=="" && document.productform.pmrp.value=="" && document.productform.price.value=="" && document.productform.ptax.value=="")
	{
		alert("Please Enter All Fields");
		document.productform.pcode.focus();
		return false;
	}
	else if(document.productform.pcode.value=="")
	{
		alert("Please Enter productcode");
		document.productform.pcode.focus();
		return false;
	}
	else if(document.productform.pname.value=="")
	{
		alert("Please Enter productname");
		document.productform.pname.focus();
		return false;
	}
	else if(document.productform.ccode.value=="")
	{
		alert("Please Enter customercode");
		document.productform.ccode.focus();
		return false;
	}
	else if(document.productform.subccode.value=="")
	{
		alert("Please Enter SubCustomercode");
		document.productform.subccode.focus();
		return false;
	}
	else if(document.productform.pdesc.value=="")
	{
		alert("Please Enter productDescription");
		document.productform.pdesc.focus();
		return false;
	}
	else if(document.productform.pprice.value=="")
	{
		alert("Please Enter purchasedprice");
		document.productform.pprice.focus();
		return false;
	}
	else if(document.productform.pmrp.value=="")
	{
		alert("Please Enter productmrp");
		document.productform.pmrp.focus();
		return false;
	}
	else if(document.productform.price.value=="")
	{
		alert("Please Enter productprice");
		document.productform.price.focus();
		return false;
	}
	else if(document.productform.ptax.value=="")
	{
		alert("Please Enter producttax");
		document.productform.ptax.focus();
		return false;
	}
}

function CheckNo()
{
	var ctrl=document.productform.price.value;
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
		document.productform.price.value="";
		document.productform.price.focus();
		return false;
	}
	else if(ctrl.length>12)
	{
		alert("enter correct price");
		document.productform.price.value="";
		document.productform.price.focus();
		return false;
	}
	if(ctrl.value=="")
	{
		alert("enter correct price");
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
<body onload="window_onload()" background="<%=request.getContextPath()%>/bg1.jpg">
<center>
<form action="<%=request.getContextPath()%>/AddProductDatabase" method="post" enctype="multipart/form-data" onsubmit="return checkFormValidator()">
<table border="0" width="25">
<tr><td><b>ProCode &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  :</b></td><td>&nbsp;&nbsp; <input type="text" name="pcode"></input></td></tr>
<tr><td><b>ProName &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  :</b></td><td>&nbsp;&nbsp; <input type="text" name="pname" name="productform" onBlur="return CheckName()"></input></td></tr>
<tr><td><b>CatCode  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</b></td><td>&nbsp;&nbsp; <input type="text" name="ccode"></input></td></tr>
<tr><td><b>SubCatCode&nbsp;&nbsp;&nbsp;:</b></td><td>&nbsp;&nbsp; <input type="text" name="subccode"></input></td></tr>
<tr><td><b>ProDesc &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  :</b></td><td>&nbsp;&nbsp;<input type="text" name="pdesc"></input></td></tr>
<tr><td><b>Price&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  :</b></td><td>&nbsp;&nbsp;<input type="text" name="pprice"></input></td></tr>
<tr><td><b>ProMRP  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</b></td><td>&nbsp;&nbsp;<input type="text" name="pmrp"></input></td></tr>
<tr><td><b>SalesPrice&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  :</b></td><td>&nbsp;&nbsp;<input type="text" name="price" name="productform" onBlur="return CheckNo()"></input></td></tr>
<tr><td><b>ProTax  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</b></td><td>&nbsp;&nbsp;<input type="text" name="ptax"></input></td></tr>
<tr><td><b>ProFile  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</b></td><td>&nbsp;&nbsp;<input type="file" name="file"></input></td></tr>
</table><br></br>
<input type="submit" name="add" value="Add" class="button button2"></input>&nbsp;&nbsp;
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