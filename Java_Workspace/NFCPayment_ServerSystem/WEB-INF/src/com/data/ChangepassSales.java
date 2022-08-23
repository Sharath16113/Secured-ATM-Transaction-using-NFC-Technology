package com.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangepassSales  extends HttpServlet{
	
	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
		{
		
		StringBuffer sb = null;
		sb = new StringBuffer();
		System.out.println("its came inside changepassword>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
		String	oldpass = request.getParameter("CurrentPass");
		String	newpass = request.getParameter("NewPass");
		String	ConfirmPass = request.getParameter("ConfirmPass");
		String	sid = request.getParameter("sid");
		
		
		
		
		System.out.println("old password is "+oldpass);
		
		System.out.println("new  password is "+newpass);
		
		System.out.println("ConfirmPass is "+ConfirmPass);
		System.out.println("sid is "+sid);
	
		PrintWriter out=response.getWriter();
		boolean flag=CommonDAO.Checkcurrentpassword(oldpass,sid);
		System.out.println("flag value is "+flag);
		
		if(flag)
		{
			flag = CommonDAO.changePass(newpass,sid);
			if (flag) {

				out.println(flag);
				System.out.println("correct change password status");

			} else
			
			
			{

				
				   out.println("error in change password");	
			}
			
		}
		
		
		


		}
	
	
	
		}