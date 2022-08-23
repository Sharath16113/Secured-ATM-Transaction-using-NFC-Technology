package com.drw.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import com.drw.dao.SubCategoryDAO;
public class AddSubCategoryServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		int sub_cat_code=Integer.parseInt(req.getParameter("subccode"));
		String sub_cat_name=req.getParameter("subcname");
		int cat_code=Integer.parseInt(req.getParameter("ccode"));
		System.out.println(sub_cat_code);System.out.println(cat_code);System.out.println(sub_cat_name);
		int flag=SubCategoryDAO.addsubcategory(sub_cat_code,cat_code,sub_cat_name);
		if(flag==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AddSubCategory.jsp");
			req.setAttribute("insertstatus","insert success");
			rd.forward(req,res);
			
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AddSubCategory.jsp");
			req.setAttribute("insertstatus","insert not success");
		}
}
}
