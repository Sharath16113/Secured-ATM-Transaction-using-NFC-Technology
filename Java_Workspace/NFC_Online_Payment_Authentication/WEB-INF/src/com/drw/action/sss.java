package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drw.dao.UserDAO;

public class sss extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		System.out.println("..................printing................");
	 PrintWriter out=res.getWriter();
	   	HttpSession hs=req.getSession(true);
	   	String s= hs.getAttribute("t").toString();
	   	System.out.println(s);
	   	float t1=Float.parseFloat(s);
	   	System.out.println("total amount is"+t1);
	   			
	   	
	   	 int q=UserDAO.getqno();
	   	 System.out.println("qutation no"+q);
	   	 int f=UserDAO.updatequotation(t1, q);
	   	 if(f==1)
	   	 {
	   		 System.out.println("record updated ");
	   		 RequestDispatcher rd=req.getRequestDispatcher("/JSP/category.jsp");
	    	    rd.forward(req,res);
	   	 }
	   	 else
	   	 {
	   		 System.out.println("record  not updated ");
	   		RequestDispatcher rd=req.getRequestDispatcher("/JSP/category.jsp");
    	    rd.forward(req,res);
	   	 }
	   	 
	}
}