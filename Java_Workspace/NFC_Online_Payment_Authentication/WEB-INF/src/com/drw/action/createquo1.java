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

public class createquo1 extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		System.out.println("..................createquotation.................");
	 PrintWriter out=res.getWriter();
	   	HttpSession hs=req.getSession(true);
	   	String   code=req.getParameter("code");
	   	 String  qty =req.getParameter("qty");
	   	 int code1=Integer.parseInt(code);
	   	 	int qno=UserDAO.getqno();
	   	System.out.println(" get qutation no in jsp "+qno);
	  
	   	float total=0.0f;
	   		   	
		   	 float quantity=Float.parseFloat(qty);
		   	 float price=UserDAO.getprice(code1);
		   	System.out.println("price is"+price);
		   	float protax=UserDAO.gettax(code1);
		   	System.out.println("tax is "+protax);
		   	float tax=protax/100;
		   	float protot=price*quantity+tax;
		        int catcode=UserDAO.getcatcode(code1);
		      System.out.println(" get category code"+catcode);
		       
		  int flag=UserDAO.insertt(qno,code1,catcode,quantity,price,protax,protot);
		 

	   
	   System.out.println("total amount after tselecting product in jsp"+ protot);
	   
	 float tot6=0.0f;
	 
	 
	
	if(flag==1)
	         { 
		 System.out.println(" record inserted in t_quotation");
		    RequestDispatcher rd=req.getRequestDispatcher("/JSP/ss1.jsp");
					rd.forward(req,res);
	             }
	                else
	                {
		                 
		                 System.out.println("record  not inserted in t_quotation");
		                 RequestDispatcher rd=req.getRequestDispatcher("/JSP/ss1.jsp");
				               	rd.forward(req,res);
	                }
	 
	
	 }
	 
 }

    
    

