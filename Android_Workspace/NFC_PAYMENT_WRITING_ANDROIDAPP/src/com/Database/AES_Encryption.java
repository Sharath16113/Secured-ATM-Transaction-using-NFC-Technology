package com.Database;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES_Encryption {
	
	private static final int IV_LENGTH=16;

	/* A helper - to reuse the stream code below - if a small String is to be encrypted */
	public static String encrypt(String plainText, String password) throws Exception 
	{
		ByteArrayInputStream bis = new ByteArrayInputStream(plainText.getBytes("UTF8"));
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		encrypt(bis, bos, password);
		return bos.toString();
	}


	public static String decrypt(String cipherText, String password) throws Exception 
	{
		byte[] cipherTextBytes = cipherText.getBytes();
		ByteArrayInputStream bis = new ByteArrayInputStream(cipherTextBytes);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		decrypt(bis, bos, password);		
		return bos.toString();
	}
	public static void encrypt(InputStream in, OutputStream out, String password) throws Exception
	{

		SecureRandom r = new SecureRandom();
		byte[] iv = new byte[IV_LENGTH];
		r.nextBytes(iv);
		out.write(iv); //write IV as a prefix
		out.flush();
		//System.out.println(">>>>>>>>written"+Arrays.toString(iv));

		Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding"); //"DES/ECB/PKCS5Padding";"AES/CBC/PKCS5Padding"
		SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);    	

		out = new CipherOutputStream(out, cipher);
		byte[] buf = new byte[1024];
		int numRead = 0;
		while ((numRead = in.read(buf)) >= 0) 
		{
			out.write(buf, 0, numRead);
		}
		out.close();
	}


	public static void decrypt(InputStream in, OutputStream out, String password) throws Exception
	{

		byte[] iv = new byte[IV_LENGTH];
		in.read(iv);
		//System.out.println(">>>>>>>>red"+Arrays.toString(iv));

		Cipher cipher = Cipher.getInstance("AES/CFB8/NoPadding"); //"DES/ECB/PKCS5Padding";"AES/CBC/PKCS5Padding"
		SecretKeySpec keySpec = new SecretKeySpec(password.getBytes(), "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

		in = new CipherInputStream(in, cipher);
		byte[] buf = new byte[1024];
		int numRead = 0;
		while ((numRead = in.read(buf)) >= 0) 
		{
			out.write(buf, 0, numRead);
		}
		out.close();
	}
	public static void main(String[] args)
	{
		
		String str=101+"~"+"amm"+"~"+"9988776655"+"~"+"9900774455";
		try 
		{
			String encrypted_data = encrypt(str.trim(),"1111111111aaaaaa".trim());
			
			System.out.println("Encrypted "+encrypted_data);
			
			String decrypted_data = decrypt(encrypted_data.trim(), "1111111111aaaaaa");
			
			System.out.println("Decrypted "+decrypted_data);
			
			
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
