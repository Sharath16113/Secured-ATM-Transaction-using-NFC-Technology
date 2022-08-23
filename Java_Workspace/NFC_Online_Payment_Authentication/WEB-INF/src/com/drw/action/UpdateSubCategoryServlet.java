package com.drw.action;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.drw.dao.SubCategoryDAO;
public class UpdateSubCategoryServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		int sub_cat_code;
	    String sub_cat_name="";
	    int cat_code;
		sub_cat_code=Integer.parseInt(req.getParameter("subccode"));
		sub_cat_name=req.getParameter("subcname");
		cat_code=Integer.parseInt(req.getParameter("ccode"));
		int flag=SubCategoryDAO.updatesubcategory(sub_cat_code,sub_cat_name,cat_code);
		if(flag==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/SubcatDetails.jsp");
			req.setAttribute("Updatestatus","update success");
			rd.forward(req,res);
			
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/SubcatDetails.jsp");
			req.setAttribute("Updatestatus","update not success");
		}
}
}
