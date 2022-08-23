package com.drw.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import com.drw.dao.UserDAO;
public class AddSalesServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		
		String key ="";
		PrintWriter out=res.getWriter();
		String spid=req.getParameter("spid");
		String sppassword=req.getParameter("sppass");
		String spname=req.getParameter("spname");
		String spaddress=req.getParameter("spadd");
		String spmobile=req.getParameter("spmobile");
		String spemail=req.getParameter("spmail");
		try {
			key= Key_generation_rns.Generation();
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	String keys[]=	key.split("~");
	
		int flag=UserDAO.addsales1(spid,sppassword,spname,spaddress,spmobile,keys[0],keys[1],spemail);
		if(flag==1)
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AddSales.jsp?no=1");
			req.setAttribute("insertstatus","insert success");
			rd.forward(req,res);
			
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/Admin/AddSales.jsp?no=2");
			req.setAttribute("insertstatus","insert not success");
		}
}
}
