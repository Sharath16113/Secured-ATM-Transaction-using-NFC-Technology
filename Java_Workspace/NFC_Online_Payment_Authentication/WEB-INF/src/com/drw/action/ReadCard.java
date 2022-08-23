package com.drw.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drw.dao.*;

public class ReadCard extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		String cardno=req.getParameter("cardno");
		System.out.println("The R F ID is ..."+cardno);
		int flag=UserDAO.checkCard(cardno);
		if(flag==1)
		{
			HttpSession hs=req.getSession(true);
   		 	hs.setAttribute("id",cardno);
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/cardpay.jsp");
		    req.setAttribute("InsertSuccess","Reading Sucessfull....Card Details are follows...!");
		    rd.forward(req,res);					
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/JSP/cardpay.jsp");
		    req.setAttribute("InsertSuccess1","****Sorry it is Invalid Card*****");
		    rd.forward(req,res);	
		}	
		
	}
}
