package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drw.dao.UserDAO;

public class search extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
		
		 PrintWriter out=res.getWriter();
			String t=req.getParameter("search");
			int checkFlag=UserDAO.checkproduct(t);
			 if(checkFlag==1)
			         { 
				 
				    RequestDispatcher rd=req.getRequestDispatcher("/JSP/searchresult.jsp");
				    req.setAttribute("InsertSuccess","qutation generated successfully!");
		    	    rd.forward(req,res);
				    							
			             }
			                else
			                {
			                	out.println("product not found ");
				                 
			                	
			                }
		 
		 
     }
}
