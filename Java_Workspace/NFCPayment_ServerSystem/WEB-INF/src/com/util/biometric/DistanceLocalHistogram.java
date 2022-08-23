/**
 @Author :
 Date : Dec 19, 2013
 File : Distance.java
 Package : com.util
*/

package com.util.biometric;

import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.util.Vector;

public class DistanceLocalHistogram
{
	public static double getDistanceImgA_ImgB(Vector<Double> featureVector1,Vector<Double> featureVector2)
	{
		int n = 0;
		double diff=0,diffI1nI2=0,distance = 0;//Always 0-255
		
		try 
		{
			/*//Reference
				//Math.pow ( x,y ); // x^y 		Ex: Math.pow ( 3,2 ); // 3^2 = 9
				System.out.println("3^2 = " + Math.pow ( 3,2 ));
				System.out.println("Math.sqrt(" + 9 + ") = " + Math.sqrt(9));//sqrt(9)=3.0
			*/
			
			n = featureVector1.size();
			
			for (int i = 0; i < n; i++) 
			{
				diff = featureVector1.get(i)-featureVector2.get(i);
				diffI1nI2 = Math.pow(diff,2);
				distance += diffI1nI2; 
			}
			
			distance = distance/n;
			
			
			
			distance = Math.sqrt(distance);
			System.out.println("getDistanceImgA_ImgB   "+distance);
			
			
			
			
			//Rounding To 2 Decimal Points
			distance = roundTwoDecimals(distance);
		}
		catch (Exception e) 
		{
			System.out.println("Opps,Exception In util-DistanceLocalHistogram==>getDistanceImgA_ImgB() :");
			e.printStackTrace();
		}
		
		return distance;
	}
	
	public static double roundTwoDecimals(double d) 
	{
		//double number = 651.5176515121351;
	    //The output will be 651.52
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
	    return Double.valueOf(twoDForm.format(d));
	}
	
	public static double round2Decimals(double d) 
	{
		//double number = 651.5176515121351;
		//The output will be 651.52
		
		d = Math.round(d * 100);
		d = d/100;
		return d;
	}
	
	
/* Testing The Development */	
	
	/*public static void main(String[] args)
	{
		
		BufferedImage img1 = null,img2 = null;
		String filePath1 = "Files/Search/test.jpg";
		//String filePath2 = "Files/Search/check.jpg";
		String filePath2 = "Files/Search/tieatie.jpg";
		
		img1 = LocalColorHistogram.readImage(filePath1);
		img2 = LocalColorHistogram.readImage(filePath2);
		
		Vector<Double> featureVector1 = LocalColorHistogram.getFeatureVector(img1);
		Vector<Double> featureVector2 = LocalColorHistogram.getFeatureVector(img2);
		
		double dist = getDistanceImgA_ImgB(featureVector1,featureVector2);
		
		System.out.println("Distance : " + dist);
	}*/
}
