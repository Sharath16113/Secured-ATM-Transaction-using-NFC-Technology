package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drw.dao.UserDAO;

@SuppressWarnings("serial")
public class qutoation  extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		System.out.println("..................quotation.................");
    	PrintWriter out=res.getWriter();
    	HttpSession hs=req.getSession(true);
    	
    	String   code=req.getParameter("code");
    	String  qty =req.getParameter("qty");
    	  	
    	Map mp = new HashMap();    	 
    	mp = (Map) hs.getAttribute("qd");
    	
    	Map cmp = new HashMap(); 
    	if(qty.equals("")||code.equals(""))
    	{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/GenerateQuotation.jsp");
			req.setAttribute("Loginstatus","Please,Enter All The Fields!!!!!");
			rd.forward(req,res);
    	}
    	else
    	{
			 if(mp==null)
			 {
				 cmp.put(code, qty);
			 }
			 else
			 {
				 cmp = mp;
				 mp.put(code, qty);  
			 }
			
			 hs.removeAttribute("qd");
			 hs.setAttribute("qd", cmp);
			 System.out.println("Session values : "+cmp);
			 
		     //RequestDispatcher rd=req.getRequestDispatcher("/JSP/GenerateQuotation.jsp");
		     RequestDispatcher rd=req.getRequestDispatcher("/createquo");
		     rd.forward(req,res);
    	 }
    	 
    }	 

}
