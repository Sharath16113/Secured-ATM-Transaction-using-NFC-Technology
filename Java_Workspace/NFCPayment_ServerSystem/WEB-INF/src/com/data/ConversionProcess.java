package com.data;

import java.io.*;

public class ConversionProcess 
{
    public static byte[] toByteArray(File file) 
    {  
        int length = (int) file.length();  
        byte[] array = new byte[length];  
        InputStream in;
		try 
		{
			in = new FileInputStream(file);
			int offset = 0;  
	        while (offset < length) 
	        {  
	            offset += in.read(array, offset, (length - offset)); 
	            
	            System.out.println("??????????? "+offset);
	        }  
	        in.close();
	        
	        System.out.println("Test ---------");
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}  
          
        return array;  
    }  
}
