package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.drw.dao.ChangePwdDAO;

@SuppressWarnings("serial")
public class ChangePwdServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		String admin_id=req.getParameter("adminid");
		String oldpwd=req.getParameter("oldpass");
		String newpwd=req.getParameter("npass");
		String confirmpwd=req.getParameter("cname");
		int flag=ChangePwdDAO.checkpass(admin_id,oldpwd);
		if(flag==1)
		{
			int checkflag=ChangePwdDAO.updatepassword(admin_id,oldpwd,newpwd,confirmpwd);
			System.out.println("action"+admin_id);
		if(checkflag==1)
			{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AChangePassword.jsp");
			req.setAttribute("updatestatus","changedsuccess");
			rd.forward(req,res);
			
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AChangePassword.jsp");
			req.setAttribute("updatestatus","change not success");
			rd.forward(req,res);
		}
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AChangePassword.jsp");
			req.setAttribute("updatestatus","old password mismatch");
			rd.forward(req,res);			
		}
}
}
