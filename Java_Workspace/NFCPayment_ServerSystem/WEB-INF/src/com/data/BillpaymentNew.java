package com.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BillpaymentNew extends HttpServlet {
	
	
	private char[] ch;
	private char s;
	private String str="";
	private String msg;
	private String bill;
	private String amount;
	private String pin;
	private boolean flag;
	private String f;
	private String netamt;
	private String totalamt;
	private String cardid;
	private String card;

	public void service(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		StringBuffer sb=new StringBuffer();
		boolean atm=false;
		boolean billamount=false;
		boolean bank=false;
		boolean exp=false;
		boolean pan=false;
		boolean cardnamee=false;
		boolean custid=false;
		PrintWriter out=response.getWriter();
		String	data="",sm="";
		msg = request.getParameter("sm");
		System.out.println("sm is>>>>>>>>>>>>>>>"+msg);
		String [] s=msg.split("~~");
		System.out.println("00000000"+s[0]);
		
	String[] r=	s[0].split("~");
		String m[]=r[0].split("-");
		bill = m[0];
		amount = m[1];
		pin= m[2];
		System.out.println(pin+""+amount);
		cardid =r[1];
	
		flag=CommonDAO.checkpin(pin,cardid);
		if(flag){
			netamt= CommonDAO.checkbill(bill);
			totalamt = CommonDAO.gettotamount(pin,cardid);
			int a=Integer.parseInt(netamt);
			int b=Integer.parseInt(totalamt);
			if(b>a){
			int c= b-a;
			String str=String.valueOf(c);
			boolean res=CommonDAO.updateAmount(pin,str);
			System.out.println(res);
			String amountnew=CommonDAO.getupdatedAmt(pin);
			if(res){
				CommonDAO.deletebill(bill);
				out.print("success~"+amountnew);
			}
			else
			{
				out.print("error");
			}
			}
			else{
				System.out.println("Insuffiecient Balance");
				out.print("Insuffiecient Balance");
			}
		}
		
	}
}











	 
