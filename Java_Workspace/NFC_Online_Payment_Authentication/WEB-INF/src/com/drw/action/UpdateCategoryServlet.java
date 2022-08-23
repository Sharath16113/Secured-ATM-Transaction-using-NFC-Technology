package com.drw.action;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.drw.dao.CategoryDAO;
public class UpdateCategoryServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		int cat_code;
	    String cat_name="";
		cat_code=Integer.parseInt(req.getParameter("ccode"));
		cat_name=req.getParameter("cname");
		int flag=CategoryDAO.updatecategory(cat_code,cat_name);
		if(flag==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/CategoryDetails.jsp");
			req.setAttribute("Updatestatus","update success");
			rd.forward(req,res);
			
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/CategoryDetails.jsp");
			req.setAttribute("Updatestatus","update not success");
		}
}
}
