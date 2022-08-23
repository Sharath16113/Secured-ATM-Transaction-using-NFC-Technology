/*
 *  IMAGE EXTRACTION LIBRARY
 *
 *  DISCOVIR - Distributed Content-based Visual Information Retrieval System on Peer-to-Peer(P2P) Network
 *  http://www.cse.cuhk.edu.hk/~miplab/discovir
*/

/*		
	processing 100 images(370 x 250)
	Total memory claim by VM = 1984 K
	Free memory available in VM = 1716 K
	Testing speed...
	Total Time used = 23764 ms
	Time for each image = 237 ms
	min distance is 0.18019771146052965
	max distance is 21.012542215204405
	Top 10% distance is 1.6012361899924035
	Top 20% distance is 2.2990081659643327
	Top 30% distance is 3.0640179692725904
	Top 40% distance is 4.0045786635122695
	Total memory claim by VM = 9272 K
	Free memory available in VM = 423 K
*/
package com.util.biometric;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

import javax.imageio.ImageIO;



/**
 * It is a sub-class of the FeatureExtractionModule class.
 * This class perform the feature extraction by analysing the cooccurence matrix.
 * The dimension of it is 20.
 * @author Munna Kumar Singh
 * @modified Munna Kumar Singh
 */
 
public class TextureCoOcurrence 
{
	final static int GRAY_LEVEL = 256;	// number of XY shift
	static final int NUM_TYPE = 5;
	final static int NUM_SHIFT = 4;
	final static int[][] XYSHIFT = {{1,1},{4,4},{9,9},{16,16}};
	
	// Initializing
	public static String featureName = "Cooccurence";
	public static int featureLength = NUM_TYPE * NUM_SHIFT;           //set to 20
	public static String featureCategory = "texture";
	public static Double featureVersion = new Double(1.0);
	public static String featureDescription = "Get the coocurence.";;
	
/*
 * Get the feature vector using default parameters
 * It will return a 20-d vector
 *
 * @param image the image to be processed
 * @return 20-dimension vector representing the image.
 */
	public static Vector getFeatureVector(BufferedImage image)
	{
		double coMatrix[][] = new double[NUM_SHIFT][];
		Vector v = new Vector(featureLength);
		int i;

		// Get the cooccurence matrices for the default parameters
		for (i = 0; i < NUM_SHIFT; i++)
		{
			coMatrix[i] = getCooccurenceMatrix(image, XYSHIFT[i][0], XYSHIFT[i][1]);
		}
		
		// By using the cooccurence matrices to calculate the feature vector
		// using different type of statistical analysis
		for (i = 0; i < NUM_SHIFT; i++)
		{
			// maximum probability
			v.add(new Double(analyseMatrix(coMatrix[i], 1)));
			// first order element difference moment
			v.add(new Double(analyseMatrix(coMatrix[i], 2)));
			// first order inverse element difference moment
			v.add(new Double(analyseMatrix(coMatrix[i], 5)));
			// entropy
			v.add(new Double(analyseMatrix(coMatrix[i], 8)));
			// uniformity
			v.add(new Double(analyseMatrix(coMatrix[i], 9)));
		}

		return v;
	}


/*
 * Get the feature vector using the parameters inputted
 *
 * @param image image to be processed
 * @param p shift in x direction
 * @param q shift in y direction
 * @return  5d vector for the 5 type of default statistical analysis
*/
	public Vector getFeatureVector(BufferedImage image, int p, int q)
	{
		double coMatrix[] = getCooccurenceMatrix(image, p, q);
		featureLength = NUM_TYPE;
		Vector v = new Vector(featureLength);

		int i;

		// By using the cooccurence matrices to calculate the feature vector
		// using different type of statistical analysis	
		// maximum probability
		v.add(new Double(analyseMatrix(coMatrix, 1)));
		// first order element difference moment
		v.add(new Double(analyseMatrix(coMatrix, 2)));
		// first order inverse element difference moment
		v.add(new Double(analyseMatrix(coMatrix, 5)));
		// entropy
		v.add(new Double(analyseMatrix(coMatrix, 8)));
		// uniformity
		v.add(new Double(analyseMatrix(coMatrix, 9)));

		return v;
	}

/*
 * This method is used to get the cooccurence matrix.
 *
 * @param image image to be processed
 * @param xshift shift in x direction
 * @param yshift shift in y direction
 * @return  a 1-d vector of size (image.width * image.height)
 */
	private static double[] getCooccurenceMatrix(BufferedImage image, int xshift, int yshift)
	{
		int i, j, total = 0;
		int gray1, gray2;
		int width = image.getWidth(), height = image.getHeight();
		int pixels[] = getPackedRGBPixel(image);
		int[] gray_pixels = ColorConversion.RGB2grayscale(pixels, GRAY_LEVEL);
		double coMatrix[] = new double[GRAY_LEVEL * GRAY_LEVEL];

		// initialize the cooccurence matrix
		for (i = 0; i < GRAY_LEVEL; i++)
		{
			for (j = 0; j < GRAY_LEVEL; j++)
			{
				coMatrix[i*GRAY_LEVEL+j] = 0;
			}
		}

		// for each pixel compare the gray level of another pixel
		for (i = 0; i < height; i++)
		{
			for (j = 0; j < width; j++)
			{
				if (!((j + xshift >= width) || (j + xshift < 0) ||
				      (i + yshift >= height) || (i + yshift < 0)))
				{
					// Get the gray level of the first pixel
					gray1 = gray_pixels[i*width + j];
					// Get the gray level of the second pixel
					gray2 = gray_pixels[(i+yshift) * width + j + xshift];
					// update the cooccurence matrix
					coMatrix[gray1*GRAY_LEVEL+gray2]++;
					total++;
				}
			}
		}

		// Convert the number of occurence in the matrix to joint probability
		for (i = 0; i < GRAY_LEVEL; i++)
		{
			for (j = 0; j < GRAY_LEVEL; j++)
			{
				coMatrix[i*GRAY_LEVEL+j] = (double)coMatrix[i*GRAY_LEVEL+j] / (double)total;
			}
		}

		return coMatrix;
	}

/**
 * Get the packed pixel content of whole image
 * return int[] - an array showing the [(packedRGB)(packedRGB)(packedRGB)....] value of the image in a row by row manner
 */
	public static int[] getPackedRGBPixel (BufferedImage image) 
	{
		return image.getRGB(0,0,image.getWidth(),image.getHeight(),null,0,image.getWidth());
	}
	
/* 
 * This method analyzes the matrix using the inputted type of statistical method
 *
 * @param coMatrix the cooccurence matrix
 * @param type
 * 1 maximum probability
 * 2 first order element difference moment
 * 3 second order element difference moment
 * 4 third order element difference moment
 * 5 first order inverse element difference moment
 * 6 second order inverse element difference moment
 * 7 third order inverse element difference moment
 * 8 entropy
 * 9 uniformity
 * @return a double value representing corresponding moment
 */
	public static double analyseMatrix(double[] coMatrix, int type)
	{
		double sum = 0;
		int i,j;

		switch (type)
		{
			// maximum probability
			case 1:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < GRAY_LEVEL; j++)
					{
						if (coMatrix[i*GRAY_LEVEL+j]>sum)
						{
							sum = coMatrix[i*GRAY_LEVEL+j];
						}
					}
				}
				break;
			
