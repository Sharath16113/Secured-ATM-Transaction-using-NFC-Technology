package com.drw.action;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.drw.dao.ProductDAO;
@SuppressWarnings("serial")
public class AttachFile extends HttpServlet
{
	public  void doPost(HttpServletRequest req,HttpServletResponse res) throws  ServletException,IOException
	{
		try
		{
			HttpSession hs1=req.getSession(true); 
			String procode=hs1.getAttribute("pcode").toString().trim();
			System.out.println("Action..........."+procode);
			String proname=hs1.getAttribute("pname").toString().trim();
			System.out.println("Action..........."+proname);
			String prodesc=hs1.getAttribute("pdesc").toString().trim();
			System.out.println("Action..........."+prodesc);
			String catcode=hs1.getAttribute("ccode").toString().trim();
			System.out.println("Action..........."+catcode);
			String subcatcode=hs1.getAttribute("subccode").toString().trim();
			System.out.println("Action..........."+subcatcode);
			String propurprice=hs1.getAttribute("pprice").toString().trim();
			System.out.println("Action..........."+propurprice);
			String promrp=hs1.getAttribute("pmrp").toString().trim();
			System.out.println("Action..........."+promrp);
			String proprice=hs1.getAttribute("price").toString().trim();
			System.out.println("Action..........."+proprice);
			String protax=hs1.getAttribute("ptax").toString().trim();
			System.out.println("Action..........."+protax);
			
			/*RequestDispatcher rd=req.getRequestDispatcher("/UploadFile");
			rd.include(req, res);*/
			String filename=hs1.getAttribute("filepath").toString();
			//System.out.println("Actual File Path: "+filename);
			File file=new File(filename);
			//System.out.println("uploadfile name: "+file.getName());
			FileInputStream fin=new FileInputStream(filename);

			//String path="D:\\Palani_Documents\\images";
			
			String path = req.getRealPath("")+"\\"+"uploadedimages\\";
			System.out.println("-----------------------------");
			System.out.println("Path : " + path);
			System.out.println("-----------------------------");
			
			FileOutputStream fout=new FileOutputStream(path+file.getName());
			System.out.println("uploaded file............"+path+file.getName());
			byte[] content=new byte[1024];
			int x=0;
			while((x=fin.read(content))>-1)
			{
				fout.write(content,0,x);
			}
			
			
			int flag=ProductDAO.addproduct(procode,proname,prodesc,catcode,subcatcode,file.getName(),propurprice,promrp,proprice,protax);
			if(flag==1)
			{
				RequestDispatcher rs=req.getRequestDispatcher("/JSP/Admin/ProductDetails.jsp");
				req.setAttribute("uploadstatus","File Attached Successfully !");
				System.out.println("file attached success");
				rs.forward(req,res);
			}
			else
			{
			RequestDispatcher rs=req.getRequestDispatcher("/JSP/Admin/ProductDetails.jsp");
			req.setAttribute("uploadstatus","File not Attached !");
			System.out.println("error occur in servlet Page");
			rs.forward(req,res);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
     }
}
