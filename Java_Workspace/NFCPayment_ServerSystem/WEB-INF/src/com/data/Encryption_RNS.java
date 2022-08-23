package com.data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encryption_RNS 
{
	public static String encryptMessage1(byte[] v,String key1,String key2) throws IOException
	{
		String c="";
		FileOutputStream fos = null;
			
			 for(int i=0;i<v.length;i++)
			  {
				 c = c + Encry(v[i],key1,key2) + "#";
				 
				 
			  }
			/* FileOutputStream fileOut1;
				try 
				{
					fileOut1 = new FileOutputStream(localFilePath1);
					
					fileOut1.write(c.getBytes());
					fileOut1.flush();
					fileOut1.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 */
		System.out.println("------C Value------"+c);	
		return c;
    }
	public static String Encry(int a,String key1,String key2)
	  {
		 
		  int m1=Integer.parseInt(key1);
		  int m2=Integer.parseInt(key2);
		
		 		  
		 int r1=a%m1;
		 int r2=a%m2;
		 System.out.println("str1"+r1);
		 System.out.println("str2"+r2);
		 String str=r1+"_"+r2;
		 System.out.println("str"+str);
		   
		return str;
   }
	
}
