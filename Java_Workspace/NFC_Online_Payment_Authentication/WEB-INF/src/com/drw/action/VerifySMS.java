package com.drw.action;
import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifySMS extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		Scanner result=null;
		Scanner result1=null;
        try
        {
            result=new Scanner(new File("C:/TempIn.txt"));
            result1=new Scanner(new File("C:/TextIn.txt"));
            result.useLocale(new Locale("nl","BE"));
            result1.useLocale(new Locale("nl","BE"));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("The file  +file+  was not found!");
        }
        String readLine = (result.nextLine().trim());
        String readLine1 = (result1.nextLine().trim());
        System.out.println(readLine);
        System.out.println(readLine1);
        if(readLine.equals(readLine1))
        {
        	System.out.println("Verify Sucess");
        	RequestDispatcher rd=req.getRequestDispatcher("/JSP/cardpay.jsp");
    		req.setAttribute("InsertSuccess","Message has been verified sucessfully");
    		rd.forward(req,res);
        }
        else
        {
        	System.out.println("Verify not Sucess");
        	RequestDispatcher rd=req.getRequestDispatcher("/JSP/cardpay.jsp");
    		req.setAttribute("InsertSuccess","Message is missmatched...!");
    		rd.forward(req,res);
        }

        
      
		
		
	}
}
