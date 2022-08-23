package com.drw.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.drw.dao.ChangeDAO2;
public class Changepwd2 extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		String sp_id=req.getParameter("sp_id");
		String oldpassword=req.getParameter("oldpassword");
		String newpassword=req.getParameter("newpassword");
		int flag=ChangeDAO2.checkpass(sp_id,oldpassword);
		if(flag==1)
		{
		int checkflag=ChangeDAO2.cpassword(sp_id,newpassword);
		System.out.println("action"+sp_id);
		if(checkflag==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/changepwd2.jsp");
			req.setAttribute("updatestatus","Changed Successfully");
			rd.forward(req,res);
		}
		else
		{
		RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/changepwd2.jsp");
		req.setAttribute("updatestatus","Not Changed");
		rd.forward(req,res);
	}
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/changepwd2.jsp");
			req.setAttribute("updatestatus","Old Password Mismatch");
			rd.forward(req,res);
		}
	}
}

