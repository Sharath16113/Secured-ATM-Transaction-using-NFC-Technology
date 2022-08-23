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

@SuppressWarnings("serial")
public class confirm extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
		System.out.println(" ........confirm................");
		PrintWriter out=res.getWriter();
	    String t=req.getParameter("tot");
	    System.out.println("Total amount in confirm"+t);
	    
		float tot=Float.parseFloat(t);
	    System.out.println("Total amount in confirm"+tot);
		int qno=UserDAO.getqno();
	   	System.out.println("get qutation no in jsp "+qno);
	   	int checkFlag=UserDAO.updatequotation(tot,qno);
		System.out.println("this is total"+t);   
		 
		if(true)
		{ 
			 System.out.println("record updated in d_quotation");
			 HttpSession hs=req.getSession(true);
	   		 hs.setAttribute("total",t);
			 RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/nextss.jsp");
			 req.setAttribute("InsertSuccess","Bill generated successfully! Make The Payment");
	    	 rd.forward(req,res);
			    							
		}
        else
        {
        	out.println("u r quotation not generated");
        	System.out.println("record  not updated in d_quotation");
            RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/nextss.jsp");
            req.setAttribute("InsertSuccess","Bill not generated successfully!");
	        rd.forward(req,res);
        }
		 
		 
     }
}
