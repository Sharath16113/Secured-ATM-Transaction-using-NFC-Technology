/**
 @Author : Munna Kumar Singh
 Date : Apr 19, 2013
 File : B.java
 Package : com.kumar
*/
package com.drw.HttpClient;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
public class CustomUrlResponse 
{
	
    public static String getRespose(String reqUrl)
    {
    	String response = "";
    	BufferedReader in = null;
    	try 
    	{

	        //URL urldemo = new URL("http://www.google.com/");
	        URL url = new URL(reqUrl);
	        URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef());
	        url = uri.toURL();
	        URLConnection con = url.openConnection();
	        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      
	        StringBuffer sb = new StringBuffer("");
            String line = "";
            String NL = System.getProperty("line.separator");
            while ((line = in.readLine()) != null) 
            {
                sb.append(line + NL);
            }
            response = sb.toString();
	        	
		} 
    	catch (Exception e) 
    	{
			System.out.println("Opps,Exception In CustomUrlResponse==>getRespose(String url)");
			e.printStackTrace();
		}
    	finally
    	{
    		try 
    		{
				in.close();
			}
    		catch (IOException e) 
    		{
				e.printStackTrace();
			}
    	}
    	
    	return response;
    }
    
/* Testing The Development */   
    
    public static void main(String[] args)
    {
		String reqUrl="",response="";
		reqUrl="http://localhost:8080/SUSIE_SearchMusic/GetSingerAction?song_title=Teddy Bear";
		response = getRespose(reqUrl);
		System.out.println("Response : " + response);
	}
	
}
