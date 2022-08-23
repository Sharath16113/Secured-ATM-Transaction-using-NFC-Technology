package com.drw.action;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


import com.drw.dao.UserDAO;


public class changepassword extends HttpServlet 
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{

	PrintWriter out=res.getWriter();
	String adminid="";
	adminid=req.getParameter("adminid");
	String adminoldpass=req.getParameter("opass");
	 String adminnewpass=req.getParameter("npass");

	int checkflag=UserDAO.checkpassword(adminid, adminoldpass);
	if(checkflag==1)
	{
			int flag=UserDAO.changeuser(adminid,adminnewpass);
			System.out.print(adminoldpass);
			if(flag==1)
			{
				RequestDispatcher rd=req.getRequestDispatcher("/JSP/changepassword.jsp");
				req.setAttribute("changestatus", "changed successfully!!!");
				rd.include(req,res);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("/JSP/changepassword.jsp");
				req.setAttribute("changestatus", "changed  not successfully!!!");
				rd.include(req,res);
			}
	}
}
}

