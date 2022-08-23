package com.data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class Adminlogin extends HttpServlet {
	
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
		
		
	     String	user = request.getParameter("user");
		System.out.print("user"+user);
	    String	pass = request.getParameter("passs");
		System.out.print("pass"+pass);
		
		
		
	
		PrintWriter out=response.getWriter();
		boolean flag=CommonDAO.Checkadminn(user,pass);
		System.out.println("flag value is "+flag);
		
		if(flag)
		{
			
				out.println(flag);
				System.out.println("correct change password status");

			} else
			
			
			{

				
				   out.println("error in change password");	
			}
			
		
			
		
		
		
		
		
		
		
		
		
}
}