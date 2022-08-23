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

public class createquo  extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
    {
		System.out.println("..................Biillingggggg.................");
		PrintWriter out=res.getWriter();
	   	HttpSession hs=req.getSession(true);
	   	
	   	//String  code = req.getParameter("code");
	   	//String  qty = req.getParameter("qty");
	   	//String  tot = req.getParameter("tot");
	   	
	   	int qno=UserDAO.getqno();
	   	if(qno==0)
	   	{
	   		qno=1;
	   	}
	   	
	   	System.out.println(" get qutation no in jsp "+qno);
	   	float total=0.0f;
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
		   System.out.println("Product Code : "+pno+"\nQuantity : "+q);
		   
		   int procode=Integer.parseInt(pno);
		   float quantity=Float.parseFloat(q);
		   float price=UserDAO.getprice(procode);
		   System.out.println("Price : "+price);
		   float protax=UserDAO.gettax(procode);
		   System.out.println("Tax : "+protax);
		   int tax=(int) (price*(protax/100));
		   float protot=(price*quantity)+tax;
		   total=total+protot;
		   
		   int catcode=UserDAO.getcatcode(procode);
		   System.out.println("Category Code : "+catcode);
		   int autocode=UserDAO.gettabautoid();
		   
		   
		   
		   
		   
		  // qno=autocode;
		       
		  int fl=UserDAO.insertt(qno,procode,catcode,quantity,price,protax,protot);
		boolean flag=UserDAO.updatenetamount(qno);
		  
		  
		 
		  if(fl==1 && flag==true)
		  {
			  System.out.println("Record Inserted In The t_quotation.");
			  
		  }
		  else
		  {
			  System.out.println("Record not inserted in the t_quotation.");
		  }

	   }
	   System.out.println("Total Amount : "+total);
	   
	   float tot6=0.0f;
	   int checkFlag=UserDAO.updatequotation(total,qno);
	   hs.removeAttribute("qd");  
	   if(checkFlag==1)
	   { 
		    System.out.println(" first record inserted in d_quotation");
		    RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/ss.jsp");
					rd.forward(req,res);
	   }
       else
       {
         
         System.out.println("record  not inserted in d_quotation");
         RequestDispatcher rd=req.getRequestDispatcher("/JSP/salesperson/ss.jsp");
         rd.forward(req,res);
       }
	 
	 }
	 
 }

    
    

