package com.data;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.Symmetric.cryptography_AES.AESCrypt;
import com.util.biometric.FingerPrint;
import com.util.biometric.FingerPrint.direction;

public class Fingerprint {
	
	
	private static String featureToEncrypt;
	private static String encrypted;

	public static String fingerprint(String filen)
	{
		
		//====================Extract the Features of the Finger Print=starts================
	
		 FingerPrint fingerprint1 = new FingerPrint(filen); 
			System.out.println("its cazme inside feature extraction>>>>>>>>>>>>>>>>>"+fingerprint1);
			
	            BufferedImage buffer11;
	            
	            // Print original image           
	            buffer11 = fingerprint1.getOriginalImage();
	           
	            // Print binary result           
	            fingerprint1.binarizeMean();
	            buffer11 = fingerprint1.toBufferedImage();
	            
	            // Print binary local result           
	            fingerprint1.binarizeLocalMean();
	            buffer11 = fingerprint1.toBufferedImage();
	            
	            // Remove noise
	            fingerprint1.removeNoise();
	            fingerprint1.removeNoise();
	            fingerprint1.removeNoise();
	            buffer11 = fingerprint1.toBufferedImage();
	            
	            // Skeletonization            
	            fingerprint1.skeletonize();
	           
	            // Direction
	            direction [][] dirMatrix = fingerprint1.getDirections();
	            buffer11 = fingerprint1.directionToBufferedImage(dirMatrix);
	            
	            // Core           
	            buffer11 = fingerprint1.directionToBufferedImage(dirMatrix);
	            Point core = fingerprint1.getCore(dirMatrix);
	            System.out.println("  Core.........."+core);
	           
	            int coreRadius = buffer11.getWidth() / 3;       
	            System.out.println(" Core Radius........"+coreRadius);
	           
	            // Minutiaes           
	            buffer11 = fingerprint1.directionToBufferedImage(dirMatrix);            
	            ArrayList<Point> intersections = fingerprint1.getMinutiaeIntersections(core, coreRadius);
	            ArrayList<Point> endPoints = fingerprint1.getMinutiaeEndpoints(core, coreRadius);
	            System.out.println(" MinutiaeIntersections......."+intersections);
	            System.out.println(" MinutiaeEndpoints............"+endPoints); 
	            
			 int count_intersection=intersections.size();
	         int count_endpoints=endPoints.size();
	         
	         featureToEncrypt=count_intersection+"~"+count_endpoints;
	         System.out.println("priya finger print featureToEncrypt>>>>>>>>>>>>>>>>>"+featureToEncrypt);
	         
    AESCrypt  encrypter = new AESCrypt();
		try {
			String encrypted = encrypter.encrypt(featureToEncrypt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
    return featureToEncrypt;
	
	//====================Extract the Features of the Finger Print==ends===============
	
	}

}
