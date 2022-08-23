package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Carddata extends HttpServlet {
	
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		boolean flag=false;
		
	System.out.println("its came iniside >>>>>>>>>>>>>>>>>>>>>");
		StringBuffer sb=new StringBuffer();
		 String  remainingbalance="";
		 PrintWriter out=response.getWriter();
		 ResultSet rs=null;
		  String seckey ="";
		  String seckey1 ="";
		  String as_certicate="";
	   String	 Carddata = request.getParameter("carddata");
		System.out.print("Carddata>>>>>>>>>>>>>>>>"+Carddata.trim());
String data[]=		Carddata.trim().split("~");
		/*String hashcode=MD5ForString.getMD5(Carddata.trim());
		
      System.out.println("hashcode is >>>>>>>>>>>>>>>>>>>>>>>"+hashcode);
      */
      
      rs=CommonDAO.getAsCertificate();		
		
  	
		try {
			while (rs.next())
			 {
			     
				  seckey1 =  rs.getString(2);
			     seckey =  rs.getString(3);
			    as_certicate =  rs.getString(4);
			   
			    
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
System.out.println("as certificate is >>>>>>>>>>>>>>>>>>>>>>>"+as_certicate);
  	byte[] odata_by =Carddata.trim().getBytes();
  	
  	String enc_Data = Encryption_RNS.encryptMessage1(odata_by, seckey1, seckey);
	
		System.out.println("encrypted data"+enc_Data);	
		
		
		
		String finaldata=data[1].trim()+"~~"+enc_Data+"~~"+as_certicate;
		
		System.out.println("fianldata is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+finaldata);
	
     out.println(finaldata.toString());
     
    
    
	 
	 
	 
	 
	
	 
	 
	 
	 
	 
	 
	 
		
		
		
}
}