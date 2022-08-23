package com.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class OTP extends HttpServlet {
	
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		StringBuffer sb=new StringBuffer();
		boolean atm=false;
		boolean billamount=false;
		boolean bank=false;
		boolean exp=false;
		boolean pan=false;
		boolean cardnamee=false;
		boolean custid=false;
		PrintWriter out=response.getWriter();
		String	data="",otp="";
		String Status ="no";
		otp = request.getParameter("otp");
		System.out.println("otp is>>>>>>>>>>>>>>>"+otp);
		
	     String	sid = request.getParameter("UID");
	
	     System.out.println("sales person id is>>>>>>>>>>>>>>>"+sid);
	     
	     
	     
	  boolean flag=   CommonDAO.validateotp(otp);
	     
	     if(flag)
	     {
	    	 
	    	 
	    	 sb.append("true");
	    		out.println(sb.toString());		
	    		 
	    	 
	     }
	     
	     else
	     {
	    	 
	    	 sb.append("false");
	    		out.println(sb.toString());		
	    		 
	    	 
	    	 
	    	 
	     }
	     
	     
	 









	     

	
		
		
		
}
}