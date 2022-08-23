package com.Database;

public class XOR_Operation {

	public static byte[] xorWithData(byte[] a, byte[] key)
	  {
		 
		System.out.println("Start for XOR");
	        
	        byte[] out = new byte[key.length];
	        for (int i = 0; i < key.length; i++) 
	        {
	        	if(i<a.length)
	        	{
	        		 out[i] = (byte) (a[i] ^ key[i]);
	        	}
	        	else
	        		 out[i] =  key[i];    
	        }
	    
	        return out;
	  }
	
	public static void main(String[] args) 
	{
		String s1="Bangalore is a Garden City in Karnataka";
		String s2="101"+"~"+"amutha"+"~"+"9066172779"+"~"+"9066172779";
		
		byte out[]=xorWithData(s1.getBytes(), s2.getBytes());
		String s3=new String(out);
		
		System.out.println("XOR Data :"+s3);
		
		byte out1[]=xorWithData(s1.getBytes(), s3.getBytes());
		
		String s4=new String(out1);
		System.out.println("Output :"+s4.trim());
		
	}
}