			// first order element difference moment
			case 2:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < 256; j++)
					{
						sum += coMatrix[i * GRAY_LEVEL + j] * Math.abs(i-j);
					}
				}
				break;

			// second order element difference moment
			case 3:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < GRAY_LEVEL; j++)
					{
						sum += coMatrix[i*GRAY_LEVEL+j] * Math.pow(Math.abs(i-j), 2);
					}
				}
				break;

			// third order element difference moment
			case 4:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < GRAY_LEVEL; j++)
					{
						sum += coMatrix[i*256+j] * Math.pow(Math.abs(i-j), 3);
					}
				}
				break;

			// first order inverse element difference moment
			case 5:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < GRAY_LEVEL; j++)
					{
						sum += coMatrix[i*GRAY_LEVEL+j] / (1 + Math.abs(i-j));
					}
				}
				break;

			// second order inverse element difference moment
			case 6:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < GRAY_LEVEL; j++)
					{
						sum += coMatrix[i*GRAY_LEVEL+j] / (1 + Math.pow(Math.abs(i-j),2));
					}
				}
				break;

			// third order inverse element difference moment
			case 7:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < GRAY_LEVEL; j++)
					{
						sum += coMatrix[i*GRAY_LEVEL+j] / (1 + Math.pow(Math.abs(i-j), 3));
					}
				}
				break;

			// entropy
			case 8:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < GRAY_LEVEL; j++)
					{
						if (coMatrix[i * GRAY_LEVEL + j] != 0)
						{
							sum += coMatrix[i*GRAY_LEVEL+j] * Math.log(coMatrix[i*GRAY_LEVEL+j]);
						}
					}
				}
				sum = -sum;
				break;

			// uniformity
			case 9:
				for (i = 0; i < GRAY_LEVEL; i++)
				{
					for (j = 0; j < GRAY_LEVEL; j++)
					{
						sum += coMatrix[i*GRAY_LEVEL+j] * coMatrix[i*GRAY_LEVEL+j];
					}
				}
				break;

			default:
				break;
		}
	
		//return sum;
		
		//Enhancement (Starts)
			//sum = roundTwoDecimals(sum);//Rounding To 2 Decimal Points
			sum = round4Decimals(sum);//Rounding To 4 Decimal Points
			return sum;
		//Enhancement(Ends)
	}

	public static BufferedImage readImage(String filePath)
	{
        BufferedImage img = null;
        try 
        {
            img = ImageIO.read(new File(filePath));
        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
        return img;
    }
	
	public static double roundTwoDecimals(double d) 
	{
		//double number = 651.5176515121351;
	    //The output will be 651.52
	    DecimalFormat twoDForm = new DecimalFormat("#.##");
	    return Double.valueOf(twoDForm.format(d));
	}
	
	public static double round4Decimals(double d) 
	{
	    DecimalFormat twoDForm = new DecimalFormat("#.####");
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
	
/** Get the threshold value of the image
 *
 * @return threshold value
 */
	public double getThreshold() 
	{
		return 4;
	}
	
	
	 
/* Testing The Development */	
	
public static void main(String[] args) 
{
	String filePath = "Files/Search/test.jpg";
	BufferedImage image = TextureCoOcurrence.readImage(filePath);
	Vector v = TextureCoOcurrence.getFeatureVector(image);
	System.out.println("Fetaute Value : \n"+v);
}

}