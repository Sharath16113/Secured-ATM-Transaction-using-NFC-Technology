package com.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SendSmscode
{
	public static void SendSMS(String m_mobile,String msg)
	{
		try
		  {
				 
			    String postData = "";
			    String retval = "";
			    String User = "blrstore1";
			    String passwd = "dhscvs123";
			    String sid = "dhs";
			    String mtype = "N";
			    String DR = "Y";
			    
			    
			    postData = (new StringBuilder(String.valueOf(postData))).append("User=").append(URLEncoder.encode(User, "UTF-8")).append("&passwd=").append(passwd).append("&mobilenumber=").append(m_mobile).append("&message=").append(URLEncoder.encode(msg, "UTF-8")).append("&sid=").append(sid).append("&mtype=").append(mtype).append("&DR=").append(DR).toString();
			    System.out.println("PostDatas: "+postData);
			   
			    URL url = new URL("http://smscountry.com/SMSCwebservice.asp");
			    System.out.println("URL: "+url);
			    
			    HttpURLConnection urlconnection = (HttpURLConnection)url.openConnection();
			    urlconnection.setRequestMethod("POST");
			    
			    urlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			    urlconnection.setDoOutput(true);
			    OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
			    out.write(postData);
			    out.close();
			    BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
			    String decodedString;
			    while((decodedString = in.readLine()) != null) 
			        retval = (new StringBuilder(String.valueOf(retval))).append(decodedString).toString();
			    in.close();
			    System.out.println(retval);
			    
			    System.out.println("++++++++++++++SMS Send to "+m_mobile+" Successfullyyy+++++++++++++++++++");
			}
			catch (Exception e)
			{
						// TODO: handle exception
			}
		
	}
}





/*
public class SendSMS
{++
	  public static void main(String[] arg)
	  {
		  PersonalSMS sms=new PersonalSMS();
		  String m_mobile="7760255563";
		  String msg="Dear member,A+ blood is emergency please Donoate..";
		  
		 
		  sms.SendSMS(m_mobile, msg);
		  
		  
	  }
	  */
