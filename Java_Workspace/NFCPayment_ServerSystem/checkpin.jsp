
<%@page import="com.Symmetric.cryptography_AES.AESCrypt"%>
<%@page import="com.data.*"%>
<%@page import="java.awt.Point"%>
<%@page import="com.util.biometric.FingerPrint.direction"%>
<%@page import="java.awt.image.BufferedImage"%><%-- 
<%@page import="com.util.biometric.FingerPrint"%> --%>
<%@page import="com.Symmetric.*"%>
<%@page import="java.util.ArrayList"%>

<%@page import="com.util.biometric.*"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@page import="sun.misc.BASE64Decoder"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 

<%

StringBuffer sb  = new StringBuffer();

String empId = "";
String imageByt = "";
String fileName = "",pin="";


empId = request.getParameter("empId");
 


boolean trans_flg1 = false;
boolean trans_flg2 = false;
 

String file_path2 = "", file_path1 = "";
pin = request.getParameter("pin");
System.out.println("sm is>>>>>>>>>>>>>>>"+pin);


if(pin!=null)
{
	  
	boolean flag = CommonDAO.checkPin(pin);
	
	System.out.println("flag>>>>>>>>>>>"+ flag);
	
	if(flag){
		System.out.println("Successfull"); 
		out.print("true");
	}
	else{
		//out.print("false");
	}
	
}

 

%>