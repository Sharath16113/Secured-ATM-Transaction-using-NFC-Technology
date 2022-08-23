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

public class delet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
		
		 PrintWriter out=res.getWriter();
		 String userid=req.getParameter("pro_code");
	     System.out.println("product code to be deleted" +userid);
	     int q=Integer.parseInt(userid);
	 	int qno=UserDAO.getqno();
	   	System.out.println(" get qutation no in jsp "+qno);
	      int flag=UserDAO.deleteproduct(q,qno);
	     if(flag==1)
	     {
	    	          System.out.println("procudt is deleted");
					 
				    RequestDispatcher rd=req.getRequestDispatcher("/JSP/delquo.jsp");
				    req.setAttribute("InsertSuccess","deleted successfully!");
		    	    rd.forward(req,res);
				    							
			             }
			                else
			                {
			                	RequestDispatcher rd=req.getRequestDispatcher("/JSP/delquo.jsp");
							    req.setAttribute("InsertSuccess","product not deleted!");
					    	    rd.forward(req,res);
				                 
			                	
			                }
		 
		 
     }
}
