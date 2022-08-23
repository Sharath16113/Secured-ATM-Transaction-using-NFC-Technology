package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

@SuppressWarnings("serial")
public class TransactionDetailstwo extends HttpServlet {
	
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		boolean flag=false;
		String	vtype="",	cardnum="",tollname="",strDaet="";
		cardnum = request.getParameter("cardnum");
		StringBuffer sb=new StringBuffer();
		 String  remainingbalance="";
		 PrintWriter out=response.getWriter();
		 ResultSet rs=null;
		strDaet = request.getParameter("dtt");
		System.out.print("strDaet>>>>>>>>>>>>>>>>"+strDaet);
		vtype = request.getParameter("dataaa");
			System.out.print("vtype>>>>>>>>>>>>>>>>"+vtype);
			tollname = request.getParameter("tollname");
			System.out.print("tollname>>>>>>>>>>>>>>>>"+tollname);
			
	
		
		if(vtype.equals("All"))
		{
		
	rs=CommonDAO.gettransactiondetails22(strDaet,tollname);
		}else
		{
			
			rs=CommonDAO.gettransactiondetails2(strDaet,vtype,tollname);	
			
			
		}
	 
	 String tollfare ="";
	 StringBuffer sb1 = new StringBuffer();
     try {
		while (rs.next())
		 {
		     
		   tollfare =  rs.getString(1);
		    
		     sb1.append(tollfare);
		 }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     out.print(sb1.toString());
     
     System.out.println("stringbuilder data i s>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sb1.toString());
     out.flush();
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		/*System.out.println("trans>>>>>>>>>>>>>>>>>>>>>"+trans);
						sb1.append(trans);
						
						out.println(sb1.toString());*/
					
		
		
		
		
}
}