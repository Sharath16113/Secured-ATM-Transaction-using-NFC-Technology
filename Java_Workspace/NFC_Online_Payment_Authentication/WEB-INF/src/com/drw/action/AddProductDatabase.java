package com.drw.action;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.drw.dao.ProductDAO;







public class AddProductDatabase extends HttpServlet 
 {
	
	ArrayList list =  new ArrayList();
	String s = "";
	ResultSet rs=null; 
	boolean flag=false;
	boolean flag11=false;
	int autoincr=0;
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		
		
		
		RequestDispatcher rd=null;
		String submit=request.getParameter("action");
	
		
		
		 System.out.println("its came inside addproductlist");    
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		 System.out.println("ismultiaprt is "+isMultipart); 
		 
			ArrayList list =  new ArrayList();
			String s = "";
			String fileName="";
			String filepath = "";
		  if (isMultipart)
			{
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				try
				{
				
				List items = upload.parseRequest(request);
	          	Iterator iterator = items.iterator();
	            while (iterator.hasNext()) 
	            {
	            	FileItem item = (FileItem) iterator.next();
	            	if (item.isFormField()) 
	            	{
	            		s = item.getString();
                    	list.add(s);//All Form Field Values
                    	System.out.println("list is >>>>>>>>>>>>>"+list);
                    	
	            	}
	            	else 
	            	{
	            	
	            	 
	            	 
	            	 
	            		 fileName = item.getName();
	            		 if(fileName!="")
	            		 filepath = request.getRealPath("")+"\\uploadedimages\\"+fileName;
		  	             File f1=new File(filepath);
		  	             item.write(f1);
		  	             flag = true;
		  	            
	            	}
	            }
	            System.out.println("*******  Image Information *******");
	            System.out.println("File Name : " + fileName);
	            System.out.println("list data is  : " + list);
	            System.out.println("size of data is >>>>>>>>>>> : " + list.size());
	            
	            
	        	if(flag)
	    		{
	        		System.out.println("its acme inside if block>>>>>>>>>>>>>>>>>>>>");
	        		String ProCode=(String) list.get(0);
	        		
	        		System.out.println("ProCode>>>>>>>>>>>>>>>>>>>>>"+ProCode);
	        		String ProName=(String) list.get(1);
	        		System.out.println("ProName>>>>>>>>>>>>>>>>>>>>>"+ProName);
	        		
	        		String CatCode=(String) list.get(2);
	        		System.out.println("CatCode>>>>>>>>>>>>>>"+CatCode);
	        		
	        		String SubCatCode=(String) list.get(3);
	        		System.out.println("SubCatCode>>>>>>>>>>>>>>"+SubCatCode);
	        		
	        		
	        		
                     String ProDesc=(String) list.get(4);
	        		
	        		System.out.println("ProDesc>>>>>>>>>>>>>>>>>>>>>"+ProDesc);
	        		
	        		
	        		
	        		String Price=(String) list.get(5);
	        		/*SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        		Date date = (Date) formatter.parse(dob);*/
	        		System.out.println("Price>>>>>>>>>>>>>>>>>>>>>"+Price);
	        		
	        		
	        		
	        		String ProMRP=(String) list.get(6);
	        		System.out.println("ProMRP>>>>>>>>>>>>>>"+ProMRP);
	        		
	        		String SalesPrice=(String) list.get(7);
	        		System.out.println("SalesPrice>>>>>>>>>>>>>>"+SalesPrice);
	        		
	        		
	        		
	        		
	        		
	        		
	        		String ProTax=(String) list.get(8);
	        		System.out.println("ProTax is >>>>>>>>>>>>"+ProTax);
	        		
	        		String ProFile=(String) list.get(9);
	        		System.out.println("ProFile is >>>>>>>>>>>>"+ProFile);
	        		
	        		
	        		
	        		int flag=ProductDAO.addproduct(ProCode,ProName,ProDesc,CatCode,SubCatCode,fileName,Price,ProMRP,SalesPrice,ProTax);
	    			if(flag==1)
	    			{
	    				RequestDispatcher rs=request.getRequestDispatcher("/JSP/Admin/ProductDetails.jsp");
	    				request.setAttribute("uploadstatus","Product Details added Successfully !");
	    				System.out.println("file attached success");
	    				rs.forward(request,response);
	    			}
	    			else
	    			{
	    			RequestDispatcher rs=request.getRequestDispatcher("/JSP/Admin/ProductDetails.jsp");
	    			request.setAttribute("uploadstatus","opps something went wrong !");
	    			System.out.println("error occur in servlet Page");
	    			rs.forward(request,response);
	    			}
	        		
				
				}
				}
	        	catch (Exception e) {
					
				}
				
				
		}
	
		
	
		
	
	
	
	}}


