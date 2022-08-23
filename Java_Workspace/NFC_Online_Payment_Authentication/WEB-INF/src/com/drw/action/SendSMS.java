package com.drw.action;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SendSMS extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
		String bill=req.getParameter("bill");
		String mno=req.getParameter("mno");
		
		BufferedWriter bufferedWriter = null;
	       
        try {
            
            bufferedWriter = new BufferedWriter(new FileWriter("C:/TextOut.txt"));
            bufferedWriter.write(mno);
            bufferedWriter.newLine();
            bufferedWriter.write("Your Bill Amount is ");
            bufferedWriter.write(bill);
            bufferedWriter.write(" reply <YS ");
            bufferedWriter.write(bill);
            bufferedWriter.write("> or No");
           
            
           
            
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {

            try {
                if (bufferedWriter != null) {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
		
        }
		
		
		OutputStream f1=new FileOutputStream("C:/TempIn.txt");
		String s="YS ";
		byte b[]=s.getBytes();
		for(int i=0;i<b.length;i++)
		{
			f1.write(b[i]);
		}
		byte c[]=bill.getBytes();
		for(int i=0;i<c.length;i++)
		{
			f1.write(c[i]);
		}
		f1.close();
		RequestDispatcher rd=req.getRequestDispatcher("/JSP/cardpay.jsp");
		req.setAttribute("InsertSuccess","Message has been sent sucessfully");
		rd.forward(req,res);
		
	}

}
