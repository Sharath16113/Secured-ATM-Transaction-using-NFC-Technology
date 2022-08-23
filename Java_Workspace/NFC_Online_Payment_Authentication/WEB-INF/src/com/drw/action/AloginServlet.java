package com.drw.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import com.drw.dao.*;
public class AloginServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		String admin_id=req.getParameter("adminid").trim();
		String admin_password=req.getParameter("adminpass").trim();
		System.out.println("AdminId and Password is :" + admin_id + "," +admin_password);
		if(admin_id.equals("")||admin_password.equals(""))
		{
			RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
			req.setAttribute("loginstatus","Please Enter all the fields !");
			rd.forward(req,res);
		}
		else
		{
			int checkflag=UserDAO.checkAUser(admin_id,admin_password);
			if(checkflag==1)			
			{
				HttpSession hs=req.getSession(true);
				hs.setAttribute("admin_id",admin_id);
				RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/Home.jsp");
				rd.forward(req,res);
			}
			else
				{
					RequestDispatcher rd=req.getRequestDispatcher("/index.jsp?no=4");
					req.setAttribute("loginstatus","Invalid User or Password");
					rd.forward(req,res);
				}
		}
	}
}
