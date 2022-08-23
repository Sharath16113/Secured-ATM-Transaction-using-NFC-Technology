package com.drw.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import com.drw.dao.CategoryDAO;
public class AddCategoryServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		String cat_code=req.getParameter("ccode");
		String cat_name=req.getParameter("cname");
		int flag=CategoryDAO.addcategory(cat_code,cat_name);
		if(flag==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AddCategory.jsp");
			req.setAttribute("insertstatus","insert success");
			rd.forward(req,res);
			
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AddCategory.jsp");
			req.setAttribute("insertstatus","insert not success");
		}
}
}
