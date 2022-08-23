package com.data;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Billpayment extends HttpServlet {
	
	
	private char[] ch;
	private char s;
	private String str="";

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
		sm = request.getParameter("sm");
		System.out.println("sm is>>>>>>>>>>>>>>>"+sm);
		
	     String	sid = request.getParameter("sid");
	
	     System.out.println("sales person id is>>>>>>>>>>>>>>>"+sid);
	     
	     
	     data=CommonDAO.getposkeys(sid);
	     
	    System.out.println("data is >>>>>>>>>>>>>>>>>>>>>>"+data);
	     
	     String poskeys[]=data.split("-");
	     
	    String key1=     poskeys[0];
	  System.out.println("key1 is >>>>>>>>>>>>>>>>>>>>>>"+key1);
	     
	   String key2=     poskeys[1];
	     
	  System.out.println("key2 is >>>>>>>>>>>>>>>>>>>>>>"+key2);  
	  
	     
	     
	  System.out.println("as certificate is >>>>>>>>>>>>>>>>>>>>>>>"+sm);
	  	byte[] odata_by =sm.trim().getBytes();
	  	
	  	String enc_Data = Encryption_RNS.encryptMessage1(odata_by, key1, key2);
		
	    System.out.println("enc_Data data is>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+enc_Data);	
			
			String dec=Decryption_RNS.decryptMessage(enc_Data, key1, key2);
			
	     System.out.println("decrypted data is>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+dec);
	     
	     
	String mescardcontent[]=     dec.trim().split("~~~");
	     
	String message=     mescardcontent[0];
	System.out.println("message>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+message);
	
	String cardcontent=     mescardcontent[1];   
	System.out.println("cardcontent>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+cardcontent); 
	
	String cardcontents[]=cardcontent.trim().split("~~");

	
	String cardid=cardcontents[0];
	
System.out.println("cardid is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+cardid);
	
String encryptedcontenthashcode=	cardcontents[1];  

System.out.println("encryptedcontenthashcode is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+encryptedcontenthashcode);

String ascertificate=	cardcontents[2]; 
System.out.println("ascertificate is>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ascertificate);	     
	     
/*String contenthashcode=MD5ForString.getMD5(encryptedcontenthashcode);

System.out.println("contenthashcode is >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+contenthashcode);*/






String aeskeys=CommonDAO.getaeskeys();


String aeskeyss[]=aeskeys.split("-");

String aeskey1=     aeskeyss[0];
System.out.println("aeskey1 is >>>>>>>>>>>>>>>>>>>>>>"+aeskey1);
 
String aeskey2=     aeskeyss[1];
 
System.out.println("aeskey2 is >>>>>>>>>>>>>>>>>>>>>>"+aeskey2);  




/*
byte[] odata_by1 = contenthashcode.getBytes();

String encdata = new String(odata_by1);*/


String deccontent=Decryption_RNS.decryptMessage(encryptedcontenthashcode.trim(), aeskey1, aeskey2);
System.out.println("--------deccontent------"+deccontent);
String decontents[] =deccontent.split("~");

String dt[]=message.split("-");
String billnum=	dt[0];
System.out.println("billnum>>>>>>>>>>>>>>>>>>>>>"+billnum);
String amount=	dt[1];
System.out.println("amount>>>>>>>>>>>>>>>>>>>>>"+amount);
String atmnumber=	dt[2];
System.out.println("atmnumber>>>>>>>>>>>>>>>>>>>>>"+atmnumber);   
String bankname=decontents[0];
ch = bankname.toCharArray();
for(int i=1;i<ch.length;i++){
	s= ch[i];
	 str = str+s;
}
System.out.println("bankname>>>>>>>>>>>>>>>>>>>>>"+s);   
String customerid=decontents[0];
System.out.println("customerid>>>>>>>>>>>>>>>>>>>>>"+customerid);   
String cardname= decontents[2];
System.out.println("cardname>>>>>>>>>>>>>>>>>>>>>"+cardname); 
String expirydte=decontents[3];
System.out.println("expirydte>>>>>>>>>>>>>>>>>>>>>"+expirydte); 
/*String cardpan=decontents[4];
System.out.println("cardpan>>>>>>>>>>>>>>>>>>>>>"+cardpan); */

bank=CommonDAO.Checkbankname(bankname);
if(bank)
{
	
		
		
		cardnamee=CommonDAO.cardname(cardname);
		
		if(cardnamee)
		{
			
			
			
			exp=CommonDAO.expirydte(expirydte);
			if(exp)
			{
				
				
				
			/*	pan=CommonDAO.pan(cardpan);*/
			
	atm=CommonDAO.checkatm(atmnumber);

if(atm)
{
	
	
	
	billamount=CommonDAO.checkbillnoandamount(billnum,amount);
	
	if(billamount)
	{
		
		
		
		 String cardbalance=CommonDAO.Takecardamount(str);
		
			if(Integer.parseInt(cardbalance)>Integer.parseInt(amount))
			{
				
		      int remainingamount=		Integer.parseInt(cardbalance)-Integer.parseInt(amount);
			System.out.println("remaining amount is>>>>>>>>>>>>>>>>"+remainingamount);	
				
		String	  remainingbalance=CommonDAO.updateremaingamount(str,""+remainingamount);	
			  
			  

			  System.out.println("paid block>>>>>>>>>>>"+remainingbalance);	
			  String success="success";
				sb.append(success);
				sb.append("~");
				sb.append(remainingbalance);
				out.println(sb.toString());	
				
			  
			  
			  
			  
				
			}else
			{
				
				System.out.println("insufficient block>>>>>>>>>>>");	
				sb.append("insufficient");
				sb.append("~");
				sb.append("data");
				out.println(sb.toString());	
				
					  
				
				
				
				
			}
			
		
		
		
		
		
		
	}
	
	else
	{
		
		
		
		sb.append("wrong billamount");
		sb.append("~");
		sb.append("data");
		out.println(sb.toString());		
		
	}
	
	
	
	
	
}
else
{
	sb.append("wrong atm");
	sb.append("~");
	sb.append("data");
	out.println(sb.toString());	
		
	
	
}
				
				
				
				
					
					
					
					
					
					
				}
				
			else
			{
				
					
				sb.append("wrong pan");
				sb.append("~");
				sb.append("data");
				out.println(sb.toString());	
				
			}
				
				
				
				
			}
			else
			{
				
						
				

				sb.append("wrong expdate");
				sb.append("~");
				sb.append("data");
				out.println(sb.toString());		
				
				
			}
			
			
			
			
			
		}
		
		
		else
		{
			
			
			
		

			sb.append("wrong cardname");
			sb.append("~");
			sb.append("data");
			out.println(sb.toString());		
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}











	 
