
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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%

StringBuffer sb  = new StringBuffer();

String empId = "";
String imageByt = "";
String fileName = "",pin="";


empId = request.getParameter("empId");

String filedata = request.getParameter("imageByte");

byte[] imageBytes = new sun.misc.BASE64Decoder().decodeBuffer(filedata);

//byte[] decoded = Base64.getDecoder().decode(encoded);
String filedata1 = String.valueOf(imageBytes);
String filedata2 = request.getParameter("fileName");

System.out.println("imageBytes=======  "+filedata);
System.out.println("filedata1=======  "+filedata1);
System.out.println("filedata2=======  "+filedata2);



boolean trans_flg1 = false;
boolean trans_flg2 = false;
String featureToEncrypt;
String encrypted = "";

String file_path2 = "", file_path1 = "";
pin = request.getParameter("pin");
System.out.println("sm is>>>>>>>>>>>>>>>"+pin);


if(filedata1!=null)
{
	file_path1 = request.getRealPath("")+"\\android_fingerprint\\"+filedata2;
	
	FileOutputStream imageOutFile = new FileOutputStream(file_path1);
	imageOutFile.write(imageBytes);
	imageOutFile.close();
	
	String fingerprintValue = Fingerprint.fingerprint(file_path1);
	System.out.print("......"+fingerprintValue);

	try {
       	 AESCrypt  encrypter = new AESCrypt();
        	encrypted = encrypter.encrypt(fingerprintValue);
	} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	}

	System.out.print("fingerprintValue>>>>>>>>>>>"+fingerprintValue);
	

	boolean flag = CommonDAO.checkFingerPrint(fingerprintValue,pin);
	
	System.out.println("flag>>>>>>>>>>>"+ flag);
	
	if(flag){
		out.print("true");
	}
	else{
		
	}
	System.out.println("Successfull"); 
}

//out.println(imageByt);

%>