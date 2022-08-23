package com.drw.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.drw.dao.UserDAO;


public class print extends HttpServlet{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
	System.out.println("..................createquotation.................");
 PrintWriter out=res.getWriter();
   	HttpSession hs=req.getSession(true);
   	String   code=req.getParameter("code");
   	 String  qty =req.getParameter("qty");
   	 String  tot=req.getParameter("tot");
   	 	
   	 float total=0.0f;
   int qno;
   qno=UserDAO.getqno();
   	 Map mp = new HashMap();

   	  mp = (Map) hs.getAttribute("qd");
   	 
    	int tot1=0;
       Set s=mp.entrySet();
     Iterator i=s.iterator();
   
   while(i.hasNext())
   {
	   Map.Entry me=(Map.Entry)i.next();
	   String pno=(String) me.getKey();
	   
	   String q=(String) me.getValue();
	   System.out.println("productcode"+pno+"quantity"+q);
	   int p=Integer.parseInt(pno);
	   float qu=Float.parseFloat(q);
	    float price=UserDAO.getprice(p);
	   System.out.println("the price of the product"+price);
	    float tax=UserDAO.gettax(p);
	    System.out.println("the tax of the product"+tax);
	    float tax2=tax/100;
	    float t1=price*qu+tax2;
	    System.out.println("total amount of the single product"+t1);
	     total=total+t1;
	      
	     System.out.println(" get qutation no"+qno);
	     int cat_code=UserDAO.getcatcode(p);
	     System.out.println("cat_code"+cat_code);
	     int flag1=UserDAO.insertt(qno,p,cat_code,qu,price,tax,t1);
 if(flag1==1)
 {
	 System.out.println("record inserted in t_quotation");
	 
 }
 else
 {
	 System.out.println("record  not inserted in t_quotation");
	
 }
	    }
   
   System.out.println("total amount of the products"+total);
   
}
}