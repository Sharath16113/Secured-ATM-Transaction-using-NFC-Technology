package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drw.dao.UserDAO;

public class query  extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	 PrintWriter out=res.getWriter();
    	 String query=req.getParameter("query").trim();
    	 String email=req.getParameter("email").trim();
    	 String phone=req.getParameter("phone").trim();
    	String t1=UserDAO.datefor();
    	 System.out.println(t1);
    	     	 int checkFlag=UserDAO.insertquery(t1,query,email,phone);
    	
    	 if(checkFlag==1)
    	 { 
    	    RequestDispatcher rd=req.getRequestDispatcher("/JSP/sendqueries.jsp");
    	    req.setAttribute("inserstatus","query be send!");
    	    rd.forward(req,res);
    	 }
    	 else
    	 {
    		 RequestDispatcher rd=req.getRequestDispatcher("/JSP/sendqueries.jsp");
     	    req.setAttribute("inserstatus","query not send");
     	    rd.forward(req,res);
    	 }
    	 
    }


}
