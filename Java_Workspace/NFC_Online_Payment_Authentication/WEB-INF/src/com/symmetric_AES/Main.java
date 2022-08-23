package com.symmetric_AES;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {

	public static void main(String[] args) 
	{
		//for String encryption=============================
		try 
		{
			
			// Create encrypter/decrypter class
			   AESCrypt  encrypter = new AESCrypt();
	
			// Encrypt
			String str="DHS";
			System.out.println("++++Original Text++++++"+str);
			String encrypted = encrypter.encrypt("Manu");
			
			System.out.println("++++ENCRYPTED++++++"+encrypted);
			String decrypted = encrypter.decrypt(encrypted);
			
			System.out.println("++++DECRYPTED++++++"+decrypted);
			
			
			

		}
		catch (Exception e) 
		{
		}
		
		
		
		
	}

}
