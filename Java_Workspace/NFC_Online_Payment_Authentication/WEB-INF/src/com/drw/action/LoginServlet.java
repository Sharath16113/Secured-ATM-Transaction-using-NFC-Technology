package com.drw.action;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import com.drw.dao.*;
public class LoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	 PrintWriter out=res.getWriter();
    	
    	 String userid=req.getParameter("salesid").trim();
    	 String password=req.getParameter("salespass").trim();
    	 System.out.println("userid and password is:"+userid+","+password);
    	 float total=0.0f;
	   
    	 if(userid.equals("")||password.equals(""))
    	 {
    		RequestDispatcher rd=req.getRequestDispatcher("/salesperson.jsp") ;
    		req.setAttribute("Loginstatus","please enter all the fields");
    		rd.forward(req,res);
    	 }
    	 else
    	 {
    	
    	 UserDAO ud=new UserDAO();
    	 int checkFlag=ud.checkUser(userid,password);
    	 if(checkFlag==1)
    	 {
    		 HttpSession hs=req.getSession(true);
    		 hs.setAttribute("id",userid);
    	    RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/Home.jsp");
    	    rd.forward(req,res);
    	 }
    	 
    	 else
    	 {
    		 RequestDispatcher rd=req.getRequestDispatcher("/salesperson.jsp");
    		 req.setAttribute("Loginstatus","userid and password is mismatched!");
    		 rd.forward(req,res);
    	 }
    	 }
    } 
   }

