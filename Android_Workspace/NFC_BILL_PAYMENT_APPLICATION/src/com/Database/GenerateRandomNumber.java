

package com.Database;
import java.util.Random;

public class GenerateRandomNumber 
{
	public static int generate4digitNumber() throws Exception 
	{  
		Random generator = new Random();  
		generator.setSeed(System.currentTimeMillis());  
		   
		int num = generator.nextInt(999) + 999;  
		if (num < 1000 || num > 9999) 
		{  
			num = generator.nextInt(999) + 999;  
			if (num < 1000 || num > 9999) 
			{  
				throw new Exception("Unable to generate PIN at this time..");  
			}  
		}  
		return num;  
   }
	
   /* Generating 6 Digit Pin Number */
	
	public static int generatePin() throws Exception 
	{  
		Random generator = new Random();  
		generator.setSeed(System.currentTimeMillis());  
		   
		int num = generator.nextInt(99999) + 99999;  
		if (num < 100000 || num > 999999) 
		{  
			num = generator.nextInt(99999) + 99999;  
			if (num < 100000 || num > 999999)
			{  
				throw new Exception("Unable to generate PIN at this time..");  
			}  
		}  
		return num;
	}
	
	public static void main(String[] args) throws Exception
	{
		System.out.println("4 Digit Random Number : " + generate4digitNumber());
		System.out.println("6 Digit Pin Number : " + generatePin());
	}
}
