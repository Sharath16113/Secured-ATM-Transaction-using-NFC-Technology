/**
 * * @author Munna Kumar Singh
 */
package com.util;

import java.io.BufferedInputStream;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class Utility
{
	public static int parse(String str) 
	{ 
		int p=0; 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		try
		{ 
			p=Integer.parseInt(str); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
	}
	public static double parseDouble(String str) 
	{ 
		double p=0; 
		if(str==null) 
		{ 
			str="0"; 
		} 
		else if((str.trim()).equals("null")) 
		{ 
			str="0"; 
		} 
		else if(str.equals("")) 
		{ 
			str="0"; 
		} 
		try
		{ 
			p=Double.parseDouble(str); 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse(String str) "+e);
		} 
		return p; 
	}
	public static String parse1(Object str) 
	{ 
		String p=""; 
		if(str==null) 
		{ 
			str=""; 
		} 
		else if(str.equals("")) 
		{ 
			str=""; 
		} 
		try
		{ 
			p=(String)str; 
		} 
		catch(Exception e) 
		{
			System.out.println("Opp's error is in Utility parse1(String str) "+e);
		} 
		return p; 
	}
	public static Object parse2(Object str) 
	{ 
		Object obj=null;
		if(str!=null) 
			return str;
		else
			return obj; 
	}
	public static String getPro(String str) 
	{
		String pro="";
		try
		{
			java.security.ProtectionDomain pd =	Utility.class.getProtectionDomain();
			java.security.CodeSource cs = pd.getCodeSource();
			java.net.URL url = cs.getLocation();
			java.io.File f = new File( url.getFile());
			String path=f.getParent();
			Properties property = new Properties();
			FileInputStream in=null;
			in = new FileInputStream(path+"\\Config.properties");
			property.load(in);
			pro=property.getProperty(str);
			//System.out.println("Property to return : "+pro);
		}
		catch(Exception e)
		{
			System.out.println("Opp's error is in Utility getPro(String str) "+e);
		}
		return pro;
	}
	public static String getDate()
	{
		String date="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("dd-MM-yyyy");
			date = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDate( ): "+ e);
		}
		return date;
	}
	public static String getTime()
	{
		String time="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter1=new SimpleDateFormat("HH:mm:ss");
			time = formatter1.format(currentDate.getTime());
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getTime( ): "+ e);
		}
		return time;
	}
	public static String getDay()
	{
		String day="";
		try
		{
			Calendar currentDate = Calendar.getInstance();
			int no=currentDate.get(Calendar.DAY_OF_WEEK);
			if(no==1)
				day="Sunday";
			else if(no==2)
				day="Monday";
			else if(no==3)
				day="TUESDAY";
			else if(no==4)
				day="WEDNESDAY";
			else if(no==5)
				day="THURSDAY";
			else if(no==6)
				day="FRIDAY";
			else if(no==7)
				day="SATURDAY";
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getDay( ): "+ e);
		}
		return day;
	}
	public static String MD(File source1) throws NoSuchAlgorithmException, FileNotFoundException 
	{
		String output="";
		MessageDigest digest = MessageDigest.getInstance("MD5");
		InputStream is = new FileInputStream(source1);				
		byte[] buffer = new byte[8192];
		int read = 0;
		try {
			while( (read = is.read(buffer)) > 0) 
			{
				digest.update(buffer, 0, read);
			}		
			byte[] md5sum = digest.digest();
				System.out.print("Digets:"+md5sum);
			
			System.out.println();
			BigInteger bigInt = new BigInteger(1, md5sum);
			output = bigInt.toString(16);
			System.out.println("MD5: " + output);
		}
		catch(IOException e) 
		{
			System.out.println("Unable to process file for MD5"+e);
		}
		return output;
	}
	public static String getRC4Enc(StringBuffer inp,StringBuffer key)
	{
		int	[]Sbox=new int[inp.length()];
		int []Sbox2=new int[inp.length()];
		int i=0, j=0, t=0, x=0;
		char temp=0 , k=0;
		for( i = 0; i < inp.length()-1; i++)
		{
			Sbox[i] = i;
			if(j==key.length())
			    j = 0;
			Sbox2[i] = key.charAt(j++);
		}
		j = 0;
		for(i = 0; i < inp.length()-1; i++)
		{
			j = (j + Sbox[i] + Sbox2[i]) % inp.length();
			temp = (char)Sbox[i];
//			System.out.println(Sbox[j]);
		    Sbox[i] = Sbox[j];
		    Sbox[j] = temp;
		}
		i = j = 0;
//		for(int n=0;n<Sbox.length;n++)
//			System.out.println(Sbox[n]);
		for(x = 0; x < inp.length() ; x++)
		{
			i = (i + 1) % inp.length();
//			System.out.println(Sbox[i]);
			j = (Sbox[i]) % inp.length();
//			System.out.println(j);
		    temp = (char)Sbox[i];
		    Sbox[i] = Sbox[j] ;
		    Sbox[j] = temp;
		    t = ( Sbox[i] + Sbox[j]) % inp.length() ;
		    k = (char)Sbox[t];
//		    System.out.println(inp.charAt(x) ^ k);
		    inp.setCharAt(x, (char)(inp.charAt(x) ^ k));
		}
		return inp.toString();
	 }
	
	
	public static boolean uploadFile(String ip,String user,String pass,String fileName,String root)
	{
		boolean flag=false;
		try
		{
			StringBuffer sb = new StringBuffer( "ftp://" );
			sb.append( user );
            sb.append( ':' );
            sb.append( pass );
            sb.append( '@' );
            sb.append( ip );
            sb.append( '/' );
            String a="Nitin";
            sb.append( a );
            sb.append( '/' );
            sb.append(fileName );
            sb.append( ";type=i" );
            System.out.println("URL   :"+sb);
            System.out.println("filename in url 1-----"+fileName);
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
           
               URL url = new URL( sb.toString() );
               URLConnection urlc = url.openConnection();
               System.out.println("-----"+urlc);
               bos = new BufferedOutputStream( urlc.getOutputStream() );
               bis = new BufferedInputStream( new FileInputStream( new File(root+fileName) ) );
               int i;
               while ((i = bis.read()) != -1)
               {
                  bos.write( i );
                  flag=true;
               }
               bis.close();
               bos.close();
        }
		catch(Exception e)
		{
			System.out.println("OPP's Error is in UploadFile "+e);
		}
		return flag;
	}
	public static boolean downloadFile(String ip,String user,String pass,String fileName,String root)
	{
		boolean flag=false;
		try
		{
			File f=new File(root+"/Nitin_Temp");
			if(!f.exists())
				f.mkdir();
			StringBuffer sb = new StringBuffer( "ftp://" );
			sb.append( user );
            sb.append( ':' );
            sb.append( pass );
            sb.append( '@' );
            sb.append( ip );
	        sb.append( '/' );
	        String a="Nitin";
	        sb.append( a );
	        sb.append( '/' );
	        sb.append( fileName );
	        sb.append( ";type=i" );
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        URL url = new URL( sb.toString() );
            URLConnection urlc = url.openConnection();
            bis = new BufferedInputStream( urlc.getInputStream());
            bos = new BufferedOutputStream( new FileOutputStream(root+"/Nitin_Temp/"+fileName) );
            int i;
            while ((i = bis.read()) != -1)
            {
               bos.write( i );
               flag=true;
            }
            bis.close();
            bos.close();
        }
		catch(Exception e)
		{
			System.out.println("OPP's Error is in downloadFile "+e);
		}
		return flag;
	}
	public static boolean writeOnFile(String filename,String msg,String root)
	{
		boolean flag=false;
		try
		{
			PrintWriter pw = null;
			File f=new File(root+"\\Files\\Transactios\\"+filename);
			if(!f.exists())
				flag =f.createNewFile();
			pw = new PrintWriter(new FileWriter(f, true));
			pw.println("");
			pw.println(msg);
			pw.flush();
			pw.close();
			flag=true;
			System.out.println(msg);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	public static void main(String asdf[])
	{
		writeOnFile("nitin.txt", "This is test", null);
	}
}
