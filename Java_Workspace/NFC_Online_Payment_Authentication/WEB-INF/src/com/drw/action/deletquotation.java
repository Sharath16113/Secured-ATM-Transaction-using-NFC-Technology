package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drw.dao.UserDAO;

public class deletquotation extends  HttpServlet {
	  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	    {
		  
		  float tot6=Float.parseFloat(req.getParameter("tot"));
		  System.out.println("the total amount after the deletion"+tot6);
		  int qno=UserDAO.getqno();
		   	System.out.println(" get qutation no in jsp "+qno);
			 int checkFlag=UserDAO.updatequotation(tot6,qno);
			   
			 if(checkFlag==1)
			         { 
				 System.out.println(" record updated after the deletion");
				    RequestDispatcher rd=req.getRequestDispatcher("/JSP/ss.jsp");
							rd.forward(req,res);
			             }
			                else
			                {
				                 
				                 System.out.println("record not updated after the deletion");
				                 RequestDispatcher rd=req.getRequestDispatcher("/JSP/ss.jsp");
						               	rd.forward(req,res);
			                }
			 	 
}
}

