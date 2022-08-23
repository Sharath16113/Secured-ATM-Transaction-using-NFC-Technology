package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drw.dao.UserDAO;

public class xx  extends HttpServlet {
	  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	    {
	    	 PrintWriter out=res.getWriter();
	    	 
	    	
	    	 
	    	 String s=req.getParameter("procode");
	    	 System.out.println("code"+s);
	    	 int code1=Integer.parseInt(s);
    	 	 System.out.println("the code is "+code1);
    	 	  
    	 	  String qty= req.getParameter("qty").toString();
    	 	  float q=Float.parseFloat(qty);
    	 	 System.out.println("theqty is "+qty);
    	 	  System.out.println("qty in quo java"+q);
    	 	   String price=(String) req.getParameter("price");
    	 	float p=Float.parseFloat(price);
    	 	  System.out.println("qty in quo java"+p);
    	 	String tax=(String) req.getParameter("tax");
    	 	float t2=Float.parseFloat(tax);
    	 	  System.out.println("qty in quo java"+t2);
    	 	  float tax1=t2/100;
    	 	    	   float tot=p*q+tax1;
    	      System.out.println("tpot"+tot);
    	 System.out.println("tpot"+tot);
    	
    	 int qno=UserDAO.getqno();
    	 
    	 
		int checkFlag=UserDAO.qu(code1,q,tot,qno);
    	 if(checkFlag==1)
    	 {
    		 System.out.println("updated t_quotation ");
    		  RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/ss.jsp");
    	    req.setAttribute("InsertSuccess","updated successfully!");
    	    rd.forward(req,res);
    	 }
    	 else
    	 {    out.println("updated  not t_quotation ");
    		 RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/ss.jsp");
    		 req.setAttribute("InsertSuccess","update failure!");
     	    rd.forward(req,res);
    	 }
    	 
    }
	    	 
	    	 
	    	
	    	 
	    } 


