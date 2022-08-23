package com.drw.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drw.dao.*;

public class Addcust extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
    	 PrintWriter out=res.getWriter();
    	 int code=Integer.parseInt(req.getParameter("code"));
    	 String id=req.getParameter("id").trim();
    	 String password =req.getParameter("password").trim();
    	 String name=req.getParameter("name").trim();
    	 String contactperson=req.getParameter("contactperson").trim();
    	 String address=req.getParameter("address").trim();
    	 String area=req.getParameter("area").trim();
    	 String city =req.getParameter("city").trim();
    	 String state=req.getParameter("state").trim();
    	 String pincode=req.getParameter("pincode").trim();
    	 String type=req.getParameter("type").trim();
    	 String landmark=req.getParameter("landmark").trim();
    	 String phone=req.getParameter("phone").trim();
    	 String mobile=req.getParameter("mobile").trim();
    	 String fax=req.getParameter("fax").trim();
    	 String email=req.getParameter("email").trim();
    	     	 int checkFlag=UserDAO.insertUser(code,id,password,name,contactperson,address,area,city,state,pincode,type,landmark,phone,mobile,fax,email);
    	
    	 if(checkFlag==1)
    	 { 
    	    RequestDispatcher rd=req.getRequestDispatcher("/JSP/registration.jsp");
    	    req.setAttribute("InsertSuccess","customer  information inserted successfully!");
    	    rd.forward(req,res);
    	 }
    	 else
    	 {
    		 RequestDispatcher rd=req.getRequestDispatcher("/JSP/registration.jsp");
     	    req.setAttribute("InsertSuccess","customer not inserted");
     	    rd.forward(req,res);
    	 }
    	 
    }


}
