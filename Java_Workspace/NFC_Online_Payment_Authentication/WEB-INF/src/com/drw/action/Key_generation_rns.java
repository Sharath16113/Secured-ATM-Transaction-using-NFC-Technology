package com.drw.action;

import java.math.BigInteger;





import sun.security.util.BigInt;



public class Key_generation_rns 
{
	static BigInteger m1;
	static  BigInteger m2;
	static String RNSkey;
	static BigInteger M = new BigInteger("1", 10);
	static BigInteger a1;
	static BigInteger a2;
	static BigInteger one = new BigInteger("1", 10);
	static BigInteger t1;
	static BigInteger t2;
	
	/*Key_generation_rns() throws ClassNotFoundException
	{
		Generation();
	}
	  */
	public static String Generation() throws ClassNotFoundException
	{
		boolean flag=true;

		Random_Values r = new Random_Values();
		m1 = r.KeyValue();
		m2= r.KeyValue();
		System.out.println("----m1----m2"+m1+m2);
		RNSkey=""+m1+"~"+m2;

		
		
	
		
		
		
		
		
		
		
		
		
		
		return RNSkey;
		
	}
	
	/*public static boolean SaveKeytoDB() throws ClassNotFoundException
	{
		 boolean flag=false;
		 String s = Key_generation_rns.Generation();
		 System.out.println("-----Key generated successfully------"+s);
		 //flag=SerializeToDatabase_rns.serializeJavaObjectToDB(b);
		   flag=StoreKeyToDatabase.storeKeyToDB(s);
		 if (flag==true)
		 {
			 System.out.println("----Key inserted to database successfully----"+flag);
		 }
		 return flag;
	}
	public static void main(String[] args) throws ClassNotFoundException
	{
	    String s = Key_generation_rns.Generation();
		
		System.out.println(s);
	}*/
}
