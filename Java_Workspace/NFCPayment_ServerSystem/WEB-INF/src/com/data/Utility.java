/**
 * 
 */
package com.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class Utility extends HttpServlet
{



	static String server = "ftp.drivehq.com";
	static String user = "dhstest";
	static String pass = "dhstest";
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
			System.out.println("Property to return : "+pro);
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
				day="Tuesday";
			else if(no==4)
				day="Wednesday";
			else if(no==5)
				day="Thrusday";
			else if(no==6)
				day="Friday";
			else if(no==7)
				day="Saturday";
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
	public static byte[] DS(byte md[], byte pvtkey[])throws Exception
	{
		byte DS[]=null;
		try
		{
			//DS=RSA_Algorithm.createDS(pvtkey,md);
		}
		catch(Exception e)
		{
			System.out.println("Unable to process file for DS :"+e);
		}
		return DS;
	}
	public static boolean checkDigitalSignature(byte md[], byte pubkey[], byte[] ds)throws Exception
	{
		boolean flag = false;
		try
		{
			//flag=RSA_Algorithm.checkDS(pubkey,md,ds); 
		}
		catch(Exception e)
		{
			System.out.println("Unable to process file for DS Verification : "+e);
		}
		return flag;
	}
	public static StringBuffer getRC4Enc(StringBuffer inp,StringBuffer key)
	{
		int Sbox[];
		int Sbox2[];
		Sbox=new int[257];
		Sbox2=new int[257];
		int i, j, t, x;
		char temp , k;
		i = 0;j = 0;k = 0;t = 0;x = 0;temp = 0;
		//initialize sbox i
		for( i = 0; i < 256; i++)
		{
			Sbox[i] = i;
		}
		j = 0;
		if(key.length() >0)
		{
			for(i = 0; i < 256 ; i++)
			{
				if(j == key.length())
					j = 0;
				Sbox2[i] = key.charAt(j++);
			}
		}
		j = 0 ;
		for(i = 0; i < 256; i++)
		{
			j = (j + Sbox[i] + Sbox2[i]) % 256;
			temp = (char)Sbox[i];
			Sbox[i] = Sbox[j];
			Sbox[j] = temp;
		}
		i = j = 0;
		for(x = 0; x < inp.length() ; x++)
		{
			i = (i + 1) % 256;
			j = (j + Sbox[i]) % 256;
			temp = (char)Sbox[i];
			Sbox[i] = Sbox[j] ;
			Sbox[j] = temp;
			t = ( Sbox[i] + Sbox[j]) % 256 ;
			k = (char)Sbox[t];
			inp.setCharAt(x, (char)(inp.charAt(x) ^ k));
		}
		return inp;
	 }
	/*public static boolean deleteFile(String ip,String user,String pass,String fname)
	{
		//FTPClient client = new FTPClient();
		boolean flag=false;
		try
		{
			client.connect(ip);
            client.login(user, pass);
            String filename = "/cloud_iseive/"+fname;
            boolean result = client.deleteFile(filename);
            client.disconnect();
            if (result)
            {
            	System.out.println("File Deleted...");
            	flag=true;
            }
            else
            	System.out.println("Error While File Delete Process...");
        }
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("OPP's Error is in deleteFile "+e);
		}
		return flag;
	}*/
	
	public static boolean uploadFile(String ftpServer, String user, String password,
			String fileName, File source, String dirToUploadFile)
			throws MalformedURLException, IOException {
		boolean flag=false;
		try
		{
			
		if (ftpServer != null && fileName != null && source != null)
		{
			StringBuffer sb = new StringBuffer("ftp://"); // ftp://dhsinf17:nikisujai@dhsinformatics.com
			// check for authentication else assume its anonymous access.
			if (user != null && password != null) {
				sb.append(user);
				sb.append(':');
				sb.append(password);
				sb.append('@');
			}
			sb.append(ftpServer);
			sb.append('/');
			sb.append(dirToUploadFile);
			 sb.append( '/' );
			 sb.append( fileName );
			/*
			 * type ==> a=ASCII mode, i=image (binary) mode, d= file directory
			 * listing
			 */
			sb.append(";type=i");
			System.out.println("URL   :" + sb);
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				URL url = new URL(sb.toString());
				URLConnection urlc = url.openConnection();
				System.out.println("-----" + urlc);
				bos = new BufferedOutputStream(urlc.getOutputStream());
				bis = new BufferedInputStream(new FileInputStream(source));
				int i;
				// read byte by byte until end of stream
				while ((i = bis.read()) != -1) {
					bos.write((byte) (char) i);
				}

			}
			finally
			{
				if (bis != null)
					try {
						bis.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				if (bos != null)
					try {
						bos.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
			}
			
		}
		else {
			System.out.println("Input not available.");
		}
		
		flag=true;
		}
		catch(Exception e)
		{
			System.out.println("OPP's Error is in UploadFile "+e);
		
		}
		
		return flag;
	}
	

	/*public static boolean delFile(String ftpServer, String user, String password,
			String fileName, File source, String dirToUploadFile)
			throws MalformedURLException, IOException {
		boolean flag=false;
		try
		{
			
		if (ftpServer != null && fileName != null && source != null)
		{
			StringBuffer sb = new StringBuffer("ftp://"); // ftp://dhsinf17:nikisujai@dhsinformatics.com
			// check for authentication else assume its anonymous access.
			if (user != null && password != null) {
				sb.append(user);
				sb.append(':');
				sb.append(password);
				sb.append('@');
			}
			sb.append(ftpServer);
			sb.append('/');
			sb.append(dirToUploadFile);
			 sb.append( '/' );
			 sb.append( fileName );
			
			 * type ==> a=ASCII mode, i=image (binary) mode, d= file directory
			 * listing
			 
			sb.append(";type=i");
			System.out.println("URL   :" + sb);
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				URL url = new URL(sb.toString());
				URLConnection urlc = url.openConnection();
				System.out.println("-----" + urlc);
				//boolean result=((FTPClient) urlc).deleteFile(fileName);
				bos = new BufferedOutputStream(urlc.getOutputStream());
				bis = new BufferedInputStream(new FileInputStream(source));
				int i;
				// read byte by byte until end of stream
				while ((i = bis.read()) != -1) {
					bos.write((byte) (char) i);
				}

			}
			finally
			{
				if (bis != null)
					try {
						bis.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				if (bos != null)
					try {
						bos.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
			}
			
		}
		else {
			System.out.println("Input not available.");
		}
		
		flag=true;
		}
		catch(Exception e)
		{
			System.out.println("OPP's Error is in UploadFile "+e);
		
		}
		
		return flag;
	}
	
	
	*/
	
	public static boolean download( String ftpServer, String ftpuser, String ftppassword,String fileName,String dest) throws MalformedURLException,
    IOException
{
  boolean flag=false;
 if (ftpServer != null && fileName != null )
 {
    StringBuffer sb = new StringBuffer( "ftp://" );
    // check for authentication else assume its anonymous access.
    if (ftpuser != null && ftppassword != null)
    {
       sb.append( ftpuser );
       sb.append( ':' );
       sb.append( ftppassword );
       sb.append( '@' );
    }
    sb.append( ftpServer );
    sb.append( '/' );
    String a="cloud_iseive/";
    sb.append( a );
    //sb.append( downloadDir );
    sb.append( '/' );
    sb.append( fileName );
    
    /*
     * type ==> a=ASCII mode, i=image (binary) mode, d= file directory
     * listing
     */
    sb.append( ";type=i" );
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;
    try
    {
       URL url = new URL( sb.toString() );
       System.out.println("URL is-->"+url);

       URLConnection urlc = url.openConnection();
       /* Download Location */
       
      // String destFilePath = request.getRealPath("") + "/Download/";
      String dir =dest;//  "F:\\Documents and Settings\\dhs\\My Documents\\Downloads";
     // String dir=destfile;
       File f = new File(dir);
        
       if(!f.exists())
       {
       	f.mkdir();
       }
       bis = new BufferedInputStream( urlc.getInputStream());
       bos = new BufferedOutputStream( new FileOutputStream(f+"\\"+fileName) );
       System.out.println("File Dounloaded Sucessfully..");
       
       System.out.println("Url : " + url);

      int i;
       while ((i = bis.read()) != -1)
       {
          bos.write( i );
          flag=true;
       }
     }
    catch (Exception e)
    {
		System.out.println("Opps,Exception in FileDownload Servlet :");
		e.printStackTrace();
	 }
    finally
    {
       if (bis != null)
          try
          {
             bis.close();
          }
          catch (IOException ioe)
          {
             ioe.printStackTrace();
          }
       if (bos != null)
          try
          {
             bos.close();
          }
          catch (IOException ioe)
          {
             ioe.printStackTrace();
          }
    }
 }
 else
 {
    System.out.println( "Input not available" );
 }
 return flag;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean downloadFile(String ip,String user,String pass,String grpname,String fileName)
	{
		boolean flag=false;
		try
		{
			/*File f=new File(root);
			if(!f.exists())
				f.mkdir();*/
			StringBuffer sb = new StringBuffer( "ftp://" );
			sb.append( user );
            sb.append( ':' );
            sb.append( pass );
            sb.append( '@' );
            sb.append( ip );
	        sb.append( '/' );
	        String a="cloud_iseive/"+grpname;
	        sb.append( a );
	        sb.append( '/' );
	        sb.append( fileName );
	        System.out.println("in utility file name value is  "+fileName);
	        sb.append( ";type=i" );
	        System.out.println("sb value-->"+sb);
	        BufferedInputStream bis = null;
	        BufferedOutputStream bos = null;
	        URL url = new URL( sb.toString() );
	        System.out.println("in download url value is  "+url);
            URLConnection urlc = url.openConnection();
            bis = new BufferedInputStream( urlc.getInputStream());
            bos = new BufferedOutputStream( new FileOutputStream(fileName) );
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
			e.printStackTrace();
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
	
	
	public static boolean writeOnFile2(String filename,String msg,String root)
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
	
	
	
	public static String getMD(String URL,String server,String name,String pass,String grpname,String fname)
	{
		String str1="";
		try 
		{ 
			URL url = new URL( URL+"/Verify?server="+server+"&name="+name+"&pass="+pass+"&grpname="+grpname+"&fname="+fname); 
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
			System.out.println("Get MD method is working properlyyy");
			str1 = in.readLine(); 
			in.close(); 
		}
		catch (Exception e)
		{ 
			e.printStackTrace(); 
		} 
		return str1;
	}
	
	public static boolean mkdirr(String dir_name)
	{
		boolean flag=false;
		try
		{
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return flag;
		
	}
	
	
	public static String getHours(String previous_time,String new_Time)
	{
		String diffHours="";
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
			java.util.Date d1 = null;
			java.util.Date d2 = null;
			
			d1 = format.parse(previous_time);
			d2 = format.parse(new_Time);
			
			long diff = d2.getTime() - d1.getTime();
			System.out.println("Time Difference is-->"+diff);
			diffHours = String.format("%d", TimeUnit.MILLISECONDS.toHours(diff));
			System.out.println("MILLISECONDS Difference in hours"+diffHours);
		
		}
		catch(Exception e)
		{
			System.out.println("Exception in UserDAO-->getHours(String previous_time,String new_Time)( ): "+ e);
		}
		return diffHours;
	}
}
	
	/*public static void main(String asdf[])
	{
		writeOnFile("nitin.txt", "This is test", null);
	}
}*/
